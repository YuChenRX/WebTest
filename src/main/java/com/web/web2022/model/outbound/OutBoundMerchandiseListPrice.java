package com.web.web2022.model.outbound;

import com.web.web2022.model.domain.Merchandise;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品列表的数据
 * 商品id
 * 商品图片
 * 商品名称
 * 商品原价格
 * 商品现价格
 * 商品上架时间
 *
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/2 8:41
 */
public class OutBoundMerchandiseListPrice {
    private final Merchandise merchandise;

    public OutBoundMerchandiseListPrice(Merchandise merchandise) {
        this.merchandise = merchandise;
    }

    public String getSingleUrl() {
        return merchandise.getSingleUrl();
    }

    public Long getMid() {
        return this.merchandise.getMid();
    }

    public String getName() {
        return this.merchandise.getName();
    }

    public BigDecimal getOldPrice() {
        return merchandise.getOldPrice();
    }

    public BigDecimal getPrice() {
        return this.merchandise.getPrice();
    }

    public Long getTime() {
        return this.merchandise.getTime();
    }

    public Long getBrowseNum() {
        return merchandise.getBrowseNum();
    }

    public Long getSalesNum() {
        return merchandise.getSalesNum();
    }

    public String getDescribe() {
        return merchandise.getDescribe();
    }

    @Override
    public String toString() {
        return "OutBoundMerchandiseList{" +
                "merchandise=" + merchandise +
                '}';
    }
}
