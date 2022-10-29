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
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@CrossOrigin
public class ShoppingCatController {
    @Autowired
    private ShoppingCatService shoppingCatService;

    @Autowired
    private CommdityguigeService commdityguigeService;

    @Autowired
    private CoutouserService coutouserService;
    @Autowired
    private CommodityService commodityService;

    @Autowired
    private CommodityColorService commodityColorService;

    @Autowired
    private CommoditygService commoditygService;

    @Autowired
    private UserPurseService userPurseService;

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/listShoppingCat/{id}")
    public Result getShoppingCat(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(shoppingCatService.getShoppingCat(id));
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/ShoppingCatlist")
    public Result getAllShoppingCat(){
        return ResultFactory.buildSuccessResult(shoppingCatService.getAllShoppingCat());
    }
    public static String formatToNumber(BigDecimal obj) {
        DecimalFormat df = new DecimalFormat("#.00");
        if(obj.compareTo(BigDecimal.ZERO)==0) {
            return "0.00";
        }else if(obj.compareTo(BigDecimal.ZERO)>0&&obj.compareTo(new BigDecimal(1))<0){
            return "0"+df.format(obj).toString();
        }else {
            return df.format(obj).toString();
        }
    }
    @CrossOrigin
    @ResponseBody
    @PostMapping("api/addShoppingCat/{id}/{uid}")//id是规格id
    public Result addShoppingCat( Commodityguige commodityguige, @PathVariable("id")Integer id
            ,@PathVariable("uid")Integer uid, HttpSession sessionone, HttpServletRequest request){
      int comid=  commodityguige.getComid(); int sum= commodityguige.getSum();
      BigDecimal a=commodityguige.getPrice();
      double price = a.doubleValue();
       Commodity commodity= commodityService.getCommonity(comid);
       CommodityColor commodityColor=commodityColorService.getCommodityColorById(id);
       Commodityg commodityg= commoditygService.GetCommoditygById(id);
        ShoppingCat shoppingCat = new ShoppingCat();
        shoppingCat.setCommoditycolor(commodity.getName());
        shoppingCat.setComid(comid);
        shoppingCat.setCommcolor(commodityColor.getN1());
        shoppingCat.setCommodguige(commodityg.getGname());

        shoppingCat.setPrice(price);
        shoppingCat.setUid(uid);
        shoppingCat.setCommoditysum(sum);
        shoppingCat.setCommodstatus(1);
        shoppingCat.setUpid(1);
        return ResultFactory.buildResult(
                commdityguigeService.upCommodityguige(id),
               shoppingCatService.addShoppingCat(shoppingCat));
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/aw")
    public Result getCommodityColorById(){
        return ResultFactory.buildSuccessResult(
                commoditygService.GetCommoditygById(9));
    }
    //精度问题
    //BigDecimal a=commodityguige.getPrice();
    //double price = a.doubleValue();
    @CrossOrigin
    @ResponseBody
    @PostMapping("api/gm/{id}/{uid}")//id是规格id
    public Result addShoppingCatbygg( Commodityguige commodityguige, @PathVariable("id")Integer id
            ,@PathVariable("uid")Integer uid, HttpSession sessionone, HttpServletRequest request){
        int comid=  commodityguige.getComid(); int sum= commodityguige.getSum();

        BigDecimal a=commodityguige.getPrice();
        double price = a.doubleValue();
        Commodity commodity= commodityService.getCommonity(comid);
        CommodityColor commodityColor=commodityColorService.getCommodityColorById(id);
        Commodityg commodityg= commoditygService.GetCommoditygById(id);
        ShoppingCat shoppingCat = new ShoppingCat();
        shoppingCat.setCommoditycolor(commodity.getName());
        shoppingCat.setComid(comid);
        shoppingCat.setCommcolor(commodityColor.getN1());
        shoppingCat.setCommodguige(commodityg.getGname());
        shoppingCat.setPrice(price);
        shoppingCat.setUid(uid);
        shoppingCat.setCommoditysum(sum);
        shoppingCat.setCommodstatus(2);
        shoppingCat.setUpid(1);
        String k=getRandomCharStr(10);
        shoppingCat.setOnid(k);

                commdityguigeService.upCommodityguige(id);
                shoppingCatService.addShoppingCat(shoppingCat);
        ShoppingCat user=new ShoppingCat();
        ShoppingCat stp1=  shoppingCatService.getShoppingCatByonid(k);
        user.setUid(uid);
        user.setCommodstatus(2);
        user.setValue(price);
        user.setCommodityid(stp1.getCommodityid());
        double v= user.getValue();
        int u= user.getUid();
        int v1=user.getCommodityid();
        ShoppingCat shoppingCat1=  shoppingCatService.getShoppingCat(v1);

        int u2= shoppingCat1.getUid();
        UserPurse userPurse= userPurseService.getUserPurseById(u);

        double v2= userPurse.getBlance();
//        if (u2==u) {
//
//            if(v2<=0){
//                return ResultFactory.buildFailResult("余额为0，需要充值");
//            }else if(v>v2){
//                return  ResultFactory.buildFailResult("余额不足，无法购买");
//            }else {
////                return ResultFactory.buildSuccessResult(
////                        shoppingCatService.updateAllst(user));
//            }
//        }else {
            return ResultFactory.buildSuccessResult(shoppingCat1);

    }

    @CrossOrigin
    @ResponseBody
    @PutMapping("api/modShoppingCat")
    public Result modifyShoppingCat( ShoppingCat user){
        return ResultFactory.buildSuccessResult(shoppingCatService.modifyShoppingCat(user));
    }
    /**
     * 生成n位随机数字和字母
     * @param n 随机字符的位数
     * @return n位数字和字母组成的随机字符串
     */
    public static String getRandomCharStr(int n) {
        String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder randomStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            randomStr.append(codes.charAt(random.nextInt(62)));
        }
        return randomStr.toString();
    }

    /*
/根据id取消订单
/
/
/
 */
    @CrossOrigin
    @ResponseBody
    @PostMapping("api/delShoppingCat/{id}")//删除订单
    public Result deleteShoppingCat(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(shoppingCatService.deleteShoppingCat(id));
    }
    @CrossOrigin
    @ResponseBody
    @PostMapping("api/quxiaodingdan/{id}")//取消订单
    public Result quxiaodingdan(@PathVariable("id") Integer id, ShoppingCat user){
       user.setCommodityid(id);
       Coutouser c1= coutouserService.getCoutousertolzc2(id);
        ShoppingCat shoppingCat1=  shoppingCatService.getShoppingCat(id);
        user.setCommoditysum(shoppingCat1.getCommoditysum());
           if (c1!=null){

           coutouserService.editCoutousertolzc1two(c1.getKid());
           }
        return ResultFactory.buildResult(
                shoppingCatService.UpdateAlls2(user),

                shoppingCatService.deleteShoppingCat(id));
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/SelectShoppingCat")
    public Result SelectShoppingCat(){
        return ResultFactory.buildSuccessResult(shoppingCatService.selectALLUserPurse());
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/ShoppingCat/{id}")//根据用户id获取钱包所有信息
    public Result listShoppingCat(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(shoppingCatService.getShoppingCatById(id));
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/SelectSUC")//获取所有购物车对应的全部商品
    public Result SelectSUC(){
        return ResultFactory.buildSuccessResult(shoppingCatService.selectallSUC());
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/SUC/{id}")//获取购物车物品id对应的商品
    public Result listSUC(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(shoppingCatService.getSUC(id));
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/SZT/{commodstatus}/{uid}")//根据物流状态获取购物车信息
    public Result listZT(@PathVariable("commodstatus") Integer commodstatus,@PathVariable("uid")Integer uid){
        return ResultFactory.buildSuccessResult(shoppingCatService.getZT(commodstatus,uid));
    }

/*
/{
/    "commodstatus":"2",
/    "value":"100",
/    "commodityid":"1"
/}
/value是要扣除的钱包金额
/commodstatus是要变动的状态
/其中1是未支付，2是代发货，3是待收货，4是待评价，5是已完成
 */
@CrossOrigin
@ResponseBody
@PostMapping("api/duorenfukuan")//多项支付
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
    double v2= userPurse.getBlance();
    items.setCommoditysum(shoppingCat1.getCommoditysum());
    if (items.getKid()!=0) {
        Coutouser coutouser = new Coutouser();
        coutouser.setLzc2(c[0]);
        coutouser.setKid(items.getKid());
        coutouserService.editCoutousertoMore(coutouser);
    }
    if (u2==u) {

        if(v2<=0){
            return ResultFactory.buildFailResult("余额为0，需要充值");
        }else if(v>v2){
            return  ResultFactory.buildFailResult("余额不足，无法购买");
        }else {
            items.setCommodityid(c[0]);
            return ResultFactory.buildResult(
                    shoppingCatService.updateAlls5(items),
                    shoppingCatService.editPlayFone(items));


        }

    }else {
        return ResultFactory.buildFailResult("输入的用户名不正确");
    }
}
    @CrossOrigin
    @ResponseBody
    @PostMapping("api/fukuan")//支付
    public Result fukuan(  ShoppingCat user){
        int kid=user.getKid();
       double v= user.getValue();
        int u= user.getUid();
        int v1=user.getCommodityid();
      ShoppingCat shoppingCat1=  shoppingCatService.getShoppingCat(v1);
      user.setCommoditysum(shoppingCat1.getCommoditysum());
     int u2= shoppingCat1.getUid();
       UserPurse userPurse= userPurseService.getUserPurseById(u);
      double v2= userPurse.getBlance();
      if (kid!=0) {
          Coutouser coutouser=new Coutouser();
          coutouser.setKid(kid);
          coutouser.setLzc2(user.getCommodityid());
          coutouserService.editCoutousertoMore(coutouser);
}
      if (u2==u) {

      if(v2<=0){
          return ResultFactory.buildFailResult("余额为0，需要充值");
      }else if(v>v2){
          return  ResultFactory.buildFailResult("余额不足，无法购买");
      }else {
          return ResultFactory.buildResult(
                  shoppingCatService.updateAlls5(user),
                  shoppingCatService.editPlayFone(user));
      }
      }else {
          return ResultFactory.buildFailResult("输入的用户名不正确");
      }

    }

}
