package com.web.web2022.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.web2022.model.domain.Sku;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SkuDao extends BaseMapper<Sku> {
    List<Sku> find(@Param("productId") Integer id);

    Optional<Sku> findById(@Param("id") Integer id);

    Integer reduceStock(@Param("id") Integer id, @Param("amount") Integer amount);
}
