package com.web.web2022.repo;

import com.web.web2022.dao.AddressDao;
import com.web.web2022.model.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressRepo {
    @Autowired
    private AddressDao addressDao;

    public Integer create(Address model) {
        return addressDao.create(model);
    }

    public Integer modify(Address model) {
        if (model.getDef()) {
            Optional<Address> defaultAddr = findDefault(model.getOwner().getId());
            if (defaultAddr.isPresent()) {
                defaultAddr.get().setDef(false);
                modify(defaultAddr.get());
            }
        }

        return addressDao.modify(model);
    }

    public void deleteById(Integer id, Integer ownerId) {
        addressDao.deleteById(id, ownerId);
    }

    public List<Address> find(Integer ownerId) {
        return addressDao.find(ownerId);
    }

    public Optional<Address> findById(Integer id, Integer ownerId) {
        return addressDao.findById(id, ownerId);
    }

    public Optional<Address> findDefault(Integer ownerId) {
        return addressDao.findDefault(ownerId);
    }
}
