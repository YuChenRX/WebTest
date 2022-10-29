package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pojo.Collect;
import com.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {
    Commodity getCommodity(Integer id);

    boolean addCommodity(Commodity commodity);

    boolean editCommodity(Commodity commodity);

    boolean deleteCommodity(Integer id);

    List<Commodity> getAllCommodity();

    List<Commodity> getAllCommodityAndLimit(int value);

    List<Commodity> getAllcommodityByTime();

    List<Commodity> getAllcommodityByUpPerice();

    List<Commodity> getAllcommodityByDownPerice();

    List<Commodity> getAllcommodityByTimeAndLimit(int value);

    List<Commodity> getAllcommodityByUpPericeAndLimit(int value);

    List<Commodity> getAllcommodityByDownPericeAndLimit(int value);

    List<Commodity> getCommodityBycaid(int id);

    List<Commodity> getCommodityLike(@Param("mh") String mh);

}
