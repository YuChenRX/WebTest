package com.web.web2022.controller;

import com.web.web2022.model.domain.User;
import com.web.web2022.model.outbound.OutBoundTopUpPlan;
import com.web.web2022.model.outbound.OutBoundUser;
import com.web.web2022.service.TopUpPlanService;
import com.web.web2022.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/top_up_plans")
public class TopUpPlanController {
    @Autowired
    private TopUpPlanService topUpPlanService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<OutBoundTopUpPlan> find() {
        return topUpPlanService.find().parallelStream()
            .map(OutBoundTopUpPlan::new)
            .collect(Collectors.toList());
    }

    @PostMapping("/{id}/top_up")
    public OutBoundUser topUp(@PathVariable Integer id, @AuthenticationPrincipal User user) {
        return new OutBoundUser(userService.topUp(user, id));
    }
}
