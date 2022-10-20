package com.web.web2022.dao;

import com.web.web2022.model.domain.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BannerDao {
    Integer create(@Param("model") Banner model);

    List<Banner> find();
}
