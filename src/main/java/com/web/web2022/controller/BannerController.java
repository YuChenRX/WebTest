package com.web.web2022.controller;

import com.web.web2022.model.outbound.OutBoundBanner;
import com.web.web2022.service.BannerService;
import com.web.web2022.validation.validator.FileNotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequestMapping("/banners")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @GetMapping
    public List<OutBoundBanner> find() {
        return bannerService.find().parallelStream()
            .map(OutBoundBanner::new)
            .collect(Collectors.toList());
    }

//    @PostMapping
//    public OutBoundBanner create(@FileNotEmpty MultipartFile image) throws IOException {
//        return new OutBoundBanner(bannerService.create(image.getBytes()));
//    }
}
