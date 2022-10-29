package com.mapper;

import com.pojo.ShoppingCat;
import com.pojo.Uaddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UaddressMapper {
    Uaddress getUaddress(Integer id);

    boolean addUaddress(Uaddress uaddress);

    boolean editUaddress(Uaddress uaddress);

    boolean deleteUaddress(Integer id);

    List<Uaddress> getAllUaddress(Integer id);

    boolean updatemor();
}
