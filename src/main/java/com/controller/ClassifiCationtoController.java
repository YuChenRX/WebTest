package com.controller;

import com.pojo.ClassifiCationtoMore;
import com.pojo.Classification;
import com.result.Result;
import com.result.ResultFactory;
import com.service.ClassifiCationtoMoreService;
import com.service.ClassificationService;
import com.service.CouponService;
import com.service.CoutouserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class ClassifiCationtoController {
    private final ClassifiCationtoMoreService classifiCationtoMoreService;
    private final ClassificationService classificationService;
   //分类
    @GetMapping
    public List<ClassifiCationtoMore> find() {
        return classifiCationtoMoreService.find();
    }

    @GetMapping("/{id}/children")
    public List<Classification> findChildren(@PathVariable int id) {
        return classificationService.findByParent(id);
    }
}
