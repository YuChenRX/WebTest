package com.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mapper.OrderClassMapper;
import com.pojo.OrderClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderClassService {
    @Autowired
    OrderClassMapper classMapper;

    public boolean add(int userid, int commodity, int status, int sum) {
        return classMapper.insert(new OrderClass().setStatus(status)
                .setSum(sum)
                .setUserid(userid)
                .setCommodityguigeid(commodity)
        ) > 0;
    }

    public List<OrderClass> getOrderClassByUserId(int userId) {
        return classMapper.selectList(new LambdaQueryWrapper<OrderClass>()
                .eq(OrderClass::getUserid, userId));
    }

    public List<Long> getStatusTotal(int userid){
        ArrayList<Long> arr = new ArrayList<>();
        arr.add(classMapper.selectCount(new LambdaQueryWrapper<OrderClass>()
                .eq(OrderClass::getStatus, 0)
                .eq(OrderClass::getUserid,userid)));



        arr.add(classMapper.selectCount(new LambdaQueryWrapper<OrderClass>()
                .eq(OrderClass::getStatus, 1)
                .eq(OrderClass::getUserid,userid)));
        arr.add(classMapper.selectCount(new LambdaQueryWrapper<OrderClass>()
                .eq(OrderClass::getStatus, 2)
                .eq(OrderClass::getUserid,userid)));
        arr.add(classMapper.selectCount(new LambdaQueryWrapper<OrderClass>()
                .eq(OrderClass::getStatus, 3)
                .eq(OrderClass::getUserid,userid)));
        arr.add(classMapper.selectCount(new LambdaQueryWrapper<OrderClass>()
                .eq(OrderClass::getStatus, 4)
                .eq(OrderClass::getUserid,userid)));
        return arr;
    }

}
