package com.service;

import com.mapper.CouponMapper;
import com.mapper.UserMapper;
import com.pojo.Coupon;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    @Autowired
    private CouponMapper couponMapper;

    public Coupon getCoupon(Integer id){

        return couponMapper.getCoupon(id);
    }

    public boolean addCoupon(Coupon coupon){
        return couponMapper.addCoupon(coupon);
    }

    public boolean modifyCoupon(Coupon coupon) {
        return couponMapper.editCoupon(coupon);
    }

    public boolean deleteCoupon(Integer id) {
        return couponMapper.deleteCoupon(id);
    }

    public List<Coupon> getAllCoupon(){

        return couponMapper.getAllCoupon();
    }

    public Coupon GetCouponByname(String name){

        return couponMapper.getCouponByname(name);
    }
}
