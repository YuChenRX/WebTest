package com.web.web2022.model.inbound;

import com.web.web2022.model.domain.User;

import javax.validation.constraints.NotEmpty;

public class InBoundUser {
    private final User model = new User();


    public User getModel() {
        return model;
    }

    @NotEmpty
    public String getUsername() {
        return model.getUsername();
    }

    public void setUsername(String username) {
        model.setUsername(username);
    }

    @NotEmpty
    public String getPassword() {
        return model.getPassword();
    }

    public void setPassword(String password) {
        model.setPassword(password);
    }

    public String getName() {
        return model.getName();
    }

    public void setName(String name) {
        model.setName(name);
    }
}
