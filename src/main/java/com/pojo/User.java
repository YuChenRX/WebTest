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
public class User {
    private String uname;
    private String upassword;
    @TableId(type = IdType.AUTO)
    private int uid;
    private String uface;
    private String ulname;
    @TableField(exist = false)
    private String n1;

}
