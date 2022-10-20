package com.web.web2022.service;

import com.web.web2022.model.domain.Address;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.inbound.InBoundAddress;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address create(InBoundAddress address, User owner);

    Address modify(InBoundAddress address, User owner);

    void deleteById(Integer id, User owner);

    List<Address> find(User owner);

    Optional<Address> findDefault(User owner);

    Optional<Address> findById(Integer id, User owner);
}
