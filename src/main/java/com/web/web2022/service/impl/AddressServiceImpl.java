package com.web.web2022.service.impl;

import com.web.web2022.model.domain.Address;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.inbound.InBoundAddress;
import com.web.web2022.repo.AddressRepo;
import com.web.web2022.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepo addressRepo;


    @Override
    public Address create(InBoundAddress address, User owner) {
        Address model = address.getModel();
        model.setOwner(owner);

        addressRepo.create(model);
        return model;
    }

    @Override
    public Address modify(InBoundAddress address, User owner) {
        Address model = address.getModel();
        model.setOwner(owner);

        addressRepo.modify(model);
        return model;
    }

    @Override
    public void deleteById(Integer id, User owner) {
        addressRepo.deleteById(id, owner.getId());
    }

    @Override
    public List<Address> find(User owner) {
        return addressRepo.find(owner.getId());
    }

    @Override
    public Optional<Address> findDefault(User owner) {
        return addressRepo.findDefault(owner.getId());
    }

    @Override
    public Optional<Address> findById(Integer id, User owner) {
        return addressRepo.findById(id, owner.getId());
    }
}
