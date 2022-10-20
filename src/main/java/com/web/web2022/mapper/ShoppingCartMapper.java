package com.web.web2022.mapper;

import com.web.web2022.model.domain.Product;
import com.web.web2022.model.domain.ShoppingCart;
import com.web.web2022.model.domain.Sku;
import com.web.web2022.model.dto.ProductDto;
import com.web.web2022.model.dto.ShoppingCartDto;
import com.web.web2022.model.dto.SkuDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.function.Supplier;

@Mapper
public interface ShoppingCartMapper {
    ShoppingCartMapper INSTANCE = Mappers.getMapper(ShoppingCartMapper.class);

    ShoppingCartDto.Out asDto(ShoppingCart model);

    ShoppingCartDto.In.Update asUpdateDto(ShoppingCart model);

    ShoppingCart as(ShoppingCartDto.In.Addition dto);

    ShoppingCart as(ShoppingCartDto.In.Update dto);


    default ProductDto.Out asProductDto(Supplier<Product> supplier) {
        return ProductMapper.INSTANCE.asDto(supplier.get());
    }

    default SkuDto.Out.Default asSkuDto(Supplier<Sku> supplier) {
        return SkuMapper.INSTANCE.asDto(supplier.get());
    }
}
