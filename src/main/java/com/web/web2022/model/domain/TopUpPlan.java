package com.web.web2022.model.domain;

import java.math.BigDecimal;

/**
 * 充值方案
 * 支持 充值 x 元 送 y 元
 */
public class TopUpPlan {
    private Integer id;
    private BigDecimal min;
    private BigDecimal extra;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getExtra() {
        return extra;
    }

    public void setExtra(BigDecimal extra) {
        this.extra = extra;
    }

    public BigDecimal total() {
        return min.add(extra);
    }
}
