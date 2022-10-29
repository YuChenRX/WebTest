package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName("shoppingcat")
public class ShoppingCat {
    //购物车
    @TableId
    private int commodityid         ;   //商品id
    private String commoditycolor   ;   //商品名称
    private int commoditysum        ;   //商品数量
    private String commodguige      ;   //商品规格
    private int comid               ;
    private String commcolor        ;
    private int commodstatus        ;
    private int uid                 ;
    private int upid                ;
    @TableField(exist = false)
    private double value               ;
    private String onid             ;
    private Date udate              ;
    private double price            ;
    @TableField(exist = false)
    private User user               ;
    @TableField(exist = false)
    private Commodity commodity     ;
    @TableField(exist = false)
    private UserPurse userPurse     ;
    @TableField(exist = false)
    private  double ks;
    @TableField(exist = false)
    private int kid;
    @TableField(exist = false)
    private int k1;
    @TableField(exist = false)
    private int[] s;


    public BigDecimal getPrice() {

        return BigDecimal.valueOf(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
