package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Classification {
    @TableId(type = IdType.AUTO)
    private int caid;
    private String img;
    private String title;
    @TableField("`index`")
    private int index;
    private String ca1;
    private String ca2;

}
