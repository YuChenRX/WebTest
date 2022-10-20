package com.web.web2022.model.outbound;

import com.web.web2022.model.domain.MerchandiseType;

import java.util.List;

/**
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/5 13:33
 */
public class OutBoundMerchandiseType {
    private final MerchandiseType merchandiseType;

    public OutBoundMerchandiseType(MerchandiseType merchandiseType) {
        this.merchandiseType = merchandiseType;
    }

    public Long getTid() {
        return merchandiseType.getTid();
    }

    public String getName() {
        return merchandiseType.getName();
    }

    public String getUrl() {
        return merchandiseType.getUrl();
    }

    public List<MerchandiseType> getChildTypeList() {
        return merchandiseType.getChildTypeList();
    }
}
