package com.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.ClassificationMapper;
import com.mapper.CouponMapper;
import com.pojo.Classification;
import com.pojo.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationService extends ServiceImpl<ClassificationMapper, Classification> {
    public List<Classification> findByParent(int parentId) {
        LambdaQueryWrapper<Classification> condition = new LambdaQueryWrapper<Classification>()
            .eq(Classification::getIndex, parentId);

        return list(condition);
    }
}
