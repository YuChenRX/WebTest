package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pojo.CommodityColor;
import com.pojo.Commodityg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommodityColorMapper extends BaseMapper<CommodityColor> {
    List<CommodityColor> getCommodityColor(Integer id);

    CommodityColor getCommodityColorById(Integer id);
}
