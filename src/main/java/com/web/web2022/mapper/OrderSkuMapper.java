package com.web.web2022.mapper;


import com.web.web2022.model.domain.OrderSku;
import com.web.web2022.model.dto.OrderSkuDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Mapper(uses = {SkuMapper.class})
public interface OrderSkuMapper extends BaseMapper {
    OrderSkuMapper INSTANCE = Mappers.getMapper(OrderSkuMapper.class);

    default OrderSkuDto.Out asDto(Supplier<OrderSku> supplier) {
        return asDto(as(supplier));
    }

    default List<OrderSkuDto.Out> asDtoList(Supplier<List<OrderSku>> supplier) {
        return asDto(as(supplier));
    }

    OrderSkuDto.Out asDto(OrderSku model);

    List<OrderSkuDto.Out> asDto(List<OrderSku> model);
}
