package com.web.web2022.service.impl;

import com.web.web2022.dao.MerchandiseTypeDao;
import com.web.web2022.model.domain.Merchandise;
import com.web.web2022.model.domain.MerchandiseType;
import com.web.web2022.service.MerchandiseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/5 14:13
 */
@Service
public class MerchandiseTypeServiceImpl implements MerchandiseTypeService {

    @Autowired
    private MerchandiseTypeDao merchandiseTypeDao;

    /**
     * 请求商品类型列表
     *
     * @return
     */
    @Override
    public List<MerchandiseType> queryTypeList() {
        List<MerchandiseType> merchandiseTypes = merchandiseTypeDao.selectType(null);//顶级列表

        merchandiseTypes.forEach(item -> {
            item.setChildTypeList(
                    merchandiseTypeDao.selectType(
                            item.getTid()
                    )
            );
        });

        return merchandiseTypes;
    }

    /**
     * 请求商品类型列表
     *
     * @param belongId 父类型id (如若获取顶级列表 则传null)
     * @return
     */
    @Override
    public List<MerchandiseType> queryType(Long belongId) {
        return merchandiseTypeDao.selectType(belongId);
    }

    /**
     * 请求指定分类的商品列表
     *
     * @param typeId 指定分类ID
     * @return
     */
    @Override
    public List<Merchandise> queryMerchandiseOfType(Long typeId) {
        return merchandiseTypeDao.selectMerchandiseOfType(typeId);
    }
}
