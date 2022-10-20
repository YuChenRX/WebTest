package com.web.web2022.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web.web2022.model.domain.Footprint;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.FootprintDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FootprintService extends IService<Footprint> {
    void add(User user, FootprintDto.In.Addition dto);

    List<FootprintDto.Out> find(User user, int page);
}
