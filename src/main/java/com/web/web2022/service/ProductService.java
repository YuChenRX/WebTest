package com.web.web2022.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web.web2022.model.domain.Product;
import com.web.web2022.model.dto.ProductDto;
import com.web.web2022.model.enumeration.SortBy;
import com.web.web2022.model.enumeration.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductService extends IService<Product> {
    List<ProductDto.Out> find(ProductDto.In.QueryParams params);

    Optional<ProductDto.Out> findOne(int id);
}
