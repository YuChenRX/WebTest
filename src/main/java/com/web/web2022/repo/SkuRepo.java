package com.web.web2022.repo;

import com.web.web2022.dao.SkuDao;
import com.web.web2022.model.domain.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SkuRepo {
    @Autowired
    private SkuDao skuDao;


    public List<Sku> find(Integer id) {
        return skuDao.find(id);
    }

    public Optional<Sku> findById(Integer id) {
        return skuDao.findById(id);
    }

    public Integer reduceStock(Integer id, Integer stock) {
        return skuDao.reduceStock(id, stock);
    }
}
