package com.controller;

import com.pojo.Commoditytomore;
import com.pojo.Coupon;
import com.result.Result;
import com.result.ResultFactory;
import com.service.CommoditytomoreService;
import com.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class
CommoditytomoreController {
    @Autowired
    private CommoditytomoreService commoditytomoreService;

    //根据商品的id查看对应的详细信息
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/listCommoditytomore/{id}")
    public Result getCommoditytomore(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(commoditytomoreService.getCommoditytomore(id));
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/Commoditytomorelist")
    public Result getAllCommoditytomore(){
        return ResultFactory.buildSuccessResult(commoditytomoreService.getAllCoupon());
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/addCommoditytomore",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Result addcommoditytomoreService( Commoditytomore user, HttpSession sessionone, HttpServletRequest request){
        return ResultFactory.buildSuccessResult(commoditytomoreService.addCoupon(user));
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping("api/modCommoditytomore")
    public Result modifycommoditytomoreService( Commoditytomore user){
        return ResultFactory.buildSuccessResult(commoditytomoreService.modifyCoupon(user));
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/delCommoditytomore/{id}")
    public Result deletecommoditytomoreService(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(commoditytomoreService.deleteCoupon(id));
    }
}
