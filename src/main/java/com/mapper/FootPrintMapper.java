package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pojo.Collect;
import com.pojo.FootPrint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FootPrintMapper extends BaseMapper<FootPrint> {

    FootPrint getFootPrint(Integer id);

    FootPrint getFootPrintBycomid( Integer id);

    FootPrint getFootPrintBycomid1( FootPrint user);

    boolean addFootPrint(FootPrint footPrint);

    boolean editFootPrint(FootPrint footPrint);


    boolean deleteFootPrint(@Param("comid") Integer id);

    List<FootPrint> getAllFootPrint(Integer id);

    FootPrint getFootprintByName(String name);

   boolean editFootPrintOrDate(FootPrint footPrint);
}
