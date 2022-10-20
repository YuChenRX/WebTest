package com.web.web2022.controller;

import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.FootprintDto;
import com.web.web2022.service.FootprintService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/footprints")
@RequiredArgsConstructor
public class FootprintController {
    private final FootprintService footprintService;

    @PostMapping
    public void add(@AuthenticationPrincipal User user, @RequestBody FootprintDto.In.Addition dto) {
        footprintService.add(user, dto);
    }

    @GetMapping
    public List<FootprintDto.Out> find(@AuthenticationPrincipal User user, @RequestParam(required = false) Integer page) {
        return footprintService.find(user, Objects.requireNonNullElse(page, 1));
    }
}
