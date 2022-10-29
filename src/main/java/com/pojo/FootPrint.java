package com.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("footprint")
public class FootPrint {
   private int fid                  ;
   private int comid                ;
   private Date ftime               ;
   private String fname             ;
   private String zsy1              ;
   private String zsy2              ;
   private int uid                  ;
   @TableField(exist = false)
   private Commodity commodity;
}
