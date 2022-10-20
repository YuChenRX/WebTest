package com.web.web2022.model.inbound;

/**
 * 商品信息API接收参数
 *
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/3 8:54
 */
public class InBoundMerchandiseInfo {
    private long uid;//用户id
    private long Mid;//商品id

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getMid() {
        return Mid;
    }

    public void setMid(long mid) {
        Mid = mid;
    }

    @Override
    public String toString() {
        return "InBoundMerchandiseInfo{" +
                "uid=" + uid +
                ", Mid=" + Mid +
                '}';
    }
}
