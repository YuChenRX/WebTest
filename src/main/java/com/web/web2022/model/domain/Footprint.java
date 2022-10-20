package com.web.web2022.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Suppliers;
import com.web.web2022.ApplicationContextHolder;
import com.web.web2022.dao.ProductDao;

import java.time.Instant;
import java.util.function.Supplier;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class Footprint {
    @TableId(type = IdType.AUTO)
    int id;
    int productId;
    int userId;
    Instant updatedAt;

    @TableField(exist = false)
    Supplier<Product> product = Suppliers
        .memoize(() -> ApplicationContextHolder
            .getCtx()
            .getBean(ProductDao.class)
            .selectOne(new LambdaQueryWrapper<Product>().eq(Product::getId, getProductId())));
}
