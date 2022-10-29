package com.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mapper.CommodityColorMapper;
import com.mapper.CommoditygMapper;
import com.pojo.CommodityColor;
import com.pojo.Commodityg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommoditygService {
    @Autowired
    private CommoditygMapper commoditygMapper;

    public List<Commodityg> getCommodityguige(Integer id){

        return commoditygMapper.selectList(new LambdaQueryWrapper<Commodityg>()
                .eq(Commodityg::getComid, id));
    }

    public Commodityg GetCommoditygById(Integer id){

        return commoditygMapper.getCommoditygById(id);
    }
}
