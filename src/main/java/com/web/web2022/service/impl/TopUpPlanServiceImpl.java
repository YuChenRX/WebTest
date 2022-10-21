package com.web.web2022.service.impl;

import com.web.web2022.model.domain.TopUpPlan;
import com.web.web2022.repo.TopUpPlanRepo;
import com.web.web2022.service.TopUpPlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopUpPlanServiceImpl implements TopUpPlanService {
    @Autowired
    private TopUpPlanRepo topUpPlanRepo;


    @Override
    public List<TopUpPlan> find() {
    }
}
