package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pojo.Collect;
import com.pojo.Intergral;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IntergralMapper extends BaseMapper<Intergral> {
    Intergral getIntergral(Integer id);

    boolean addIntergral(Intergral intergral);

    boolean editIntergral(Intergral intergral);

    boolean deleteIntergral(Integer id);

    List<Intergral> getAllIntergral();

    List<Intergral> getAllIntergralComm();
    Intergral getIntergralbycomid(Integer id);
}
