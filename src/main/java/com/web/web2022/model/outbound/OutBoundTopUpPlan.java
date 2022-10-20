package com.web.web2022.model.outbound;

import com.web.web2022.model.domain.TopUpPlan;

import java.math.BigDecimal;

public class OutBoundTopUpPlan {
    private final TopUpPlan model;


    public OutBoundTopUpPlan(TopUpPlan model) {
        this.model = model;
    }


    public Integer getId() {
        return model.getId();
    }

    public BigDecimal getMin() {
        return model.getMin();
    }

    public BigDecimal getExtra() {
        return model.getExtra();
    }
}
