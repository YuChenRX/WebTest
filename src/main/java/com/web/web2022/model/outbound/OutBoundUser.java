package com.web.web2022.model.outbound;

import com.web.web2022.model.domain.User;

import java.math.BigDecimal;

public class OutBoundUser {
    private final User user;


    public OutBoundUser(User user) {
        this.user = user;
    }


    public Integer getId() {
        return user.getId();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public String getName() {
        return user.getName();
    }

    public BigDecimal getBalance() {
        return user.getBalance();
    }

    public BigDecimal getCredit() {
        return user.getCredit();
    }

    public BigDecimal getToppedUpAmount() {
        return user.getToppedUpAmount();
    }

    public BigDecimal getExpenditure() {
        return user.getExpenditure();
    }
}
