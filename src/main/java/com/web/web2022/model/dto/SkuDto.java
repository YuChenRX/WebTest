package com.web.web2022.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

public class SkuDto {
    public static class In {
        @Builder
        @Jacksonized
        @Value
        public static class Calc {
            int amount;
            int skuId;
        }
    }

    public static class Out {
        @Builder
        @Value
        public static class Default {
            int id;
            String indexes;
            String title;
            BigDecimal price;
            int stock;
            String image;
        }

        @Builder
        @Value
        public static class Calculator {
            BigDecimal price;
            List<CalcItem> items;
        }

        @Builder
        @Value
        public static class CalcItem {
            int amount;
            @JsonProperty("selectedSku")
            SkuDto.Out.Default sku;
            ProductDto.Out product;
        }

        @Builder
        @Value
        public static class Buying {
            String msg;
            boolean ok;
        }
    }
}
