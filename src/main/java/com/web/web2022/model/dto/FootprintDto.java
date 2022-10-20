package com.web.web2022.model.dto;

import java.time.Instant;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

public class FootprintDto {
    public static class In {
        @Builder
        @Jacksonized
        @Value
        public static class Addition {
            int productId;
        }
    }

    @Builder
    @Value
    public static class Out {
        int id;
        ProductDto.Out product;
        Instant updatedAt;
    }
}
