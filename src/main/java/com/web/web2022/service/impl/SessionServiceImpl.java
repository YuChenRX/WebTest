package com.web.web2022.service.impl;

import com.web.web2022.repo.SessionRepo;
import com.web.web2022.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionRepo sessionRepo;

    @Override
    public void signOut(String token) {
        sessionRepo.delete(token);
    }
}
