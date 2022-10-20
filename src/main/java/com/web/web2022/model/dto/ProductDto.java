package com.web.web2022.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.web.web2022.model.domain.Twister;
import com.web.web2022.model.enumeration.ProductType;
import com.web.web2022.model.enumeration.SortBy;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

import lombok.Builder;
import lombok.Value;

public class ProductDto {
    public static class In {
        @Builder
        @Value
        public static class QueryParams {
            Integer page;
            SortBy sortBy;
            ProductType type;
            Integer categoryId;
        }
    }

    @Builder
    @Value
    public static class Out {
        int id;
        String title;
        BigDecimal price;
        Integer credit;
        String description;
        int visitedTimes;
        int soldCount;
        @JsonProperty("sku")
        LinkedHashMap<String, List<Twister>> specification;
        @JsonProperty("skuDetails")
        List<SkuDto.Out.Default> sku;
        List<String> carousel;
    }
}
