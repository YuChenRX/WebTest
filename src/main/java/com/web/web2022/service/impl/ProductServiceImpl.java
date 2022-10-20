package com.web.web2022.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.web2022.dao.ProductDao;
import com.web.web2022.event.ProductVisitedEvent;
import com.web.web2022.mapper.ProductMapper;
import com.web.web2022.model.domain.Product;
import com.web.web2022.model.dto.ProductDto;
import com.web.web2022.model.enumeration.SortBy;
import com.web.web2022.model.enumeration.ProductType;
import com.web.web2022.service.ProductService;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public List<ProductDto.Out> find(ProductDto.In.QueryParams params) {
        LambdaQueryWrapper<Product> condition = new LambdaQueryWrapper<>();

        condition.eq(
            params.getCategoryId() != null,
            Product::getCategoryId,
            params.getCategoryId()
        );
        condition.isNotNull(params.getType() == ProductType.CREDIT, Product::getCredit);

        condition.orderBy(params.getSortBy() == SortBy.DEFAULT, true, Product::getId);
        condition.orderBy(params.getSortBy() == SortBy.TIME, true, Product::getCreatedAt);
        condition.orderBy(params.getSortBy() == SortBy.SOLD_COUNT, true, Product::getSoldCount);
        condition.orderBy(params.getSortBy() == SortBy.PRICE, true, Product::getPrice);

        return baseMapper
            .selectPage(new Page<>(params.getPage(), 10), condition)
            .getRecords()
            .stream()
            .map(ProductMapper.INSTANCE::asDto)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDto.Out> findOne(int id) {
        Optional<Product> product = Optional.ofNullable(getById(id));

        product.ifPresent(p -> eventPublisher.publishEvent(new ProductVisitedEvent(this, p)));

        return product
            .map(ProductMapper.INSTANCE::asDto);
    }
}
