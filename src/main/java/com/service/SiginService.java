package com.service;

import com.mapper.CouponMapper;
import com.mapper.SiginMapper;
import com.pojo.Coupon;
import com.pojo.Sigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiginService {
    @Autowired
    private SiginMapper siginMapper;

    public Sigin getSigin(Integer id){

        return siginMapper.getSigin(id);
    }

    public boolean addSigin(Sigin sign){
        return siginMapper.addSigin(sign);
    }

    public boolean modifySigin(Sigin sign) {
        return siginMapper.editSigin(sign);
    }

    public boolean deleteSigin(Integer id) {
        return siginMapper.deleteSigin(id);
    }

    public List<Sigin> getAllSigin(){

        return siginMapper.getAllSigin();
    }
}
