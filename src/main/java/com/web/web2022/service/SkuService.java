package com.web.web2022.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web.web2022.model.domain.Sku;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.SkuDto;

import java.util.List;

public interface SkuService extends IService<Sku> {
    SkuDto.Out.Calculator calc(List<SkuDto.In.Calc> dto);

    SkuDto.Out.Buying buy(User user, List<SkuDto.In.Calc> dto);
}
