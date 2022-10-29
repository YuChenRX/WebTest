package com.controller;

import com.pojo.Collect;
import com.pojo.FootPrint;
import com.pojo.User;
import com.result.Result;
import com.result.ResultFactory;
import com.service.CollectService;
import com.service.FootPrintService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class FootPrintController {
    @Autowired
    private FootPrintService footPrintService;
    @Autowired
    private UserService userService;

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/listFootPrint/{id}")
    public Result getCollect(@PathVariable("id") Integer id){

        return ResultFactory.buildSuccessResult(footPrintService.getFootPrint(id));
    }


    //查看我的足迹
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/footprints")
    public Result find(@RequestParam Integer id){
        return ResultFactory.buildSuccessResult(footPrintService.getAllFootPrint(id));
    }
   
    @CrossOrigin
    @ResponseBody
    @PostMapping("api/addFootPrint")
    public Result addCollect( FootPrint footPrint, HttpSession sessionone, HttpServletRequest request){
        return ResultFactory.buildSuccessResult(footPrintService.addFootPrint(footPrint));
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping("api/modFootPrint")
    public Result modifyCollect( FootPrint footPrint){
        return ResultFactory.buildSuccessResult(footPrintService.modifyFootPrint(footPrint));
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/delFootPrint/{id}")
    public Result deleteCollect(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(footPrintService.deleteFootPrint(id));
    }

}
