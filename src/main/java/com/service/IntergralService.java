package com.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.CommodityMapper;
import com.mapper.IntergralMapper;
import com.mapper.UserMapper;
import com.pojo.Commodity;
import com.pojo.Intergral;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IntergralService extends ServiceImpl<IntergralMapper, Intergral> {
    private final IntergralMapper intergralMapper;
    private final CommodityMapper commodityMapper;

    public Intergral getIntergral(Integer id){

        return intergralMapper.getIntergral(id);
    }

    public boolean addIntergral(Intergral intergral){
        return intergralMapper.addIntergral(intergral);
    }

    public boolean modifyIntergral(Intergral intergral) {
        return intergralMapper.editIntergral(intergral);
    }

    public boolean deleteIntergral(Integer id) {
        return intergralMapper.deleteIntergral(id);
    }

    public List<Intergral> getAllIntergral(){

//        return intergralMapper.getAllIntergral();
        List<Intergral> list = list();
        return list
            .stream()
            .peek(v -> v.setCommodity(commodityMapper.selectOne(new LambdaQueryWrapper<Commodity>().eq(
                Commodity::getCommodityID,
                v.getComid()
            ))))
            .collect(Collectors.toList());
    }
    public List<Intergral> getAllIntergerComm(){

        return intergralMapper.getAllIntergralComm();
    }
    public Intergral getIntergralbycomid(Integer id){

        return intergralMapper.getIntergralbycomid(id);
    }


}
