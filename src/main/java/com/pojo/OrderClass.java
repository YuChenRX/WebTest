package com.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@TableName("order_class")
public class OrderClass {
    int id;
    int userid;
    int commodityguigeid;
    int sum; //数量
    int status;//状态
}
