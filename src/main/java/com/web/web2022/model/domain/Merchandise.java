package com.web.web2022.model.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/2 12:58
 */
public class Merchandise {
    private Long mid;//商品id
    private String name;//商品名称
    private BigDecimal oldPrice;//商品原价
    private BigDecimal price;//商品现价
    private String describe;//商品描述
    private Long browseNum;//商品浏览量
    private Long salesNum;//商品销售量
    private Long score;//商品所需积分
    private Long typeId;//商品分类id
    private Long time;//商品上架时间（时间戳）
    private List<String> url;//商品详情轮播图url
    private String singleUrl;//商品列表图url
    private List<Sku> sku;
    private LinkedHashMap<String, List<Twister>> twister;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Long getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(Long browseNum) {
        this.browseNum = browseNum;
    }

    public Long getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(Long salesNum) {
        this.salesNum = salesNum;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSingleUrl() {
        return singleUrl;
    }

    public void setSingleUrl(String singleUrl) {
        this.singleUrl = singleUrl;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public List<Sku> getSku() {
        return sku;
    }

    public void setSku(List<Sku> sku) {
        this.sku = sku;
    }

    public LinkedHashMap<String, List<Twister>> getTwister() {
        return twister;
    }

    public void setTwister(LinkedHashMap<String, List<Twister>> twister) {
        this.twister = twister;
    }

    @Override
    public String toString() {
        return "Merchandise{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", oldPrice=" + oldPrice +
                ", price=" + price +
                ", describe='" + describe + '\'' +
                ", browseNum=" + browseNum +
                ", salesNum=" + salesNum +
                ", score=" + score +
                ", typeId=" + typeId +
                ", time=" + time +
                ", url=" + url +
                ", singleUrl='" + singleUrl + '\'' +
                ", skuDetails=" + sku +
                ", sku=" + twister +
                '}';
    }
}
