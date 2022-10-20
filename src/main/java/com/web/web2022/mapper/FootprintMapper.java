package com.web.web2022.mapper;

import com.web.web2022.model.domain.Footprint;
import com.web.web2022.model.dto.FootprintDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FootprintMapper extends BaseMapper {
    FootprintMapper INSTANCE = Mappers.getMapper(FootprintMapper.class);

    FootprintDto.Out asDto(Footprint model);


}
