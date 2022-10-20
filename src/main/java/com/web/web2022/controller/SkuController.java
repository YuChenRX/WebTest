package com.web.web2022.controller;

import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.SkuDto;
import com.web.web2022.service.SkuService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sku")
public class SkuController {
    private final SkuService skuService;

    @PostMapping("/calc")
    public SkuDto.Out.Calculator calc(@RequestBody List<SkuDto.In.Calc> dto) {
        return skuService.calc(dto);
    }

    @PostMapping("/buy")
    public SkuDto.Out.Buying buy(@AuthenticationPrincipal User user, @RequestBody List<SkuDto.In.Calc> dto) {
        return skuService.buy(user, dto);
    }
}
