package com.web.web2022.mapper;

import com.web.web2022.model.domain.Favourite;
import com.web.web2022.model.domain.Product;
import com.web.web2022.model.dto.FavouriteDto;
import com.web.web2022.model.dto.ProductDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.function.Supplier;

@Mapper
public interface FavouriteMapper extends BaseMapper {
    FavouriteMapper INSTANCE = Mappers.getMapper(FavouriteMapper.class);

    FavouriteDto.Out asDto(Favourite model);

}
