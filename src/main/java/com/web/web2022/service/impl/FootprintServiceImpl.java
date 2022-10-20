package com.web.web2022.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.web2022.dao.FootprintDao;
import com.web.web2022.mapper.FootprintMapper;
import com.web.web2022.model.domain.Footprint;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.FootprintDto;
import com.web.web2022.service.FootprintService;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FootprintServiceImpl extends ServiceImpl<FootprintDao, Footprint> implements FootprintService {
    @Override
    public void add(User user, FootprintDto.In.Addition dto) {
        LambdaQueryWrapper<Footprint> condition = new LambdaQueryWrapper<Footprint>()
            .eq(Footprint::getUserId, user.getId())
            .eq(Footprint::getProductId, dto.getProductId());
        Footprint one = getOne(condition);

        if (one != null) {
            update(one);
            return;
        }

        Footprint footprint = Footprint
            .builder()
            .updatedAt(Instant.now())
            .userId(user.getId())
            .productId(dto.getProductId())
            .build();
        save(footprint);
    }

    @Override
    public List<FootprintDto.Out> find(User user, int page) {
        LambdaQueryWrapper<Footprint> condition = new LambdaQueryWrapper<Footprint>()
            .eq(Footprint::getUserId, user.getId());
        return baseMapper
            .selectPage(new Page<>(page, 10), condition)
            .getRecords()
            .stream()
            .map(FootprintMapper.INSTANCE::asDto)
            .collect(Collectors.toList());
    }

    protected void update(Footprint footprint) {
        footprint = footprint
            .toBuilder()
            .updatedAt(Instant.now())
            .build();
        saveOrUpdate(footprint);
    }


}
