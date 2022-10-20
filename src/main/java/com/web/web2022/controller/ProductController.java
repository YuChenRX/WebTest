package com.web.web2022.controller;

import com.web.web2022.model.dto.ProductDto;
import com.web.web2022.model.enumeration.SortBy;
import com.web.web2022.model.enumeration.ProductType;
import com.web.web2022.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto.Out> find(ProductDto.In.QueryParams params) {
        return productService.find(Objects.requireNonNull(params));
    }

    @GetMapping("/{id}")
    public Optional<ProductDto.Out> findOne(@PathVariable int id) {
        return productService.findOne(id);
    }
}
