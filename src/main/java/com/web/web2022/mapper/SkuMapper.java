package com.web.web2022.mapper;

import com.web.web2022.model.domain.Sku;
import com.web.web2022.model.dto.SkuDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.function.Supplier;

@Mapper
public interface SkuMapper extends BaseMapper {
    SkuMapper INSTANCE = Mappers.getMapper(SkuMapper.class);

    default SkuDto.Out.Default asDto(Supplier<Sku> supplier) {
        return asDto(as(supplier));
    }

    SkuDto.Out.Default asDto(Sku model);
}
