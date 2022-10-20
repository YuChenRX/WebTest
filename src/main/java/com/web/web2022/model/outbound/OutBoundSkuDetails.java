package com.web.web2022.model.outbound;

import com.web.web2022.model.domain.Sku;

import java.math.BigDecimal;

public class OutBoundSkuDetails {
    private final Sku model;

    public OutBoundSkuDetails(Sku model) {
        this.model = model;
    }

    public Integer getId() {
        return model.getId();
    }

    public String getIndexes() {
        return model.getIndexes();
    }

    public String getTitle() {
        return model.getTitle();
    }

    public BigDecimal getPrice() {
        return model.getPrice();
    }

    public Integer getStock() {
        return model.getStock();
    }

    public String getImage() {
        return model.getImage();
    }
}
