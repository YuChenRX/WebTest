package com.web.web2022.model.domain;

import java.util.List;

/**
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/5 13:30
 */
public class MerchandiseType {
    private Long tid;//分类id
    private String name;//分类名称
    private Long belongId;//父分类id (如若此id为null 则 为顶级分类)
    private String url;//分类对应的图片url
    private List<MerchandiseType> childTypeList;//子分类列表 null为低级分类

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBelongId() {
        return belongId;
    }

    public void setBelongId(Long belongId) {
        this.belongId = belongId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MerchandiseType> getChildTypeList() {
        return childTypeList;
    }

    public void setChildTypeList(List<MerchandiseType> childTypeList) {
        this.childTypeList = childTypeList;
    }

    @Override
    public String toString() {
        return "MerchandiseType{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", belongId=" + belongId +
                ", url='" + url + '\'' +
                ", childTypeList=" + childTypeList +
                '}';
    }
}
