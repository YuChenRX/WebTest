package com.web.web2022.repo;

import com.web.web2022.dao.TopUpPlanDao;
import com.web.web2022.model.domain.TopUpPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TopUpPlanRepo {
    @Autowired
    private TopUpPlanDao topUpPlanDao;


    public List<TopUpPlan> find() {
        return topUpPlanDao.find();
    }

    public Optional<TopUpPlan> findById(Integer id) {
        return topUpPlanDao.findById(id);
    }
}
