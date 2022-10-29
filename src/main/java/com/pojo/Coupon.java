package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Coupon {
    //优惠券
    private int couponid                    ;
    private String couponname               ;
    private String discountinformation      ;
    private String discount                 ;
    private Date   periodofvalidity         ;
    private int     discountprc             ;
    private double price                    ;

    public BigDecimal getPrice() {

        return BigDecimal.valueOf(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
