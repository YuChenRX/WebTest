package com.web.web2022.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.web2022.model.domain.Favourite;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavouriteDao extends BaseMapper<Favourite> {
}
