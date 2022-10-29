package com.service;

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
    private CommodityColorMapper Commodityguigemapper;

    public List<CommodityColor> getCommodityguige(Integer id){

        return Commodityguigemapper.getCommodityColor(id);
    }
    public CommodityColor getCommodityColorById(Integer id){

        return Commodityguigemapper.getCommodityColorById(id);
    }

}
