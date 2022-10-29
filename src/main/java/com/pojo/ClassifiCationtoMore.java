package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("classificationtomore")
public class ClassifiCationtoMore {
    @TableId(type = IdType.AUTO)
    private int ciid;
    private int caid;
    private String cname;
    private String cn1;
    private String cn2;

}
