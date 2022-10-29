package com.controller;

import com.pojo.Coupon;
import com.pojo.Coutouser;
import com.pojo.UserPurse;
import com.result.Result;
import com.result.ResultFactory;
import com.service.CouponService;
import com.service.CoutouserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class CoutouserController {
    @Autowired
    private CoutouserService couponService;

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/listCoutouser/{id}")
    public Result getCoutouser(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(couponService.getCoutouser(id));
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/Coutouserlist/{id}")//根据用户id查看用户所有的优惠券
    public Result getAllCoutouser(@PathVariable("id") Integer id){

        return ResultFactory.buildSuccessResult(
                couponService.getAllCoutouser(id)
                );

    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/addCoutouser",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Result addCoutouser( Coutouser user, HttpSession sessionone, HttpServletRequest request){
        return ResultFactory.buildSuccessResult(couponService.addCoutouser(user));
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping("api/modCoutouser")
    public Result modifyCoutouser(  Coutouser user){
        return ResultFactory.buildSuccessResult(couponService.modifyCoutouser(user));
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/delCoutouser/{id}")
    public Result deleteCoutouser(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(couponService.deleteCoutouser(id));
    }
}
