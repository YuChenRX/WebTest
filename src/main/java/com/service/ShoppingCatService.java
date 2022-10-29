package com.service;

import com.mapper.ShoppingCatMapper;
import com.mapper.UserMapper;
import com.pojo.ShoppingCat;
import com.pojo.User;
import com.pojo.UserPurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCatService {
    @Autowired
    private ShoppingCatMapper shoppingCatMapper;

    public ShoppingCat getShoppingCat(Integer id){

        return shoppingCatMapper.getShoppingCat(id);
    }
    public ShoppingCat getShoppingCatByonid(String onid){
        return shoppingCatMapper.getShoppingCatByonid(onid);
    }
    public List<ShoppingCat> getShoppingCatById(Integer id){
        return shoppingCatMapper.getShoppingCatlist(id);
    }


    public boolean addShoppingCat(ShoppingCat shoppingCat){
        return shoppingCatMapper.addShoppingCat(shoppingCat);
    }

    public boolean modifyShoppingCat(ShoppingCat shoppingCat) {
        return shoppingCatMapper.editShoppingCat(shoppingCat);
    }

    public boolean deleteShoppingCat(Integer id) {
        return shoppingCatMapper.deleteShoppingCat(id);
    }

    public List<ShoppingCat> getAllShoppingCat(){
        return shoppingCatMapper.getAllShoppingCat();
    }
    public List<ShoppingCat>selectALLUserPurse(){
        return shoppingCatMapper.selectALLShoppingCat();
    }

    public List<ShoppingCat> selectallSUC(){

        return shoppingCatMapper.selectAllsUc();
    }
    public ShoppingCat getSUC(Integer id){
        return shoppingCatMapper.getSUC(id);
    }

    public List<ShoppingCat> getZT(Integer commodstatus ,Integer uid){
        return shoppingCatMapper.selectAlls0(commodstatus,uid);
    }

    public boolean editPlayFone(ShoppingCat shoppingCat) {
        return shoppingCatMapper.updateAlls1(shoppingCat);
    }
    public boolean updateAllst(ShoppingCat shoppingCat) {
        return shoppingCatMapper.updateAllst(shoppingCat);
    }
    public boolean UpdateAlls2(ShoppingCat shoppingCat) {
        return shoppingCatMapper.updateAlls2(shoppingCat);
    }
    public boolean  updateAlls4(int id){
        return shoppingCatMapper.updateAlls4(id);
    }
    public boolean updateAlls5(ShoppingCat shoppingCat){
        return shoppingCatMapper.updateAlls5(shoppingCat);
    }

    public boolean updateAlls6(ShoppingCat shoppingCat){
        return shoppingCatMapper.updateAlls6(shoppingCat);
    }

    public boolean updateAlls7(ShoppingCat shoppingCat){
        return shoppingCatMapper.updateAlls7(shoppingCat);
    }
}
