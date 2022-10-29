package com.controller;

import com.pojo.User;
import com.result.Result;
import com.result.ResultFactory;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
//@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Resource
    DataSource dataSource;

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/get")
    public Map<String,Object> getDefaultDataSource() throws SQLException {
        Map<String, Object> map = new HashMap<>();
        map.put("dataSource",dataSource.getClass());
        map.put("jdbcURL",dataSource.getConnection().getMetaData().getURL());
        System.out.println("默认连接数据源为:"+dataSource.getClass());
        System.out.println("连接地址"+dataSource.getConnection().getMetaData().getURL());
        return map;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/listUser/{id}")
    public Result getUser(@PathVariable("id") Integer id){
    return ResultFactory.buildSuccessResult(userService.getUser(id));
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/userlist")
    public Result getAll(){
    return ResultFactory.buildSuccessResult(userService.getAll());
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/addUser",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Result addUser( User user, HttpSession sessionone, HttpServletRequest request){
        return ResultFactory.buildSuccessResult(userService.addUser(user));
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping("api/moduser")
    public Result modifyUser( User user){
        User  user1=userService.getUser(user.getUid());
       String ypassword= user1.getUpassword();
       if (ypassword.equals(user.getN1())) {
           return ResultFactory.buildSuccessResult(userService.modifyUser(user));
       }else {
           return ResultFactory.buildFailResult("需要正确的原密码");

       }
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/delUser/{id}")
    public Result deleteUser(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(userService.deleteUser(id));
    }
}
