package com.web.web2022.model.inbound;

/**
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/10 10:07
 */
public class InBoundLike {
    private Long mid;//需药移除的商品

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "InBoundLike{" +
                ", mid=" + mid +
                '}';
    }
}
