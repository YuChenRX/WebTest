package com.controller;

import com.pojo.Sigin;
import com.pojo.User;
import com.pojo.UserPurse;
import com.result.Result;
import com.result.ResultFactory;
import com.service.SiginService;
import com.service.UserPurseService;
import com.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@CrossOrigin
@Slf4j
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserPurseService userPurseService;

    @Autowired
    private SiginService siginService;

    @CrossOrigin
    @PostMapping("api/registerUser")
    @ResponseBody
    public Result register( User user, HttpSession sessionone, HttpServletRequest request) {
        int status = userService.register(user);
        String name = user.getUname();
        name= HtmlUtils.htmlEscape(name);
        Sigin sign=new Sigin();
        User u1 =userService.getUserByName(name);
        sign.setUid(u1.getUid());
        sign.setQday(1);

        switch (status) {
            case 0:
                return ResultFactory.buildFailResult("账号和密码不能为空");
            case 1:
                UserPurse userPurse=new UserPurse();
                userPurse.setUid(u1.getUid());
                userPurse.setBlance(0);
                userPurse.setCoupon(0);
                userPurse.setIntegral(0);
                userPurse.setBuyafew(0);
                userPurse.setCouponid(0);
                userPurse.setXfe(0);
                userPurse.setLjcz(0);
                siginService.addSigin(sign);
                userPurseService.addUserPurse(userPurse);

                return ResultFactory.buildSuccessResult(u1);
            case 2:
                return ResultFactory.buildFailResult("用户已存在");
            case 3 :
                return ResultFactory.buildFailResult("添加失败");
        }
//        if(null == userInfo ){
//            System.out.printf("失败");
//            return new Result(400);
//        } else {
//            System.out.printf("成功");
//            HttpSession session = request.getSession();
//            session.setAttribute("userInfo", userInfo);
//            return new Result(200);
//
//        }
        return ResultFactory.buildFailResult("未知错误");
    }
    @CrossOrigin
    @PostMapping(value = "api/Login")
    @ResponseBody

    public Result Login( User use, HttpSession sessionone, HttpServletRequest request){
        int status=userService.Login(use);
        String name=use.getUname();
        String password=use.getUpassword();

        name= HtmlUtils.htmlEscape(name);
        use=userService.getUserByName(name);
        use.setUpassword("*****************");


            switch (status) {
                case 0:
                    return ResultFactory.buildFailResult("账号和密码不能为空");
                case 1:
                    return ResultFactory.buildSuccessResult(use);
                case 2:
                    return ResultFactory.buildFailResult("未找到用户");
            }

            return ResultFactory.buildFailResult("未知错误");

    }
}
