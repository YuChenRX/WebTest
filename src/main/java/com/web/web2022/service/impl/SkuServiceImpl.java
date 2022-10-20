package com.web.web2022.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.web2022.dao.OrderDao;
import com.web.web2022.dao.OrderSkuDao;
import com.web.web2022.dao.ProductDao;
import com.web.web2022.dao.SkuDao;
import com.web.web2022.dao.UserDao;
import com.web.web2022.mapper.ProductMapper;
import com.web.web2022.mapper.SkuMapper;
import com.web.web2022.model.domain.Order;
import com.web.web2022.model.domain.OrderSku;
import com.web.web2022.model.domain.Product;
import com.web.web2022.model.domain.Sku;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.SkuDto;
import com.web.web2022.model.enumeration.OrderState;
import com.web.web2022.service.SkuService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SkuServiceImpl extends ServiceImpl<SkuDao, Sku> implements SkuService {
    private final SkuDao skuDao;
    private final ProductDao productDao;
    private final UserDao userDao;
    private final OrderDao orderDao;
    private final OrderSkuDao orderSkuDao;

    @Override
    public SkuDto.Out.Calculator calc(List<SkuDto.In.Calc> dto) {
        BigDecimal total = new BigDecimal(0);
        List<SkuDto.Out.CalcItem> items = new ArrayList<>();

        for (SkuDto.In.Calc item : dto) {
            Sku one = skuDao.findById(item.getSkuId()).orElse(null);
            if (one == null || one.getStock() < item.getAmount()) {
                continue;
            }
            Product product = productDao.selectOne(new LambdaQueryWrapper<Product>().eq(
                Product::getId,
                one.getProduct().getMid()
            ));

            BigDecimal price = one.getPrice().multiply(new BigDecimal(item.getAmount()));
            total = total.add(price);
            SkuDto.Out.CalcItem calcItem = SkuDto.Out.CalcItem
                .builder()
                .sku(SkuMapper.INSTANCE.asDto(one))
                .amount(item.getAmount())
                .product(ProductMapper.INSTANCE.asDto(product))
                .build();
            items.add(calcItem);
        }

        return SkuDto.Out.Calculator
            .builder()
            .items(items)
            .price(total)
            .build();
    }

    @Override
    @Transactional
    public synchronized SkuDto.Out.Buying buy(User user, List<SkuDto.In.Calc> dto) {
        SkuDto.Out.Buying.BuyingBuilder resp = SkuDto.Out.Buying.builder();

        BigDecimal total = new BigDecimal(0);
        List<Order.OrderBuilder> orderBuilders = new ArrayList<>();

        for (SkuDto.In.Calc item : dto) {
            Sku one = skuDao.findById(item.getSkuId()).orElse(null);
            if (one == null || one.getStock() < item.getAmount()) {
                continue;
            }
            BigDecimal price = one.getPrice().multiply(new BigDecimal(item.getAmount()));
            total = total.add(price);

            Order.OrderBuilder orderBuilder = Order
                .builder()
                .state(OrderState.PAID)
                .createdAt(Instant.now())
                .userId(user.getId())
                .price(price)
                .amount(item.getAmount())
                .skuId(one.getId());
            orderBuilders.add(orderBuilder);
        }

        user = userDao.findById(user.getId()).orElseThrow();
        BigDecimal balance = user.getBalance();

        if (balance.compareTo(total) < 0) {
            return resp.ok(false).msg("余额不足").build();
        }

        user.setBalance(balance.subtract(total));
        userDao.modify(user);

        for (Order.OrderBuilder item : orderBuilders) {
            orderDao.add(item.build());
        }

        for (SkuDto.In.Calc item : dto) {
            skuDao.reduceStock(item.getSkuId(), item.getAmount());
        }

        return resp.ok(true).build();
    }
}
