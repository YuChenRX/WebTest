package com.web.web2022.dao;

import com.web.web2022.model.domain.Merchandise;
import com.web.web2022.model.domain.MerchandiseType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/5 14:26
 */
@Mapper
public interface MerchandiseTypeDao {

    /**
     * 请求商品类型列表
     *
     * @param belongId 父类型id (如若获取顶级列表 则传null)
     * @return
     */
    List<MerchandiseType> selectType(Long belongId);

    /**
     * 请求指定分类的商品列表
     *
     * @param typeId 指定分类ID
     * @return
     */
    List<Merchandise> selectMerchandiseOfType(Long typeId);


}
