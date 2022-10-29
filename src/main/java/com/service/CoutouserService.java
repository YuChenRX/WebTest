package com.service;

import com.mapper.CouponMapper;
import com.mapper.CoutouserMapper;
import com.pojo.Coupon;
import com.pojo.Coutouser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoutouserService {
    @Autowired
    private CoutouserMapper coutouserMapper;

    public Coutouser getCoutouser(Integer id){

        return coutouserMapper.getCoutouser(id);
    }

    public Coutouser getCoutousertolzc2(Integer id){

        return coutouserMapper.getCoutousertolzc2(id);
    }

    public boolean addCoutouser(Coutouser coupon){
        return coutouserMapper.addCoutouser(coupon);
    }

    public boolean modifyCoutouser(Coutouser coupon) {
        return coutouserMapper.editCoutouser(coupon);
    }

    public boolean deleteCoutouser(Integer id) {
        return coutouserMapper.deleteCoutouser(id);
    }

    public List<Coutouser> getAllCoutouser(Integer id){

        return coutouserMapper.getAllCoutouser(id);
    }
    public int Getsum(Integer id) {
        return coutouserMapper.getsum(id);
    }
    public boolean editCoutousertolzc1(Integer id){
        return coutouserMapper.editCoutousertolzc1(id);
    }
    public boolean editCoutousertolzc1two(Integer id){
        return coutouserMapper.editCoutousertolzc1two(id);
    }

    public boolean editCoutousertoMore(Coutouser coupon){
        return coutouserMapper.editCoutousertoMore(coupon);
    }
}
