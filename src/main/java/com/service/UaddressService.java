package com.service;

import com.mapper.ShoppingCatMapper;
import com.mapper.UaddressMapper;
import com.pojo.ShoppingCat;
import com.pojo.Uaddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UaddressService {
    @Autowired
    private UaddressMapper uaddressMapper;

    public Uaddress getUaddress(Integer id){

        return uaddressMapper.getUaddress(id);
    }

    public boolean addUaddress(Uaddress uaddress){
        return uaddressMapper.addUaddress(uaddress);
    }

    public boolean modifyUaddress(Uaddress uaddress) {
        return uaddressMapper.editUaddress(uaddress);
    }

    public boolean deleteUaddress(Integer id) {
        return uaddressMapper.deleteUaddress(id);
    }

    public List<Uaddress> getAllUaddress(Integer id){

        return uaddressMapper.getAllUaddress(id);
    }
    public boolean updatemor(){
        return uaddressMapper.updatemor();
    }
}
