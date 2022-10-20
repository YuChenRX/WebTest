package com.web.web2022.dao;

import com.web.web2022.model.domain.Session;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface SessionDao {
    Integer create(@Param("model") Session model);

    Optional<Session> findV(@Param("token") String token);

    void delete(@Param("token") String token);
}
