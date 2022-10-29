package com.service;

import com.mapper.CommoditytomoreMapper;
import com.mapper.CouponMapper;
import com.pojo.Commoditytomore;
import com.pojo.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommoditytomoreService {
    @Autowired
    private CommoditytomoreMapper commoditytomoreMapper;

    public Commoditytomore getCommoditytomore(Integer id){

        return commoditytomoreMapper.getCommoditytomore(id);
    }

    public boolean addCoupon(Commoditytomore coupon){
        return commoditytomoreMapper.addCommoditytomore(coupon);
    }

    public boolean modifyCoupon(Commoditytomore coupon) {
        return commoditytomoreMapper.editCommoditytomore(coupon);
    }

    public boolean deleteCoupon(Integer id) {
        return commoditytomoreMapper.deleteCommoditytomore(id);
    }

    public List<Commoditytomore> getAllCoupon(){

        return commoditytomoreMapper.getAllCommoditytomore();
    }
}
