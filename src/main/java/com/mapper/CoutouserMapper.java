package com.mapper;

import com.pojo.Coupon;
import com.pojo.Coutouser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoutouserMapper {
    Coutouser getCoutouser(Integer id);

    Coutouser getCoutousertolzc2 (Integer id);
    boolean addCoutouser(Coutouser coupon);

    boolean editCoutouser(Coutouser coupon);

    boolean deleteCoutouser(Integer id);

    List<Coutouser> getAllCoutouser(Integer id);

    int  getsum(Integer id);
    boolean editCoutousertolzc1(Integer id);

    boolean editCoutousertolzc1two(Integer id);
    boolean editCoutousertoMore(Coutouser coupon);

}
