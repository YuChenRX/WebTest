package com.controller;

import com.pojo.Coupon;
import com.pojo.Sigin;
import com.pojo.UserPurse;
import com.result.Result;
import com.result.ResultFactory;
import com.service.CouponService;
import com.service.SiginService;
import com.service.UserPurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Controller
@CrossOrigin
public class SiginController {
    @Autowired
    private SiginService siginService;

    @Autowired
    private UserPurseService userPurseService;



    @CrossOrigin
    @ResponseBody
    @GetMapping("api/listSigin/{id}")
    public Result getSigin(@PathVariable("id") Integer id){
        return ResultFactory.buildResult(
                userPurseService.getUserPurseById(id)
                ,siginService.getSigin(id));
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/Siginlist")
    public Result getAllSigin(){
        return ResultFactory.buildSuccessResult(siginService.getAllSigin());
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/addSigin",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Result addSigin( Sigin sigin, HttpSession sessionone, HttpServletRequest request){
        return ResultFactory.buildSuccessResult(siginService.addSigin(sigin));
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/modSigin/{uid}")
    public Result modifySigin(@PathVariable("uid") Integer uid){
        try {
        Sigin user=new Sigin();Sigin s=  siginService.getSigin(uid);
        Date date=s.getTdate();Date d1=new Date();
        long diff = d1.getTime() - date.getTime();//这样得到的差值是毫秒级别
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");String gd2=sdf.format(date);
        int day2=Integer.parseInt(gd2);int day = calendar.get(Calendar.DAY_OF_MONTH);
        if (day - day2==1) {
            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
            Sigin s1 = siginService.getSigin(uid);
            if (s1.getQday() >= 7) {
                user.setUid(uid);user.setQday(0);siginService.modifySigin(user);
            }
            user.setUid(uid);Sigin sigin = siginService.getSigin(uid);
            UserPurse user1 = new UserPurse();Sigin sigin1 = siginService.getSigin(uid);
            int d = sigin.getQday();int inter;
            if (d >= 7) {
                inter = 100;user1.setIntegral(inter);Sigin sigin2 = new Sigin();
                user1.setUid(uid);sigin2.setUid(uid);sigin2.setQday(sigin1.getQday() + 1);
                siginService.modifySigin(sigin2);
                return ResultFactory.buildSuccessResult(userPurseService.upditUserPurseadd(user1));
            } else {
                Random r = new Random();inter = r.nextInt(20) + 10;
                user1.setIntegral(inter);
                Sigin sigin21 = siginService.getSigin(uid);Sigin sigin22 = new Sigin();
                user1.setUid(uid);sigin22.setUid(uid);sigin22.setQday(sigin21.getQday() + 1);
                boolean sw = siginService.modifySigin(sigin22);
                return ResultFactory.buildSuccessResult(userPurseService.upditUserPurseadd(user1));
            }
        }else if (day == day2) {
            Sigin us = siginService.getSigin(uid);user.setUid(uid);user.setQday(us.getQday());
            siginService.modifySigin(user);
                return  ResultFactory.buildFailResult("1天之内不能重复签到");
        }else {
            user.setUid(uid);user.setQday(1);siginService.modifySigin(user);
            UserPurse user3 = new UserPurse();Random rw = new Random();int intere = rw.nextInt(20) + 10;
            user3.setUid(uid);user3.setIntegral(intere);
            return ResultFactory.buildSuccessResult(userPurseService.upditUserPurseadd(user3));
        }
        }catch (Exception e) {
           return ResultFactory.buildFailResult("抛出异常") ;
        }

    }
//        return ResultFactory.buildSuccessResult();
//public static String getDate1(){
//    Calendar cal = Calendar.getInstance();
//    cal.set(Calendar.HOUR_OF_DAY, 0);//控制时
//    cal.set(Calendar.MINUTE, 0);//控制分
//    cal.set(Calendar.SECOND, 0);//控制秒
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    return sdf.format(cal.getTime());
//}

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/delSigin/{id}")
    public Result deleteSigin(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(siginService.deleteSigin(id));
    }
//    @CrossOrigin
//    @ResponseBody
//    @PostMapping("api/addinter/{id}/{uid}")
//    public Result addinter(@PathVariable("id") Integer id,@PathVariable("uid") Integer uid){
//
        }


