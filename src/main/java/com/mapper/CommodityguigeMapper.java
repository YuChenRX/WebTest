package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pojo.Commodityguige;
import com.pojo.Coupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommodityguigeMapper extends BaseMapper<Commodityguige> {
    List<Commodityguige> getCommodityguige(Integer id);

    boolean addCommodityguige(Commodityguige coupon);

    boolean editCommodityguige(Commodityguige coupon);

    boolean deleteCommodityguige(Integer id);

    boolean edCommodityguigej1(Integer id);

    List<Commodityguige> getAllCommodityguige();
}
