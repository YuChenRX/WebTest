package com.web.web2022.model.dto;

import javax.validation.constraints.Min;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

public class ShoppingCartDto {
    public static class In {
        @Builder
        @Jacksonized
        @Value
        public static class Addition {
            int skuId;
            int productId;
            int amount;
        }


        @Builder(toBuilder = true)
        @Jacksonized
        @Value
        public static class Update {
            int skuId;
            @Min(1)
            int amount;
            int productId;
        }
    }


    @Builder
    @Value
    public static class Out {
        int id;
        ProductDto.Out product;
        SkuDto.Out.Default sku;
        int amount;
    }
}
