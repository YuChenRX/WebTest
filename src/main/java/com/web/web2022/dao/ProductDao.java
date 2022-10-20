package com.web.web2022.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.web2022.model.domain.Product;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProductDao extends BaseMapper<Product> {
    @Update("update product set visited_times = visited_times + 1 where id = #{id}")
    void increaseVisitedCount(@Param("id") int id);
}
