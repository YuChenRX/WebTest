package com.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.ClassifiCationtoMoreMapper;
import com.mapper.ClassificationMapper;
import com.pojo.ClassifiCationtoMore;
import com.pojo.Classification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifiCationtoMoreService extends ServiceImpl<ClassifiCationtoMoreMapper, ClassifiCationtoMore> {
    public List<ClassifiCationtoMore> find() {
        return list();
    }
}
