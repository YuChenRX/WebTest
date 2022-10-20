package com.web.web2022.repo;

import com.web.web2022.dao.SessionDao;
import com.web.web2022.model.domain.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SessionRepo {
    @Autowired
    private SessionDao sessionDao;

    public Integer create(Session model) {
        return sessionDao.create(model);
    }

    public Optional<Session> findV(String token) {
        return sessionDao.findV(token);
    }

    public void delete(String token) {
        sessionDao.delete(token);
    }
}
