package com.web.web2022.model.outbound;

import com.web.web2022.model.domain.Banner;

public class OutBoundBanner {
    private final Banner model;


    public OutBoundBanner(Banner model) {
        this.model = model;
    }


    public Integer getId() {
        return model.getId();
    }

    public String getImage() {
        return model.getImage();
    }

    public Long getProductId() {
        return model.getProduct().getMid();
    }
}
