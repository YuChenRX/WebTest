package com.web.web2022.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.web2022.model.domain.Order;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao extends BaseMapper<Order> {
    @Insert("insert into `order`(created_at, price, state, user_id, sku_id, amount) values(#{order.createdAt}, #{order.price}, #{order.state}, #{order.userId}, #{order.skuId}, #{order.amount})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int add(@Param("order") Order order);
}
