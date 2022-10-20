package com.web.web2022.model.dto;

import com.web.web2022.model.domain.Merchandise;
import com.web.web2022.model.domain.Product;

import lombok.Builder;
import lombok.Value;

public class FavouriteDto {
    @Builder
    @Value
    public static class Out {
        int id;
        ProductDto.Out product;
    }
}
