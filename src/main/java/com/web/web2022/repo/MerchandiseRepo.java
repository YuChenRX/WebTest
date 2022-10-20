package com.web.web2022.repo;

import com.web.web2022.dao.MerchandiseDao;
import com.web.web2022.dao.SkuDao;
import com.web.web2022.model.domain.Merchandise;
import com.web.web2022.model.domain.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MerchandiseRepo {
    @Autowired
    private MerchandiseDao merchandiseMapper;
    @Autowired
    private SkuDao skuDao;

    public Merchandise selectMerchandiseInfo(long mid) {
        Merchandise merchandise = merchandiseMapper.selectMerchandiseInfo(mid);

        List<Sku> skuDetails = skuDao.find((int) mid);
        if (skuDetails.isEmpty()) {
            return merchandise;
        }

        merchandise.setSku(skuDetails);

        return merchandise;
    }

    public List<String> selectMerchandiseCarousel(long mid) {
        return merchandiseMapper.selectMerchandiseCarousel(mid);
    }

    public List<Merchandise> selectMerchandiseList(
        Long page,
        Integer num,
        Byte unit,
        Long typeId,
        Byte sortType,
        String words
    ) {
        return merchandiseMapper.selectMerchandiseList(page, num, unit, typeId, sortType,words);
    }

    public Integer updateMerchandiseBrowse(Long mid) {
        return merchandiseMapper.updateMerchandiseBrowse(mid);
    }
}
