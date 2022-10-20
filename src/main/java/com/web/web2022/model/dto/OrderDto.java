package com.web.web2022.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.web.web2022.dao.SkuDao;
import com.web.web2022.model.enumeration.OrderState;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import lombok.Builder;
import lombok.Value;

public class OrderDto {
    public static class Out {

        @Builder
        @Value
        public static class Default {
            long id;
            Instant createdAt;
            BigDecimal price;
            OrderState state;
            int amount;
            SkuDto.Out.Default sku;
        }


        @Builder
        @Value
        public static class Counter {
            @JsonProperty("UNPAID")
            int unpaidOrderCount;
            @JsonProperty("PAID")
            int paidOrderCount;
            @JsonProperty("DELIVERED")
            int deliveredOrderCount;
            @JsonProperty("RECEIVED")
            int receivedOrderCount;
        }
    }
}
