package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShoppingCat {
    //购物车
    private int commodityid         ;   //商品id
    private String commoditycolor   ;   //商品名称
    private int commoditysum        ;   //商品数量
    private String commodguige      ;   //商品规格
    private int comid               ;
    private String commcolor        ;
    private int commodstatus        ;
    private int uid                 ;
    private int upid                ;
    private double value               ;
    private String onid             ;
    private Date udate              ;
    private double price            ;
    private User user               ;
    private Commodity commodity     ;
    private UserPurse userPurse     ;
    private  double ks;
    private int kid;
    private int k1;
    private int[] s;


    public BigDecimal getPrice() {

        return BigDecimal.valueOf(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
