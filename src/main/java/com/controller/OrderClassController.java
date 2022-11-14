package com.controller;

import com.result.Result;
import com.result.ResultFactory;
import com.service.OrderClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderClassController {

    @Autowired
    OrderClassService service;

    @GetMapping("/{id}")
    @CrossOrigin
    public Result findByUserId(@PathVariable int id) {
        return ResultFactory.buildSuccessResult(service.getOrderClassByUserId(id));
    }


    @GetMapping("/add/{guigeId}/{userid}/{status}/{sum}")
    public Result add(@PathVariable int guigeId,
                      @PathVariable int userid,
                      @PathVariable int status,
                      @PathVariable int sum) {
        return ResultFactory.buildSuccessResult(service.add(userid, guigeId, status, sum));
    }

    @GetMapping("/allstatus/{userId}")
    public Result statusTotal(@PathVariable int userId) {
        return ResultFactory.buildSuccessResult(service.getStatusTotal(userId));
    }

}