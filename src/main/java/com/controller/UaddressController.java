package com.controller;

import com.pojo.ShoppingCat;
import com.pojo.Uaddress;
import com.result.Result;
import com.result.ResultFactory;
import com.service.ShoppingCatService;
import com.service.UaddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class UaddressController {
    @Autowired
    private UaddressService uaddressService;

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/listUaddress/{id}")
    public Result getUaddress(@PathVariable("id") Integer id) {
        return ResultFactory.buildSuccessResult(uaddressService.getUaddress(id));
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/Uaddresslist/{id}")
    public Result getAllUaddress(@PathVariable("id") Integer id) {
        return ResultFactory.buildSuccessResult(uaddressService.getAllUaddress(id));
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/addUaddress")
    public Result addUaddress(Uaddress user, HttpSession sessionone, HttpServletRequest request) {
        boolean t = user.isMor();
        if (t) {

            return ResultFactory.buildResult(
                    uaddressService.updatemor(),
                    uaddressService.addUaddress(user));
        } else {
            return ResultFactory.buildSuccessResult(uaddressService.addUaddress(user));
        }

    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/modUaddress")
    public Result modifyUaddress(Uaddress user) {
        boolean t = user.isMor();
        if (t) {

            return ResultFactory.buildResult(
                    uaddressService.updatemor(),
                    uaddressService.modifyUaddress(user));
        } else {
            return ResultFactory.buildSuccessResult(uaddressService.modifyUaddress(user));
        }

    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/delUaddress/{id}")
    public Result deleteUaddress(@PathVariable("id") Integer id) {
        return ResultFactory.buildSuccessResult(uaddressService.deleteUaddress(id));
    }
}
