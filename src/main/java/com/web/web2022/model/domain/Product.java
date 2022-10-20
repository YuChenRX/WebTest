package com.web.web2022.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Suppliers;
import com.web.web2022.ApplicationContextHolder;
import com.web.web2022.dao.CarouselDao;
import com.web.web2022.dao.SkuDao;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Supplier;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Product {
    @TableId(type = IdType.AUTO)
    int id;
    String title;
    BigDecimal price;
    Integer credit;
    String description;
    int visitedTimes;
    int soldCount;
    Integer categoryId;
    LinkedHashMap<String, List<Twister>> specification;
    Instant createdAt;

    @TableField(exist = false)
    Supplier<List<Sku>> sku = Suppliers
        .memoize(() -> ApplicationContextHolder
            .getCtx()
            .getBean(SkuDao.class)
            .find(getId()));
    @TableField(exist = false)
    Supplier<List<Carousel>> carousel = Suppliers
        .memoize(() -> ApplicationContextHolder
            .getCtx()
            .getBean(CarouselDao.class)
            .selectList(new LambdaQueryWrapper<Carousel>().eq(Carousel::getProductId, getId())));
}
