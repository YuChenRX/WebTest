package com.web.web2022.service;

import com.web.web2022.model.domain.Session;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.inbound.InBoundUser;

import java.util.Optional;

public interface UserService {
    Session signin(InBoundUser dto);

    Session signup(InBoundUser dto);

    User topUp(User user, Integer planId);

    Optional<User> findById(Integer id);
}
