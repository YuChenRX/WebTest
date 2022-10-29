package com.mapper;

import com.pojo.Commoditytomore;
import com.pojo.Coupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommoditytomoreMapper {
    Commoditytomore getCommoditytomore(Integer id);

    boolean addCommoditytomore(Commoditytomore coupon);

    boolean editCommoditytomore(Commoditytomore coupon);

    boolean deleteCommoditytomore(Integer id);

    List<Commoditytomore> getAllCommoditytomore();
}
