package com.web.web2022.service;

import com.web.web2022.model.domain.TopUpPlan;
import com.web.web2022.repo.TopUpPlanRepo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TopUpPlanService {
    List<TopUpPlan> find();
}
