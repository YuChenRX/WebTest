package com.pojo;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Intergral {
    //积分
    private String Integralgoodsname    ;
    private int intergralid             ;
    private double intergralprice       ;
    private int comid                   ;
    @TableField(exist = false)
    private Commodity commodity         ;
}
