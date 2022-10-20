package com.web.web2022.model.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.web.web2022.model.domain.Merchandise;
import com.web.web2022.model.domain.Twister;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 索姆斯小鼠
 * @version 1.0
 * @date 2022/3/2 8:34
 */
public class OutBoundMerchandise {
    private final Merchandise merchandise;

    public OutBoundMerchandise(Merchandise merchandise) {
        this.merchandise = merchandise;
    }

    public Long getMid() {
        return merchandise.getMid();
    }

    public String getName() {
        return merchandise.getName();
    }

    public BigDecimal getOldPrice() {
        return merchandise.getOldPrice();
    }

    public BigDecimal getPrice() {
        return merchandise.getPrice();
    }

    public String getDescribe() {
        return merchandise.getDescribe();
    }

    public Long getBrowseNum() {
        return merchandise.getBrowseNum();
    }

    public Long getSalesNum() {
        return merchandise.getSalesNum();
    }

    public Long getScore() {
        return merchandise.getScore();
    }

    public Long getTypeId() {
        return merchandise.getTypeId();
    }

    public Long getTime() {
        return merchandise.getTime();
    }

    public List<String> getUrl() {
        return merchandise.getUrl();
    }

    @JsonProperty("skuDetails")
    public List<OutBoundSkuDetails> getSku() {
        return merchandise.getSku()
                .parallelStream()
                .map(OutBoundSkuDetails::new)
                .collect(Collectors.toList());
    }

    @JsonProperty("sku")
    public LinkedHashMap<String, List<Twister>> getTwister() {
        return merchandise.getTwister();
    }

}
