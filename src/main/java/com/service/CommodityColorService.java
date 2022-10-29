package com.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mapper.CommodityColorMapper;
import com.mapper.CommodityguigeMapper;
import com.pojo.CommodityColor;
import com.pojo.Commodityguige;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityColorService {
    @Autowired
    private CommodityColorMapper commodityColorMapper;

    public List<CommodityColor> getCommodityguige(Integer id){

        return commodityColorMapper.selectList(new LambdaQueryWrapper<CommodityColor>()
                .eq(CommodityColor::getComid, id));
    }
    public CommodityColor getCommodityColorById(Integer id){
        return commodityColorMapper.selectOne(new LambdaQueryWrapper<CommodityColor>()
                .eq(CommodityColor::getComid, id));
    }

}
