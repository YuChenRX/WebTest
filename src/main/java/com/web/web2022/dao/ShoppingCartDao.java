package com.web.web2022.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.web2022.model.domain.ShoppingCart;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartDao extends BaseMapper<ShoppingCart> {
}
