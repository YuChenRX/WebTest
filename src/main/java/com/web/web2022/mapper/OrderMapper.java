package com.web.web2022.mapper;

import com.web.web2022.model.domain.Order;
import com.web.web2022.model.dto.OrderDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {SkuMapper.class})
public interface OrderMapper extends BaseMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto.Out.Default asDto(Order model);
}
