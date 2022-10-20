package com.web.web2022.event.listener;

import com.web.web2022.dao.ProductDao;
import com.web.web2022.event.ProductVisitedEvent;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductVisitedTimesIncreasing {
    private final ProductDao productDao;

    @Async
    @EventListener
    public void increase(ProductVisitedEvent event) {
        productDao.increaseVisitedCount(event.getProduct().getId());
    }
}
