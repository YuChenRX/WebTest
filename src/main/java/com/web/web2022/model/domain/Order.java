package com.web.web2022.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Suppliers;
import com.web.web2022.ApplicationContextHolder;
import com.web.web2022.dao.OrderSkuDao;
import com.web.web2022.dao.SkuDao;
import com.web.web2022.model.enumeration.OrderState;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.function.Supplier;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
@TableName("`order`")
public class Order {
    @TableId(type = IdType.AUTO)
    long id;
    Instant createdAt;
    BigDecimal price;
    OrderState state;
    int userId;
    int skuId;
    int amount;

    @TableField(exist = false)
    Supplier<Sku> sku = Suppliers
        .memoize(() -> ApplicationContextHolder
            .getCtx()
            .getBean(SkuDao.class)
            .findById(getSkuId())
            .orElseThrow());
}
