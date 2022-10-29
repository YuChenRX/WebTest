package com.controller;

import com.pojo.Commodityguige;
import com.pojo.Coupon;
import com.result.Result;
import com.result.ResultFactory;
import com.service.CommdityguigeService;
import com.service.CommodityColorService;
import com.service.CommoditygService;
import com.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class CommdityguigeController {
    @Autowired
    private CommdityguigeService couponService;

    @Autowired
    private CommodityColorService commodityColorService;

    @Autowired
    private CommoditygService commoditygService;

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/listCommdityguige/{id}")
    public Result getCommdityguige(@PathVariable("id") Integer id){
        return ResultFactory.buildResult(commodityColorService.getCommodityguige(id),
                commoditygService.getCommodityguige(id),
                couponService.getCommodityguige(id));
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/Commdityguigelist")
    public Result getAllCommdityguige(){
        return ResultFactory.buildSuccessResult(couponService.getAllCommodityguige());
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/addCommdityguige",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Result addCommodityguige( Commodityguige user, HttpSession sessionone, HttpServletRequest request){
        return ResultFactory.buildSuccessResult(couponService.addCommodityguige(user));
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping("api/modCommdityguige")
    public Result modifyCommodityguige( Commodityguige user){
        return ResultFactory.buildSuccessResult(couponService.modifyCommodityguige(user));
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/delCommdityguige/{id}")
    public Result deleteCommodityguige(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(couponService.deleteCommodityguige(id));
    }
}
