package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.service.CoutouserService;
import com.service.UserPurseService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;



@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("userpurse")
public class UserPurse {


    //钱包
   private int uid              ;       //用户id
   private double blance        ;       //用户余额
   private int integral         ;       //用户积分
   private int buyafew          ;       //用户购买的数量
   private int coupon           ;       //用户的优惠券数量
   private int couponid         ;       //对应优惠券的外键
   @TableId(type = IdType.AUTO)
   private int pid              ;
   private int xfe              ;
   private int ljcz             ;
   @TableField(exist = false)
   private int value          ;
   @TableField(exist = false)
   private User user;

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public int getCoupon() {
      return coupon;
   }

   public void setCoupon(int coupon) {
      this.coupon = coupon;
   }
}
