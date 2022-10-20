package com.web.web2022.model.inbound;

/**
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/5 14:09
 */
public class InBoundMerchandiseType {
    private Long tid;//类型id
    private Long belongId;//父类型id

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getBelongId() {
        return belongId;
    }

    public void setBelongId(Long belongId) {
        this.belongId = belongId;
    }

    @Override
    public String toString() {
        return "InBoundMerchandiseType{" +
                "tid=" + tid +
                ", belongId=" + belongId +
                '}';
    }
}
