package com.mapper;

import com.pojo.Collect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CollectMapper {

    Collect getCollect(Integer id);

    boolean addCollect(Collect collect);

    boolean editCollect(Collect collect);


    boolean deleteCollect(@Param("comid") Integer id);

    List<Collect> getAllCollect();

    List<Collect> getAllCollectComm(Integer id);

    Collect getCollectbyname(String name);

    Collect getCollectbyname1(Collect collect);
}
