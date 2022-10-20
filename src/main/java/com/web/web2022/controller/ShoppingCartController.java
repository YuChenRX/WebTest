package com.web.web2022.controller;

import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.ShoppingCartDto;
import com.web.web2022.service.ShoppingCartService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequestMapping({"/shoppingCart", "/shopping-cart"})
@RestController
@RequiredArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @GetMapping
    public List<ShoppingCartDto.Out> find(@AuthenticationPrincipal User user) {
        return shoppingCartService.find(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id, @AuthenticationPrincipal User user) {
        shoppingCartService.remove(user, id);
    }

    @PutMapping("/{id}")
    public ShoppingCartDto.Out update(
        @PathVariable Integer id,
        @RequestBody @Validated ShoppingCartDto.In.Update dto,
        @AuthenticationPrincipal User user
    ) {
        return shoppingCartService.update(user, id, dto);
    }

    @PostMapping
    public ShoppingCartDto.Out add(
        @RequestBody ShoppingCartDto.In.Addition dto,
        @AuthenticationPrincipal User user
    ) {
        return shoppingCartService.add(user, dto);
    }

//    @PostMapping("/buy")
//    public Integer buy(@RequestBody List<InBoundOrder> orders, @AuthenticationPrincipal User user) {
//        return shoppingCartService.buy(orders, user);
//    }
}
