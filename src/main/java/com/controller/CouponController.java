package com.controller;

import com.pojo.Coupon;
import com.pojo.Coutouser;
import com.pojo.User;
import com.result.Result;
import com.result.ResultFactory;
import com.service.CouponService;
import com.service.CoutouserService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Autowired
    private CoutouserService coutouserService;

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/listCoupon/{id}")
    public Result getCoupon(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(couponService.getCoupon(id));
    }
    @CrossOrigin
    @ResponseBody
    @PostMapping("api/uppriceBycoupon/{kid}/{uid}")
    public Result uppriceBycoupon(  Coupon coupon,@PathVariable("kid") Integer kid,@PathVariable("uid") Integer uid){
       Coupon c1= couponService.GetCouponByname(coupon.getCouponname());
        BigDecimal a= coupon.getPrice();
        double price = a.doubleValue();
       List<Coutouser> coutouser= coutouserService.getAllCoutouser(uid);
       if (coutouser.isEmpty()) {
           return ResultFactory.buildFailResult("用户名错误");
       }
        switch (c1.getCouponid()){
            case  1:
                if (price>=100) {
                    price=price-20;
                    break;
                }else {
                    return ResultFactory.buildFailResult("购买价格小于最低标准");
                }
            case  2:
                if (price>=500) {
                    price=price-100;
                    break;
                }else {
                    return ResultFactory.buildFailResult("购买价格小于最低标准");
                }
            case  3:
                if (price>=100) {
                    price=price-50;
                    break;
                }else {
                    return ResultFactory.buildFailResult("购买价格小于最低标准");
                }
            case  4:
                if (price>=1) {
                    price=price-10;
                    break;
                }else {
                    return ResultFactory.buildFailResult("购买价格小于最低标准");
                }
                default : break;
        }
        BigDecimal aw=  BigDecimal.valueOf(price);

        return ResultFactory.buildSuccessResult(aw);
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/Couponlist")
    public Result getAllCoupon(){
        return ResultFactory.buildSuccessResult(couponService.getAllCoupon());
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/addCoupon",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Result addCoupon( Coupon user, HttpSession sessionone, HttpServletRequest request){
        return ResultFactory.buildSuccessResult(couponService.addCoupon(user));
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping("api/modCoupon")
    public Result modifyCoupon( Coupon user){
        return ResultFactory.buildSuccessResult(couponService.modifyCoupon(user));
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/delCoupon/{id}")
    public Result deleteCoupon(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(couponService.deleteCoupon(id));
    }
}
