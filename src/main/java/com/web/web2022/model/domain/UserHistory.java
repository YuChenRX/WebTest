package com.web.web2022.model.domain;

/**
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/4 16:14
 */
public class UserHistory {
    private long id;//数据唯一id
    private long uid;//用户id
    private long mid;//商品id
    private long time;//浏览时间

    public UserHistory(long uid, long mid, long time) {
        this.uid = uid;
        this.mid = mid;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "id=" + id +
                ", uid=" + uid +
                ", mid=" + mid +
                ", time=" + time +
                '}';
    }
}
