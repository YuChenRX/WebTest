package com.web.web2022.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.google.common.base.Suppliers;
import com.web.web2022.ApplicationContextHolder;
import com.web.web2022.dao.SkuDao;

import java.util.function.Supplier;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class OrderSku {
    @TableId(type = IdType.AUTO)
    int id;
    long orderId;
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
