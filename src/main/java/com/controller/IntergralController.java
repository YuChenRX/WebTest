package com.controller;

import com.pojo.*;
import com.result.Result;
import com.result.ResultFactory;
import com.result.ResultFactoryone;
import com.result.Resultone;
import com.service.*;
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
import java.util.Map;
import java.util.Random;

@Controller
@CrossOrigin
public class IntergralController {
    @Autowired
    private IntergralService intergralService;

    @Autowired
    private ShoppingCatService shoppingCatService ;

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

    @Autowired
    private UserPurseService userPurseService;

    @Autowired
    private CoutouserService coutouserService;

   //积分商品详情




    @CrossOrigin
    @ResponseBody
    @GetMapping("api/Intergrallist")
    public Result getAllIntergral(){
        return ResultFactory.buildSuccessResult(intergralService.getAllIntergral());
    }



    @CrossOrigin
    @ResponseBody
    @PostMapping("api/addIntergral")
    public Result addIntergral( Intergral user, HttpSession sessionone, HttpServletRequest request){
        return ResultFactory.buildSuccessResult(intergralService.addIntergral(user));
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping("api/modIntergral")
    public Result modifyIntergral( Intergral user){
        return ResultFactory.buildSuccessResult(intergralService.modifyIntergral(user));
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/delIntergral/{id}")
    public Result deleteIntergral(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(intergralService.deleteIntergral(id));
    }
    @CrossOrigin
    @ResponseBody
    @PostMapping("api/duorenfukuantoIntergral")//多项支付
    public Result fukuanaw( ShoppingCat items){
        int [] c=items.getS();
        for (int i=0;i<c.length;i++){
            int t=c[i];
            if(i>0){
                shoppingCatService.updateAlls4(c[i]);
            }
        }
        double v= items.getValue();
        int u= items.getUid();
        int v1=c[0];
        ShoppingCat shoppingCat1=  shoppingCatService.getShoppingCat(v1);
        int u2= shoppingCat1.getUid();
        UserPurse userPurse= userPurseService.getUserPurseById(u);
        double v2= userPurse.getIntegral();
        items.setCommoditysum(shoppingCat1.getCommoditysum());
        if (items.getKid()!=0) {
            Coutouser coutouser = new Coutouser();
            coutouser.setLzc2(c[0]);
            coutouser.setKid(items.getKid());
            coutouserService.editCoutousertoMore(coutouser);
        }
        if (u2==u) {

            if(v2<=0){
                return ResultFactory.buildFailResult("积分余额为0，需要消费充值");
            }else if(v>v2){
                return  ResultFactory.buildFailResult("积分余额不足，无法购买");
            }else {
                items.setCommodityid(c[0]);
                return ResultFactory.buildResult(
                        shoppingCatService.updateAlls5(items),
                        shoppingCatService.updateAlls6(items));


            }

        }else {
            return ResultFactory.buildFailResult("输入的用户名不正确");
        }
    }
    @CrossOrigin
    @ResponseBody
    @PostMapping("api/quxiaodingdantoIntergral/{id}")//取消订单
    public Result quxiaodingdan(@PathVariable("id") Integer id, ShoppingCat user){
        user.setCommodityid(id);
        Coutouser c1= coutouserService.getCoutousertolzc2(id);
        ShoppingCat shoppingCat1=  shoppingCatService.getShoppingCat(id);
        user.setCommoditysum(shoppingCat1.getCommoditysum());
        if (c1!=null){

            coutouserService.editCoutousertolzc1two(c1.getKid());
        }
        return ResultFactory.buildResult(
                shoppingCatService.updateAlls7(user),

                shoppingCatService.deleteShoppingCat(id));
    }
    @CrossOrigin
    @ResponseBody
    @PostMapping("api/fukuantoIntergral")//支付
    public Result fukuantoIntergral(  ShoppingCat user){
        int kid=user.getKid();
        double v= user.getValue();
        int u= user.getUid();
        int v1=user.getCommodityid();
        ShoppingCat shoppingCat1=  shoppingCatService.getShoppingCat(v1);
        user.setCommoditysum(shoppingCat1.getCommoditysum());
        int u2= shoppingCat1.getUid();
        UserPurse userPurse= userPurseService.getUserPurseById(u);
        double v2= userPurse.getIntegral();
        if (kid!=0) {
            Coutouser coutouser=new Coutouser();
            coutouser.setKid(kid);
            coutouser.setLzc2(user.getCommodityid());
            coutouserService.editCoutousertoMore(coutouser);
        }
        if (u2==u) {


            if(v2<=0){
                return ResultFactory.buildFailResult("积分余额为0，需要消费充值");
            }else if(v>v2){
                return  ResultFactory.buildFailResult("积分余额不足，无法购买");
            }else {
                return ResultFactory.buildResult(
                        shoppingCatService.updateAlls5(user),
                        shoppingCatService.updateAlls6(user));


            }

        }else {
            return ResultFactory.buildFailResult("输入的用户名不正确");
        }

    }
    public static String getRandomCharStr(int n) {
        String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder randomStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            randomStr.append(codes.charAt(random.nextInt(62)));
        }
        return randomStr.toString();
    }
}
