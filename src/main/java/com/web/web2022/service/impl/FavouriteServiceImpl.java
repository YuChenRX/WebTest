package com.web.web2022.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.web2022.dao.FavouriteDao;
import com.web.web2022.mapper.FavouriteMapper;
import com.web.web2022.model.domain.Favourite;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.FavouriteDto;
import com.web.web2022.service.FavouriteService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavouriteServiceImpl extends ServiceImpl<FavouriteDao, Favourite> implements FavouriteService {
    @Override
    public FavouriteDto.Out add(User user, int productId) {
        Favourite favourite = Favourite
            .builder()
            .productId(productId)
            .userId(user.getId())
            .build();
        save(favourite);

        return FavouriteMapper.INSTANCE.asDto(favourite);
    }

    @Override
    public void delete(User user, int id) {
        LambdaQueryWrapper<Favourite> condition = new LambdaQueryWrapper<Favourite>()
            .eq(Favourite::getUserId, user.getId())
            .eq(Favourite::getId, id);
        remove(condition);
    }

    @Override
    public void delete(User user, List<Integer> ids) {
        LambdaQueryWrapper<Favourite> condition = new LambdaQueryWrapper<Favourite>()
            .eq(Favourite::getUserId, user.getId())
            .in(Favourite::getId, ids);
        remove(condition);
    }

    @Override
    public List<FavouriteDto.Out> find(User user, Integer productId) {
        LambdaQueryWrapper<Favourite> condition = new LambdaQueryWrapper<Favourite>()
            .eq(Favourite::getUserId, user.getId());

        if (productId != null) {
            condition = condition
                .eq(Favourite::getProductId, productId);
        }

        return list(condition)
            .stream()
            .map(FavouriteMapper.INSTANCE::asDto)
            .collect(Collectors.toList());
    }
}
