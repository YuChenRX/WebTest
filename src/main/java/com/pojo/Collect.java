package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Collect {
    //收藏商品的信息
    private String cname;
    private String collector;
    private boolean collectstate;
    private int cid;
    private int uid;
    private int comid;
    private Commodity commodity;
    private User user;
    private Date cdate;
}
