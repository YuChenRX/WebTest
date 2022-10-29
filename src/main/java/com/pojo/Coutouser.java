package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Coutouser {
  private int uid                   ;
  private int kid                   ;
  private int cid                   ;
  private String uname              ;
  private String cname              ;
  private int lzc1                  ;
  private int lzc2               ;
  private User user;
  private Coupon coupon;

}
