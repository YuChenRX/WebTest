package com.web.web2022.service;

import com.web.web2022.model.domain.Merchandise;
import com.web.web2022.model.domain.User;

import java.util.List;

/**
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/2 8:26
 */
public interface MerchandiseService {

    /**
     * 获取商品详细信息
     *
     * @param uid 用户id
     * @param mid 商品id
     * @return 商品对象
     */
    Merchandise getMerchandiseInfo(User user, long mid);

    /**
     * 获取普通商品的列表
     *
     * @param page     分类页
     * @param num      获取商品的信息数量
     * @param unit     获取的商品交易方式类型
     * @param typeID   分类页
     * @param sortType 请求商品列表的排序方式
     * @return 指定类型的商品列表
     */
    List<Merchandise> listMerchandise(Long page, Integer num, Byte unit, Long typeID, Byte sortType,String words);


}
