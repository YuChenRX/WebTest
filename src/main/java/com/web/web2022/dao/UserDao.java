package com.web.web2022.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.web2022.model.domain.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserDao extends BaseMapper<User> {
    Optional<User> find(@Param("username") String username);

    Optional<User> findById(@Param("id") Integer id);

    Integer create(@Param("model") User model);

    Integer modify(@Param("model") User user);
}
