package com.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("commoditycolor")
public class CommodityColor {

    private int comid                ;
    private String n1               ;
    private int n2               ;
    private String n3               ;
    private int cid              ;
    private String img              ;
    private String previmg              ;
    private int cpid             ;
    private boolean isimg                ;
    public  Commodityguige commodityguige;

}
