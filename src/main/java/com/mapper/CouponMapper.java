package com.mapper;

import com.pojo.Collect;
import com.pojo.Coupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CouponMapper {
    Coupon getCoupon(Integer id);

    boolean addCoupon(Coupon coupon);

    boolean editCoupon(Coupon coupon);

    boolean deleteCoupon(Integer id);

    List<Coupon> getAllCoupon();

    Coupon getCouponByname(String name);
}
