package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pojo.Collect;
import com.pojo.UserPurse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPurseMapper extends BaseMapper<UserPurse> {
    UserPurse getUserPurse(Integer id);

    UserPurse   getUserPurselist(Integer id);

    boolean addUserPurse(UserPurse userPurse);

    boolean editUserPurse(UserPurse userPurse);

    boolean editcoupon(UserPurse userPurse);
    boolean editUserPurseadd(UserPurse userPurse);

    boolean deleteUserPurse(Integer id);

    List<UserPurse> getAllUserPurse();

    List<UserPurse>selectALLUserPurse();


    Boolean addMoney(UserPurse userPurse);


}
