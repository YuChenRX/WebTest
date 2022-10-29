package com.service;

import com.mapper.CollectMapper;

import com.pojo.Collect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectService {
    @Autowired
    private CollectMapper collectMapper;

    public Collect getCollect(Integer id){

        return collectMapper.getCollect(id);
    }

    public boolean addCollect(Collect user){
        return collectMapper.addCollect(user);
    }

    public boolean modifyCollect(Collect user) {
        return collectMapper.editCollect(user);
    }

    public boolean deleteCollect(Integer id) {
        return collectMapper.deleteCollect(id);
    }

    public List<Collect> getAllCollect(){

        return collectMapper.getAllCollect();
    }
    public List<Collect> getAllCollectComm(Integer id){

        return collectMapper.getAllCollectComm(id);
    }
    public Collect getCollectbyname(String name){
        return collectMapper.getCollectbyname(name);
    }

    public Collect getCollectbyname1(Collect user){
        return collectMapper.getCollectbyname1(user);
    }
}
