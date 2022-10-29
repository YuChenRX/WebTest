package com.event;

import com.pojo.Commodity;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class ProductVisitedEvent extends ApplicationEvent {
    private final Commodity commodity;
    private final int uid;

    public ProductVisitedEvent(Object source, Commodity commodity, int uid) {
        super(source);
        this.commodity = commodity;
        this.uid = uid;
    }
}
