package com.web.web2022.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.web2022.dao.ShoppingCartDao;
import com.web.web2022.mapper.ShoppingCartMapper;
import com.web.web2022.model.domain.ShoppingCart;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.ShoppingCartDto;
import com.web.web2022.service.ShoppingCartService;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartDao, ShoppingCart> implements ShoppingCartService {
    protected boolean isConflict(User user, int skuId) {
        LambdaQueryWrapper<ShoppingCart> condition = new LambdaQueryWrapper<ShoppingCart>()
            .eq(ShoppingCart::getUserId, user.getId())
            .eq(ShoppingCart::getSkuId, skuId);

        return this.getOne(condition) != null;
    }

    protected ShoppingCartDto.Out increaseAmount(User user, int skuId, int amount) {
        LambdaQueryWrapper<ShoppingCart> condition = new LambdaQueryWrapper<ShoppingCart>()
            .eq(ShoppingCart::getUserId, user.getId())
            .eq(ShoppingCart::getSkuId, skuId);

        ShoppingCart item = getOne(condition);

        ShoppingCartDto.In.Update updateDto = ShoppingCartMapper
            .INSTANCE
            .asUpdateDto(item)
            .toBuilder()
            .amount(item.getAmount() + amount)
            .build();

        return update(user, item.getId(), updateDto);
    }

    @Override
    public ShoppingCartDto.Out add(User user, ShoppingCartDto.In.Addition dto) {
        if (isConflict(user, dto.getSkuId())) {
            return increaseAmount(user, dto.getSkuId(), dto.getAmount());
        }

        ShoppingCart shoppingCart = ShoppingCartMapper
            .INSTANCE
            .as(dto)
            .toBuilder()
            .userId(user.getId())
            .build();

        save(shoppingCart);

        return ShoppingCartMapper.INSTANCE.asDto(shoppingCart);
    }

    @Override
    public void remove(User user, int id) {
        LambdaUpdateWrapper<ShoppingCart> condition = new LambdaUpdateWrapper<ShoppingCart>()
            .eq(ShoppingCart::getUserId, user.getId())
            .eq(ShoppingCart::getId, id);
        baseMapper.deleteByMap(new HashMap<>() {{
            put("user_id", user.getId());
            put("id", id);
        }});
    }

    @Override
    public ShoppingCartDto.Out update(User user, int id, ShoppingCartDto.In.Update dto) {
        ShoppingCart shoppingCart = ShoppingCartMapper
            .INSTANCE
            .as(dto)
            .toBuilder()
            .id(id)
            .userId(user.getId())
            .build();
        update(shoppingCart, new LambdaQueryWrapper<ShoppingCart>().eq(ShoppingCart::getId, id));
        return ShoppingCartMapper.INSTANCE.asDto(shoppingCart);
    }

    @Override
    public List<ShoppingCartDto.Out> find(User user) {
        LambdaQueryWrapper<ShoppingCart> condition = new LambdaQueryWrapper<ShoppingCart>()
            .eq(ShoppingCart::getUserId, user.getId());
        return list(condition)
            .stream()
            .map(ShoppingCartMapper.INSTANCE::asDto)
            .collect(Collectors.toList());
    }
}
