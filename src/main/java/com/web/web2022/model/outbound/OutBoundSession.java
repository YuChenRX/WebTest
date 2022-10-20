package com.web.web2022.model.outbound;

import com.web.web2022.model.domain.Session;

import java.time.Instant;

public class OutBoundSession {
    private final Session session;

    public OutBoundSession(Session session) {
        this.session = session;
    }

    public Integer getId() {
        return session.getId();
    }

    public String getToken() {
        return session.getToken();
    }

    public Instant getExpireAt() {
        return session.getExpireAt();
    }
}
