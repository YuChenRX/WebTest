package com.web.web2022.mapper;

import com.web.web2022.model.domain.Carousel;
import com.web.web2022.model.domain.Product;
import com.web.web2022.model.domain.Sku;
import com.web.web2022.model.dto.ProductDto;
import com.web.web2022.model.dto.SkuDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Mapper
public interface ProductMapper extends BaseMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto.Out asDto(Product model);

    default List<SkuDto.Out.Default> asSkuDto(Supplier<List<Sku>> supplier) {
        return supplier
            .get()
            .stream()
            .map(SkuMapper.INSTANCE::asDto)
            .collect(Collectors.toList());
    }

    default List<String> asCarousel(Supplier<List<Carousel>> supplier) {
        return supplier
            .get()
            .stream()
            .map(Carousel::getUrl)
            .collect(Collectors.toList());
    }
}
