package com.controller;

import com.pojo.*;
import com.result.Result;
import com.result.ResultFactory;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@CrossOrigin
public class CommodityController {
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private FootPrintService footPrintService;

    @Autowired
    private CommoditytomoreService commoditytomoreService;

    @Autowired
    private CommdityguigeService commdityguigeService;



    @Autowired
    private CollectService collectService;


    private Result result=new Result();
//商品详情
    /*

    http://localhost:8080/api/listCommodity/1
{
    "comid":"3",
    "fname":"爱车屋汽车头枕靠背腰靠垫记忆棉车内座椅护颈枕靠枕一对车载用品",
    "zsy1":"",
    "zsy2":"",
    "uid":"1"
}
{
	"code": 200,
	"msg": "成功",
	"sku": {
		"picture": "https://img.pddpic.com/open-gw/2022-09-09/2251ecd6-85c6-47e5-82b3-e62afd7d3dc2.jpeg?imageMogr2/thumbnail/400x%7CimageView2/2/w/400/q/80",
		"brand": true,
		"name": "LEGO乐高 美国宇航局阿波罗土星五号  92176 积木玩具",
		"redname": "",
		"blackname": "品质险  24小时发货",
		"price": 599,
		"spell": "已拼2558件",
		"commodityID": 1,
		"adtime": "2022-09-07T16:00:00.000+00:00",
		"bybt": true
	}
}
     */
    /*
    id是当前要查看的商品id
    uid是用户id
    http://localhost:8080/api/listCommodityAndAdd/5/1
     */
    //length用户要求产生字符串的长度
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/getCommodityBycaid/{caid}")
    public Result getCommodityByCaid(@PathVariable("caid") Integer caid){
        return ResultFactory.buildSuccessResult(commodityService.getCommodityBycaid(caid));
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/getCommodityLike")//模糊查询
    public Result getCommodityByLike( Commodity commodity){
        return ResultFactory.buildSuccessResult(commodityService.getCommodityLike(commodity.getMh()));
    }
   
    public Date toDate(String d1){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        try {

            Date d2= formatter.parse(d1);
            System.out.println(d2);
            return  d2;
        }catch (ParseException e) {

        }
        return new Date();
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/Commoditylist")
    public Result getAllCommodity(){
        return ResultFactory.buildSuccessResult(commodityService.getAll());
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/addCommodity")
    public Result addCommodity( Commodity user, HttpSession sessionone, HttpServletRequest request){
        return ResultFactory.buildSuccessResult(commodityService.addCommonity(user));
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping("api/modCommodity")
    public Result modifyCommodity( Commodity user){
        return ResultFactory.buildSuccessResult(commodityService.modifyCommonity(user));
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/delCommodity/{id}")
    public Result deleteCommodity(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(commodityService.deleteCommonity(id));
    }
   //商品排序

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/Commoditylist/{id}")
    public Result findOne(@RequestParam String source, @PathVariable int id, @RequestParam int uid){
        return ResultFactory.buildSuccessResult(commodityService.findOne(source, id, uid));
    }

}
