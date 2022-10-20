package com.web.web2022.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web.web2022.model.domain.Order;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.OrderDto;
import com.web.web2022.model.enumeration.OrderState;

import java.util.List;

public interface OrderService extends IService<Order> {
    List<OrderDto.Out.Default> find(User user, OrderState state);

    OrderDto.Out.Counter countOrder(User user);
}
