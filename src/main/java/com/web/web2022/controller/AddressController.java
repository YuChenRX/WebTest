package com.web.web2022.controller;

import com.web.web2022.model.domain.User;
import com.web.web2022.model.inbound.InBoundAddress;
import com.web.web2022.model.outbound.OutBoundAddress;
import com.web.web2022.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<OutBoundAddress> find(@AuthenticationPrincipal User user) {
        return addressService.find(user).parallelStream()
            .map(OutBoundAddress::new)
            .collect(Collectors.toList());
    }

    @GetMapping("/default")
    public Optional<OutBoundAddress> findDefault(@AuthenticationPrincipal User user) {
        return addressService.findDefault(user).map(OutBoundAddress::new);
    }

    @GetMapping("/{id}")
    public Optional<OutBoundAddress> findById(
        @PathVariable Integer id,
        @AuthenticationPrincipal User user
    ) {
        return addressService.findById(id, user).map(OutBoundAddress::new);
    }

    @PostMapping
    public OutBoundAddress create(
        @Validated @RequestBody InBoundAddress address,
        @AuthenticationPrincipal User user
    ) {
        return new OutBoundAddress(addressService.create(address, user));
    }

    @PutMapping("/{id}")
    public OutBoundAddress modify(
        @PathVariable Integer id,
        @Validated @RequestBody InBoundAddress address,
        @AuthenticationPrincipal User user
    ) {
        address.setId(id);
        return new OutBoundAddress(addressService.modify(address, user));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id, @AuthenticationPrincipal User user) {
        addressService.deleteById(id, user);
    }
}
