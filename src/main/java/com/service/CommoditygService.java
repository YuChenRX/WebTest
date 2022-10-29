package com.service;

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
    private CommoditygMapper Commodityguigemapper;

    public List<Commodityg> getCommodityguige(Integer id){

        return Commodityguigemapper.getCommodityg(id);
    }

    public Commodityg GetCommoditygById(Integer id){

        return Commodityguigemapper.getCommoditygById(id);
    }
}
