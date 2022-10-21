package com.web.web2022.controller;

import com.web.web2022.model.domain.User;
import com.web.web2022.model.outbound.OutBoundTopUpPlan;
import com.web.web2022.model.outbound.OutBoundUser;
import com.web.web2022.service.TopUpPlanService;
import com.web.web2022.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/top_up_plans")
public class TopUpPlanController {
    @Autowired
    private TopUpPlanService topUpPlanService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<OutBoundTopUpPlan> find() {
    }

    @PostMapping("/{id}/top_up")
    public OutBoundUser topUp(@PathVariable Integer id, @AuthenticationPrincipal User user) {
    }
}
