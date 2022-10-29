package com.service;

import com.mapper.CommodityguigeMapper;
import com.mapper.CouponMapper;
import com.pojo.Commodityguige;
import com.pojo.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommdityguigeService {
    @Autowired
    private CommodityguigeMapper Commodityguigemapper;

    public List<Commodityguige> getCommodityguige(Integer id){

        return Commodityguigemapper.getCommodityguige(id);
    }

    public boolean addCommodityguige(Commodityguige coupon){
        return Commodityguigemapper.addCommodityguige(coupon);
    }

    public boolean modifyCommodityguige(Commodityguige coupon) {
        return Commodityguigemapper.editCommodityguige(coupon);
    }

    public boolean upCommodityguige(Integer id) {
        return Commodityguigemapper.edCommodityguigej1(id);
    }

    public boolean deleteCommodityguige(Integer id) {
        return Commodityguigemapper.deleteCommodityguige(id);
    }

    public List<Commodityguige> getAllCommodityguige(){

        return Commodityguigemapper.getAllCommodityguige();
    }
}
