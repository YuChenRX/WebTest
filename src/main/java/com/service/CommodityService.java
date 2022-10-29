package com.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.event.ProductVisitedEvent;
import com.mapper.CommodityMapper;
import com.mapper.CommodityguigeMapper;
import com.pojo.Commodity;

import com.pojo.Commodityguige;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommodityService extends ServiceImpl<CommodityMapper, Commodity> {
    private final CommodityguigeMapper commodityguigeMapper;
    private final CommodityMapper commodityMapper;
    private final ApplicationEventPublisher publisher;

    public Commodity getCommonity(Integer id){

        return commodityMapper.getCommodity(id);
    }

    public boolean addCommonity(Commodity commodity){
        return commodityMapper.addCommodity(commodity);
    }

    public boolean modifyCommonity(Commodity commodity) {
        return commodityMapper.editCommodity(commodity);
    }

    public boolean deleteCommonity(Integer id) {
        return commodityMapper.deleteCommodity(id);
    }

    public List<Commodity> getAll(){

//        return commodityMapper.getAllCommodity();
        return list();
    }
    public List<Commodity> getAllBytime(){

        return commodityMapper.selectList(new LambdaQueryWrapper<Commodity>()
                .orderBy(true,false,Commodity::getAdtime));
    }
    public List<Commodity> getAllByUP(){

        return null;
    }
    public List<Commodity> getAllByDown(){

        return commodityMapper.getAllcommodityByDownPerice();
    }

    public List<Commodity> getAllBytimeAndLimit(int value){

        return commodityMapper.getAllcommodityByTimeAndLimit(value);
    }
    public List<Commodity> getAllByUPAndLimit(int value){

        return commodityMapper.getAllcommodityByUpPericeAndLimit(value);
    }
    public List<Commodity> getAllByDownAndLimit(int value){

        return commodityMapper.getAllcommodityByDownPericeAndLimit(value);
    }

    public List<Commodity> getAllLimit(int value){

        return commodityMapper.getAllCommodityAndLimit(value);
    }

    public List<Commodity> getCommodityBycaid(int id){

//        return commodityMapper.getCommodityBycaid(id);
        LambdaQueryWrapper<Commodity> condition = new LambdaQueryWrapper<Commodity>()
            .eq(Commodity::getCaid, id);
        return list(condition);
    }

    public List<Commodity> getCommodityLike(String mh){

        return commodityMapper.getCommodityLike(mh);
    }

    public Object findOne(String source, int id, int uid) {
        LambdaQueryWrapper<Commodity> condition = new LambdaQueryWrapper<Commodity>()
            .eq(Commodity::getCommodityID, id);
        Commodity one = getOne(condition);

        List<Commodityguige> commodityguige = commodityguigeMapper.selectList(new LambdaQueryWrapper<Commodityguige>().eq(Commodityguige::getComid, id));
        one.setCommodityguigeList(commodityguige);


        if (source.equals("others")) {
            publisher.publishEvent(new ProductVisitedEvent(this, one, uid));
        }

        return one;
    }
}
