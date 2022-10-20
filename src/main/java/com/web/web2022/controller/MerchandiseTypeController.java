package com.web.web2022.controller;

import com.web.web2022.model.inbound.InBoundMerchandiseType;
import com.web.web2022.model.outbound.OutBoundMerchandiseListPrice;
import com.web.web2022.model.outbound.OutBoundMerchandiseType;
import com.web.web2022.service.MerchandiseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/5 13:29
 */
@RequestMapping("/products_type")
@RestController
public class MerchandiseTypeController {

    @Autowired
    MerchandiseTypeService merchandiseTypeService;

    /**
     * 请求顶级分类列表
     *
     * @return
     */
    @GetMapping("/type")
    public List<OutBoundMerchandiseType> queryTypeList() {
        return merchandiseTypeService
                .queryTypeList()
                .parallelStream()
                .map(OutBoundMerchandiseType::new)
                .collect(Collectors.toList());
    }

    /**
     * 请求顶级分类列表
     *
     * @return
     */
    @GetMapping("/top_type")
    public List<OutBoundMerchandiseType> queryTopType() {
        return merchandiseTypeService
                .queryType(null)
                .parallelStream()
                .map(OutBoundMerchandiseType::new)
                .collect(Collectors.toList());
    }

    /**
     * 请求子级分类列表
     *
     * @return
     */
    @GetMapping("child_type")
    public List<OutBoundMerchandiseType> queryChildType(InBoundMerchandiseType param) {
        Long belongId = param.getBelongId();
        return merchandiseTypeService
                .queryType(belongId)
                .parallelStream()
                .map(OutBoundMerchandiseType::new)
                .collect(Collectors.toList());
    }

    /**
     * 请求符合类型的商品列表
     *
     * @return
     */
    @GetMapping("type_merchandise")
    public List<OutBoundMerchandiseListPrice> queryMerchandiseOfType(InBoundMerchandiseType param) {
        Long tid = param.getTid();//分类id 用于取出所有该分类的商品列表

        return merchandiseTypeService
                .queryMerchandiseOfType(tid)
                .parallelStream()
                .map(OutBoundMerchandiseListPrice::new)
                .collect(Collectors.toList());
    }


}
