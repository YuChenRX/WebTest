package com.web.web2022.dao;

import com.web.web2022.model.domain.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AddressDao {
    Integer create(@Param("model") Address model);

    Integer modify(@Param("model") Address model);

    void deleteById(@Param("id") Integer id, @Param("ownerId") Integer ownerId);

    List<Address> find(@Param("ownerId") Integer ownerId);

    Optional<Address> findById(@Param("id") Integer id, @Param("ownerId") Integer ownerId);

    Optional<Address> findDefault(@Param("ownerId") Integer ownerId);
}
