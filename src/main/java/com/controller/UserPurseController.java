package com.controller;

import com.pojo.User;
import com.pojo.UserPurse;
import com.result.Result;
import com.result.ResultFactory;
import com.service.CoutouserService;
import com.service.UserPurseService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin
public class UserPurseController {
    @Autowired
    private UserPurseService userPurseService;

    @Autowired
    private CoutouserService coutouserService;

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/listpurse/{id}")
    public Result getUserPurse(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(userPurseService.getUserPurse(id));
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/purselist")
    public Result getAllUserPurse(){
        return ResultFactory.buildSuccessResult(userPurseService.getAllUserPurse());
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value ="api/addpurse", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public Result addUserPurse( UserPurse user, HttpSession sessionone, HttpServletRequest request){
        return ResultFactory.buildSuccessResult(userPurseService.addUserPurse(user));
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping("api/modpurse")
    public Result modifyUserPurse(@RequestBody UserPurse user){
        return ResultFactory.buildSuccessResult(userPurseService.modifyUserPurse(user));
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/delpurse/{id}")
    public Result deleteUserPurse(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(userPurseService.deleteUserPurse(id));
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/Selectpurse")
    public Result SelectUserPurse(){
        return ResultFactory.buildSuccessResult(userPurseService.selectALLUserPurse());
    }
//用户钱包



}
