package com.web.web2022.mapper;

import com.web.web2022.model.domain.Product;
import com.web.web2022.model.dto.OrderSkuDto;
import com.web.web2022.model.dto.ProductDto;

import java.util.function.Supplier;

public interface BaseMapper {
    default <T> T as(Supplier<T> supplier) {
        return supplier.get();
    }

    default ProductDto.Out asProductDto(Supplier<Product> supplier) {
        return ProductMapper.INSTANCE.asDto(supplier.get());
    }

}
