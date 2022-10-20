package com.web.web2022.model.inbound;

/**
 * 获取商品列表时所需的参数
 * 1.起始商品的ID [默认为1：从开始获取]
 * 2.获取多少个商品的简要数据
 * 3.交易单位 0：货币 | 1：积分
 * 4.商品排序方式 [默认为0：默认排序]
 *
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/2 12:20
 */
public class InBoundMerchandiseList {
    private Long page = 0L;//分类页 [默认为1：从开始第一页获取]
    private Integer num = 5;//获取多少个商品的概要
    private Long typeId = null;//搜索此分类id下的商品 [默认为null] null：不做限制 | else：限定搜索的商品的分类
    private Byte sortType = 0;//商品排序方式 [默认为0] 0：销量排序 | 1：价格升序 | 2：价格降序 | 3：最新时间排序 | 4：浏览量排序

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Byte getSortType() {
        return sortType;
    }

    public void setSortType(Byte sortType) {
        this.sortType = sortType;
    }

    @Override
    public String toString() {
        return "InBoundMerchandiseList{" +
            "page=" + page +
            ", num=" + num +
            ", typeId=" + typeId +
            ", sortType=" + sortType +
            '}';
    }
}
