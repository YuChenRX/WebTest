package com.event.listener;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.event.ProductVisitedEvent;
import com.mapper.CommodityMapper;
import com.mapper.FootPrintMapper;
import com.pojo.Commodity;
import com.pojo.FootPrint;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FootprintListener {
    private final FootPrintMapper footPrintMapper;

    @Async
    @EventListener
    public void listen(ProductVisitedEvent event) {
        FootPrint footPrint = checkWhetherExists(event.getCommodity());
        if (footPrint != null) {
            updateTimestamp(footPrint);
            return;
        }
        add(event.getCommodity(), event.getUid());
    }

    public FootPrint checkWhetherExists(Commodity commodity) {
        LambdaQueryWrapper<FootPrint> condition = new LambdaQueryWrapper<FootPrint>()
            .eq(FootPrint::getComid, commodity.getCommodityID());
        return footPrintMapper.selectOne(condition);
    }

    public void updateTimestamp(FootPrint footPrint) {
        footPrint.setFtime(new Date());
        footPrintMapper.update(footPrint, new LambdaQueryWrapper<FootPrint>().eq(FootPrint::getFid, footPrint.getFid()));
    }

    public void add(Commodity commodity, int uid) {
        FootPrint footPrint = new FootPrint();
        footPrint.setUid(uid);
        footPrint.setFtime(new Date());
        footPrint.setComid(commodity.getCommodityID());
        footPrint.setFname(commodity.getName());
        footPrintMapper.insert(footPrint);
    }
}
