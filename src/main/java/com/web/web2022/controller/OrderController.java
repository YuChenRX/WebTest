package com.web.web2022.controller;

import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.OrderDto;
import com.web.web2022.model.enumeration.OrderState;
import com.web.web2022.service.OrderService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderDto.Out.Default> find(
        @AuthenticationPrincipal User user,
        @RequestParam(required = false) OrderState state
    ) {
        return orderService.find(user, state);
    }

    @GetMapping("/count")
    public OrderDto.Out.Counter count(@AuthenticationPrincipal User user) {
        return orderService.countOrder(user);
    }
}
