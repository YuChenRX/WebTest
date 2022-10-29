package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pojo.CommodityColor;
import com.pojo.Commodityg;
import com.pojo.Commodityguige;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommoditygMapper extends BaseMapper<Commodityg> {
    List<Commodityg> getCommodityg(Integer id);

    Commodityg getCommoditygById(Integer id);

}
