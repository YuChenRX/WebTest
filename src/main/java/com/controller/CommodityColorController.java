package com.controller;


import com.result.Result;
import com.result.ResultFactory;
import com.service.CommdityguigeService;
import com.service.CommodityColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class CommodityColorController {
    @Autowired
    private CommodityColorService couponService;

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/listCommodityColor/{id}")
    public Result getCommodityColor(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(couponService.getCommodityguige(id));
    }
}
