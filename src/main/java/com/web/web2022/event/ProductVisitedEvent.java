package com.web.web2022.event;

import com.web.web2022.model.domain.Product;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class ProductVisitedEvent extends ApplicationEvent {
    private final Product product;

    public ProductVisitedEvent(Object source, Product product) {
        super(source);
        this.product = product;
    }
}
