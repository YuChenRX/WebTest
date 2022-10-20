package com.web.web2022.model.domain;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Session {
    private Integer id;
    private String token = UUID.randomUUID().toString();
    private Instant expireAt = Instant.now().plus(1, ChronoUnit.DAYS);
    private User owner;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Instant expireAt) {
        this.expireAt = expireAt;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
