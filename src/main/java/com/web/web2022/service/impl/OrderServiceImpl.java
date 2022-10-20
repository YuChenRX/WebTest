package com.web.web2022.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.web2022.dao.OrderDao;
import com.web.web2022.mapper.OrderMapper;
import com.web.web2022.model.domain.Order;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.OrderDto;
import com.web.web2022.model.enumeration.OrderState;
import com.web.web2022.service.OrderService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
    @Override
    public List<OrderDto.Out.Default> find(User user, OrderState state) {
        LambdaQueryWrapper<Order> condition = new LambdaQueryWrapper<Order>()
            .eq(state != null, Order::getState, state)
            .eq(Order::getUserId, user.getId());
        return list(condition)
            .stream()
            .map(OrderMapper.INSTANCE::asDto)
            .collect(Collectors.toList());
    }

    @Override
    public OrderDto.Out.Counter countOrder(User user) {
        OrderDto.Out.Counter.CounterBuilder builder = OrderDto.Out.Counter.builder();

        LambdaQueryWrapper<Order> condition = new LambdaQueryWrapper<Order>();
        condition.eq(Order::getUserId, user.getId());
        condition.eq(
            Order::getState,
            OrderState.UNPAID
        );
        builder.unpaidOrderCount((int) count(condition));
        condition.clear();
        condition.eq(Order::getState, OrderState.PAID);
        builder.paidOrderCount((int) count(condition));
        condition.clear();
        condition.eq(Order::getState, OrderState.DELIVERED);
        builder.deliveredOrderCount((int) count(condition));
        condition.clear();
        condition.eq(Order::getState, OrderState.RECEIVED);
        builder.receivedOrderCount((int) count(condition));

        return builder.build();
    }
}
