package com.web.web2022.repo;

import com.web.web2022.dao.UserDao;
import com.web.web2022.model.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepo {
    @Autowired
    private UserDao userDao;

    public Optional<User> find(String username) {
        return userDao.find(username);
    }

    public Optional<User> findById(Integer id) {
        return userDao.findById(id);
    }

    public Integer create(User model) {
        return userDao.create(model);
    }

    public Integer modify(User user) {
        return userDao.modify(user);
    }
}
