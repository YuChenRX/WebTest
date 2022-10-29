package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormet  {
    public Date  Datw(Date date)  {
        Date d=new Date();
       try {
           SimpleDateFormat sd=new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");


        String k=sd.format(date);
           System.out.println(k);
         d=sd.parse(k);
           return d;
       }catch (Exception e) {
           System.out.println("时间转化错误");
       }
return d;
    }
}
