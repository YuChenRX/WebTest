package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User getUser(Integer id);

    boolean addUser(User user);

    boolean modifyUser(User user);

    boolean deleteUser(Integer id);

    List<User> getAll();

    User getUserByName(String name);

    User getUserByNameAndPassword(@Param("uname") String name,@Param("upassword") String password);
}
