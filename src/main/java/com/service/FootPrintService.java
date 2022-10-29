package com.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.CollectMapper;
import com.mapper.CommodityMapper;
import com.mapper.FootPrintMapper;
import com.pojo.Collect;
import com.pojo.Commodity;
import com.pojo.FootPrint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FootPrintService extends ServiceImpl<FootPrintMapper, FootPrint> {
    private final FootPrintMapper footPrintMapper;
    private final CommodityMapper commodityMapper;

    public FootPrint getFootPrint(Integer id) {

        return footPrintMapper.getFootPrint(id);
    }

    public FootPrint getFootPrintBycomid1(FootPrint user) {

        return footPrintMapper.getFootPrintBycomid1(user);
    }

    public FootPrint getFootPrintBycomid(Integer id) {

        return footPrintMapper.getFootPrintBycomid(id);
    }

    public boolean addFootPrint(FootPrint user) {
        return footPrintMapper.addFootPrint(user);
    }

    public boolean modifyFootPrint(FootPrint user) {
        return footPrintMapper.editFootPrint(user);
    }

    public boolean deleteFootPrint(Integer id) {
        return footPrintMapper.deleteFootPrint(id);
    }

    public List<FootPrint> getAllFootPrint(Integer id) {

//        return footPrintMapper.getAllFootPrint(id);
        LambdaQueryWrapper<FootPrint> condition = new LambdaQueryWrapper<FootPrint>()
            .eq(FootPrint::getUid, id)
            .orderBy(true, false, FootPrint::getFtime);
        return list(condition)
            .stream()
            .peek(v -> v.setCommodity(commodityMapper.selectOne(new LambdaQueryWrapper<Commodity>().eq(
                Commodity::getCommodityID,
                v.getComid()
            ))))
            .collect(Collectors.toList());
    }

    public FootPrint getFootprintByName(String name) {
        return footPrintMapper.getFootprintByName(name);
    }

    public boolean editFootPrintOrDate(FootPrint user) {
        return footPrintMapper.editFootPrintOrDate(user);
    }
}
