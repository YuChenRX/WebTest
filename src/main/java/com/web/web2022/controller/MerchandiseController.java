package com.web.web2022.controller;

import com.web.web2022.model.domain.User;
import com.web.web2022.model.inbound.InBoundMerchandiseList;
import com.web.web2022.model.outbound.OutBoundMerchandise;
import com.web.web2022.model.outbound.OutBoundMerchandiseListPrice;
import com.web.web2022.model.outbound.OutBoundMerchandiseListScore;
import com.web.web2022.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/2 9:21
 */
//@RestController
//@RequestMapping("/products")
public class MerchandiseController {

    private static final byte MERCHANDISE_TYPE_PRICE = 0;//商品货币交易方式
    private static final byte MERCHANDISE_TYPE_SCORE = 1;//商品积分交易方式


    @Autowired
    MerchandiseService service;

    /**
     * 请求商品详情
     * uid 用于记录用户足迹
     * mid 为商品ID
     *
     * @return
     */
    @GetMapping("/{id}")
//    public OutBoundMerchandise queryMerchandiseInfo(InBoundMerchandiseInfo param, @AuthenticationPrincipal User user) {
    public OutBoundMerchandise queryMerchandiseInfo(
        @PathVariable Integer id, @AuthenticationPrincipal
        User user
    ) {
        return new OutBoundMerchandise(service.getMerchandiseInfo(user, id));
    }

    /**
     * 请求普通商品列表
     *
     * @return
     */
    @GetMapping("/price")
    public List<OutBoundMerchandiseListPrice> queryMerchandiseListPrice(InBoundMerchandiseList params,String words) {
        Long page = params.getPage();//请求分类页数
        Integer num = params.getNum();//请求商品的数量
        Long typeId = params.getTypeId();//指定分类商品(时使用)
        Byte type = params.getSortType();//请求商品的排序方式

        return service
            .listMerchandise((page * num), num, MERCHANDISE_TYPE_PRICE, typeId, type,words)
            .parallelStream()
            .map(OutBoundMerchandiseListPrice::new)
            .collect(Collectors.toList());
    }

    /**
     * 请求积分商品列表
     *
     * @return
     */
    @GetMapping("/score")
    public List<OutBoundMerchandiseListScore> queryMerchandiseScore(InBoundMerchandiseList params) {
        Long page = params.getPage();//请求开始的位置
        Integer num = params.getNum();//请求商品的数量
        Long typeId = params.getTypeId();//指定分类商品(时使用)
        Byte type = params.getSortType();//请求商品的排序方式

        return service
            .listMerchandise((page * num), num, MERCHANDISE_TYPE_SCORE, typeId, type,null)
            .parallelStream()
            .map(OutBoundMerchandiseListScore::new)
            .collect(Collectors.toList());
    }

}
