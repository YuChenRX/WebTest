package com.web.web2022.repo;

import com.web.web2022.dao.BannerDao;
import com.web.web2022.model.domain.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BannerRepo {
    @Autowired
    private BannerDao bannerDao;

    public Integer create(Banner model) {
        return bannerDao.create(model);
    }

    public List<Banner> find() {
        return bannerDao.find();
    }
}
