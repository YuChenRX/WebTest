package com.web.web2022.dao;

import com.web.web2022.model.domain.TopUpPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TopUpPlanDao {
    List<TopUpPlan> find();

    Optional<TopUpPlan> findById(@Param("id") Integer id);
}
