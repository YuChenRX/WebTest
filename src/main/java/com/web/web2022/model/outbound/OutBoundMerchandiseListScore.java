package com.web.web2022.model.outbound;

import com.web.web2022.model.domain.Merchandise;

import java.util.List;

/**
 * 商品列表的数据
 * 1.商品id
 * 2.商品图片
 * 3.商品名称
 * 4.商品积分
 * 5.商品上架时间
 *
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/2 8:41
 */
public class OutBoundMerchandiseListScore {
    private final Merchandise merchandise;

    public OutBoundMerchandiseListScore(Merchandise merchandise) {
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

    public Long getScore() {
        return this.merchandise.getScore();
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

    @Override
    public String toString() {
        return "OutBoundMerchandiseList{" +
                "merchandise=" + merchandise +
                '}';
    }
}
