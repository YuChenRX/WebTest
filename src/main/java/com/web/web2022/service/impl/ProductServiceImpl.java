package com.web.web2022.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.web2022.dao.ProductDao;
import com.web.web2022.model.domain.Product;
import com.web.web2022.model.dto.ProductDto;
import com.web.web2022.service.ProductService;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public List<ProductDto.Out> find(ProductDto.In.QueryParams params) {
    }

    @Override
    public Optional<ProductDto.Out> findOne(int id) {
    }
}
