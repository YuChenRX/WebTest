package com.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Commodityguige {
    @TableId
    private int id        ;
    private String sumname    ;
    private double price    ;
    private int cpid    ;
    private int gg1    ;
    private int gg2    ;
    private int gg3        ;
    private int comid    ;
    private int s1    ;
    private int s2    ;
    @TableField(exist = false)
    private int sum;
    @TableField(exist = false)

    private int kid;

    public BigDecimal getPrice() {

        return BigDecimal.valueOf(price);
    }
    public BigDecimal Commodityguige(){
        return BigDecimal.valueOf(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
