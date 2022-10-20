package com.web.web2022.service.impl;

import com.web.web2022.model.domain.Banner;
import com.web.web2022.repo.BannerRepo;
import com.web.web2022.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerRepo bannerRepo;

    @Override
    public List<Banner> find() {
        return bannerRepo.find();
    }
}
