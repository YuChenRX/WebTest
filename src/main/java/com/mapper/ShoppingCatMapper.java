package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pojo.Collect;
import com.pojo.ShoppingCat;
import com.pojo.UserPurse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShoppingCatMapper extends BaseMapper<ShoppingCat> {
    ShoppingCat getShoppingCat(Integer id);

    ShoppingCat getShoppingCatByonid(String onid);

    List<ShoppingCat> getShoppingCatlist(Integer id);

    List<ShoppingCat> selectAlls0(@Param("commodstatus") Integer commodstatus,@Param("uid") Integer uid);//五个状态查询

    ShoppingCat getSUC(Integer id);

    boolean addShoppingCat(ShoppingCat shoppingCat);

    boolean editShoppingCat(ShoppingCat shoppingCat);

    boolean deleteShoppingCat(Integer id);

    List<ShoppingCat> getAllShoppingCat();

    List<ShoppingCat>selectALLShoppingCat();

    List<ShoppingCat>selectAllsUc();



    boolean updateAlls1(ShoppingCat shoppingCat);//付款

    boolean updateAlls2(ShoppingCat shoppingCat);
    boolean updateAllst(ShoppingCat shoppingCat);

    boolean updateAlls4(int id);

    boolean updateAlls5(ShoppingCat shoppingCat);

    boolean updateAlls6(ShoppingCat shoppingCat);
    boolean updateAlls7(ShoppingCat shoppingCat);

    List<ShoppingCat>selectAlls2();//待收货

    List<ShoppingCat>selectAlls3();//待评价

    List<ShoppingCat>selectAlls4();//已完成

}
