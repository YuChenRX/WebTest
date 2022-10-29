package com.controller;

import com.date.DateFormet;
import com.pojo.Collect;
import com.pojo.Commodity;
import com.pojo.User;
import com.result.Result;
import com.result.ResultFactory;
import com.service.CollectService;
import com.service.CommdityguigeService;
import com.service.CommodityService;
import com.service.UserService;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin
public class CollectController {
    @Autowired
    private CollectService collectService;

    @Autowired
    private CommodityService commodityService;
    @Autowired
    private CommdityguigeService commdityguigeService;

    @Autowired
    private  UserService userService;

    private DateFormet dateFormet;

    @CrossOrigin
    @ResponseBody
    @GetMapping("api/listCollect/{id}")
    public Result getCollect(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(collectService.getCollect(id));
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/Collectlist")
    public Result getAllCollect(){
        return ResultFactory.buildSuccessResult(collectService.getAllCollect());
    }

    
    @CrossOrigin
    @ResponseBody
    @PutMapping("api/modCollect")//修改收藏
    public Result modifyCollect( Collect user){
        return ResultFactory.buildSuccessResult(collectService.modifyCollect(user));
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/delCollect/{id}")//删除收藏id为商品id
    public Result deleteCollect(@PathVariable("id") Integer id){
        return ResultFactory.buildSuccessResult(collectService.deleteCollect(id));
    }

}
