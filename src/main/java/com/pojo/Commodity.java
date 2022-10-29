package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Commodity {
    private String picture  ;         //图片地址
    private boolean brand   ;        //是否为品牌
    private String name     ;         //商品名称
    private String redname  ;         //品质险
    private String blackname;         //其他
    private double price    ;         //价格
    private String spell    ;         //售出件数
    @TableId(type = IdType.AUTO, value = "commodityID")
    @TableField("commodityID")
    private int commodityID ;          //主键
    @TableField("BYBT")
    private boolean BYBT    ;        //是否是百亿补贴
    private Date  adtime    ;       //添加时间
    private int caid     ;
    @TableField(exist = false)
    private String mh   ;
    @TableField(exist = false)
    private Commoditytomore commoditytomore;
    @TableField(exist = false)
    private Commodityguige commodityguige;
    @TableField(exist = false)
    List<Commodityguige> commodityguigeList;
}
