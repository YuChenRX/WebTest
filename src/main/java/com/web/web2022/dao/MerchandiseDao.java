package com.web.web2022.dao;

import com.web.web2022.model.domain.Merchandise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/2 18:57
 */
@Mapper
public interface MerchandiseDao {

    /**
     * 获取商品详细信息
     *
     * @param mid 商品ID
     * @return 商品详细信息
     */
    Merchandise selectMerchandiseInfo(@Param("mid") long mid);

    /**
     * 获取商品所有轮播图
     *
     * @param mid 商品id
     * @return 轮播图url列表
     */
    List<String> selectMerchandiseCarousel(@Param("mid") long mid);

    /**
     * 获取指定数量的商品，构成列表
     *
     * @param page     (分页)页数 [默认为1：从开始第一页获取]
     * @param num      获取多少个商品的概要
     * @param unit     交易方式 [默认为0] 0：货币 | 1：积分
     * @param typeId   搜索此分类id下的商品 [默认为null] null：不做限制 | else：限定搜索的商品的分类
     * @param sortType 商品排序方式 [默认为0] 0：销量排序 | 1：价格升序 | 2：价格降序 | 3：最新时间排序 | 4：浏览量排序
     * @return 商品概要信息列表
     */
    List<Merchandise> selectMerchandiseList(@Param("page") Long page,
                                            @Param("num") Integer num,
                                            @Param("unit") Byte unit,
                                            @Param("typeId") Long typeId,
                                            @Param("sortType") Byte sortType,
                                            @Param("keywords") String keywords);

    /**
     * 增加商品浏览数量
     *
     * @param mid 商品id
     */
    Integer updateMerchandiseBrowse(@Param("mid") Long mid);

    Merchandise selectMerchandiseByMid(@Param("mid") Long mid);
}
