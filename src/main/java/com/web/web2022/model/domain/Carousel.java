package com.web.web2022.model.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Carousel {
    int id;
    String url;
    int productId;
}
