package com.web.web2022.model.inbound;

import com.web.web2022.model.domain.Address;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;

public class InBoundAddress {
    private final Address model = new Address();


    public Address getModel() {
        return model;
    }

    @Null
    public Integer getId() {
        return model.getId();
    }

    public void setId(Integer id) {
        model.setId(id);
    }

    @NotEmpty
    public String getName() {
        return model.getName();
    }

    public void setName(String name) {
        model.setName(name);
    }

    @Length(min = 11, max = 11)
    public String getPhoneNumber() {
        return model.getPhoneNumber();
    }

    public void setPhoneNumber(String phoneNumber) {
        model.setPhoneNumber(phoneNumber);
    }

    @NotEmpty
    public String getProvince() {
        return model.getProvince();
    }

    public void setProvince(String province) {
        model.setProvince(province);
    }

    @NotEmpty
    public String getCity() {
        return model.getCity();
    }

    public void setCity(String city) {
        model.setCity(city);
    }

    public Boolean getDef() {
        return model.getDef();
    }

    public void setDef(Boolean def) {
        model.setDef(def);
    }

    @NotEmpty
    public String getAreaCode() {
        return model.getAreaCode();
    }

    public void setAreaCode(String areaCode) {
        model.setAreaCode(areaCode);
    }

    public String getAddressLine2() {
        return model.getAddressLine2();
    }

    public void setAddressLine2(String addressLine2) {
        model.setAddressLine2(addressLine2);
    }

    @NotEmpty
    public String getAddressLine1() {
        return model.getAddressLine1();
    }

    public void setAddressLine1(String addressLine1) {
        model.setAddressLine1(addressLine1);
    }
}
