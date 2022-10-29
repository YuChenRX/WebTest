package com.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.UserMapper;
import com.mapper.UserPurseMapper;
import com.pojo.User;
import com.pojo.UserPurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPurseService extends ServiceImpl<UserPurseMapper, UserPurse> {
    @Autowired
    private UserPurseMapper userPurseMapper;

    public UserPurse getUserPurse(Integer id){

//        return userPurseMapper.getUserPurse(id);
        LambdaQueryWrapper<UserPurse> condition = new LambdaQueryWrapper<UserPurse>()
            .eq(UserPurse::getPid, id);
        return getOne(condition);
    }
    public UserPurse getUserPurseById(Integer id){
        return userPurseMapper.getUserPurselist(id);
    }
    public boolean Editcoupon(UserPurse userPurse){
        return userPurseMapper.editcoupon(userPurse);
    }

    public boolean addUserPurse(UserPurse userPurse){
        return userPurseMapper.addUserPurse(userPurse);
    }

    public boolean modifyUserPurse(UserPurse userPurse) {
//        return userPurseMapper.editUserPurse(userPurse);
        return updateById(userPurse);
    }


    public boolean upditUserPurseadd(UserPurse userPurse) {
        return userPurseMapper.editUserPurseadd(userPurse);
    }
    public boolean deleteUserPurse(Integer id) {
        return userPurseMapper.deleteUserPurse(id);
    }

    public List<UserPurse> getAllUserPurse(){

//        return userPurseMapper.getAllUserPurse();
        return list();
    }
    public List<UserPurse>selectALLUserPurse(){
        return userPurseMapper.selectALLUserPurse();
    }

    public Boolean modifyMoney(UserPurse userPurse) {
        return userPurseMapper.addMoney(userPurse);
    }


}
