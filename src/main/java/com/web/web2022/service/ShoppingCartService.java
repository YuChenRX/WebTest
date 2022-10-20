package com.web.web2022.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web.web2022.model.domain.ShoppingCart;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.ShoppingCartDto;

import java.util.List;

public interface ShoppingCartService extends IService<ShoppingCart> {
    ShoppingCartDto.Out add(User user, ShoppingCartDto.In.Addition dto);

    void remove(User user, int id);

    ShoppingCartDto.Out update(User user, int id, ShoppingCartDto.In.Update dto);

    List<ShoppingCartDto.Out> find(User user);
}
