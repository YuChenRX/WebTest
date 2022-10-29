package com.mapper;

import com.pojo.Coupon;
import com.pojo.Sigin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SiginMapper {
    Sigin getSigin(Integer id);

    boolean addSigin(Sigin sigin);

    boolean editSigin(Sigin sigin);

    boolean deleteSigin(Integer id);

    List<Sigin> getAllSigin();
}
