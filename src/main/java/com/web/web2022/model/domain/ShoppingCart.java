package com.web.web2022.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.google.common.base.Suppliers;
import com.web.web2022.ApplicationContextHolder;
import com.web.web2022.dao.ProductDao;
import com.web.web2022.dao.SkuDao;

import java.util.function.Supplier;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class ShoppingCart {
    @TableId(type = IdType.AUTO)
    int id;
    int productId;
    int skuId;
    int amount;
    int userId;

    @TableField(exist = false)
    Supplier<Product> product = Suppliers
        .memoize(() -> ApplicationContextHolder
            .getCtx()
            .getBean(ProductDao.class)
            .selectById(getProductId()));
    @TableField(exist = false)
    Supplier<Sku> sku = Suppliers
        .memoize(() -> ApplicationContextHolder
            .getCtx()
            .getBean(SkuDao.class)
            .findById(getSkuId())
            .orElseThrow());
}
