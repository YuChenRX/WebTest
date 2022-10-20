package com.web.web2022.model.dto;

import lombok.Builder;
import lombok.Value;

public class OrderSkuDto {
    @Builder
    @Value
    public static class Out {
        int id;
        SkuDto.Out.Default sku;
        int amount;
    }
}
