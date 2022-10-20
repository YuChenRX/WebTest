package com.web.web2022.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web.web2022.model.domain.Favourite;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.FavouriteDto;

import java.util.List;

public interface FavouriteService extends IService<Favourite> {
    FavouriteDto.Out add(User user, int productId);

    void delete(User user, int id);

    void delete(User user, List<Integer> ids);

    List<FavouriteDto.Out> find(User user, Integer productId);
}
