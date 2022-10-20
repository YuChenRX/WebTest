package com.web.web2022.model.outbound;

import com.web.web2022.model.domain.Address;

public class OutBoundAddress {
    private final Address model;

    public OutBoundAddress(Address model) {
        this.model = model;
    }

    public Integer getId() {
        return model.getId();
    }

    public String getName() {
        return model.getName();
    }

    public String getPhoneNumber() {
        return model.getPhoneNumber();
    }

    public String getProvince() {
        return model.getProvince();
    }

    public String getCity() {
        return model.getCity();
    }

    public String getAddressLine2() {
        return model.getAddressLine2();
    }

    public Boolean getDef() {
        return model.getDef();
    }

    public String getAreaCode() {
        return model.getAreaCode();
    }

    public String getAddressLine1() {
        return model.getAddressLine1();
    }
}
