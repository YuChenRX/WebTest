package com.web.web2022.controller;

import com.web.web2022.model.domain.User;
import com.web.web2022.model.dto.FavouriteDto;
import com.web.web2022.service.FavouriteService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequestMapping("/favourites")
@RestController
@RequiredArgsConstructor
public class FavouriteController {
    private final FavouriteService favouriteService;

    @PostMapping
    public FavouriteDto.Out add(@AuthenticationPrincipal User user, @RequestParam int productId) {
        return favouriteService.add(user, productId);
    }

    @DeleteMapping("/{id}")
    public void delete(@AuthenticationPrincipal User user, @PathVariable int id) {
        favouriteService.delete(user, id);
    }

    @DeleteMapping
    public void delete(@AuthenticationPrincipal User user, @RequestBody List<Integer> ids) {
        favouriteService.delete(user, ids);
    }

    @GetMapping
    public List<FavouriteDto.Out> find(
        @AuthenticationPrincipal User user,
        @RequestParam(required = false) Integer productId
    ) {
        return favouriteService.find(user, productId);
    }
}
