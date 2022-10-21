package com.web.web2022.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.web2022.dao.FootprintDao;
import com.web.web2022.model.domain.Footprint;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.FootprintDto;
import com.web.web2022.service.FootprintService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootprintServiceImpl extends ServiceImpl<FootprintDao, Footprint> implements FootprintService {
    @Override
    public void add(User user, FootprintDto.In.Addition dto) {
    }

    @Override
    public List<FootprintDto.Out> find(User user, int page) {
    }

    protected void update(Footprint footprint) {
    }
}
