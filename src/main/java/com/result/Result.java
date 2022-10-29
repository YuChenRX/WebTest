package com.result;

public class Result {
    private int code;

    private Object msg;

    private Object sku;

    private Object c;

    private Object w;

    public Object getW() {
        return w;
    }

    public void setW(Object w) {
        this.w = w;
    }

    public Object getSku() {
        return sku;
    }

    public void setSku(Object sku) {
        this.sku = sku;
    }

    public Object getMsg() {
        return msg;
    }

    public Object getC() {
        return c;
    }

    public void setC(Object c) {
        this.c = c;
    }

    public  void setMsg(Object msg) {
        this.msg = msg;
    }
    public Result(){}

    public Result(int code) {
        this.code = code;
    }
    public Result(int code,Object msg){
        this.code = code;
        this.msg = msg;
    }
//    public Result(int code,Object msg,Object masg1,Object masg2,Object masg3,Object masg4){
//        this.code = code;
//        this.msg = msg;
//        this.masg1 = masg1;
//        this.masg2 = masg2;
//        this.masg3 = masg3;
//        this.masg4 = masg4;
//    }
//    public Result(int code,Object name,Object password,Object email){
//        this.code = code;
//        this.name = name;
//        this.password = password;
//        this.email = email;
//    }
    public Result(int code,Object msg,Object sku){
        this.code = code;
        this.msg = msg;
        this.sku = sku;
    }
    public Result(int code,Object msg,Object sku,Object c){
        this.code = code;
        this.msg = msg;
        this.sku = sku;
        this.c   =  c;
    }
    public  Result(int code,Object w,Object msg,Object sku,Object c) {
        this.code = code;
        this.w = w;
        this.msg = msg;
        this.sku = sku;
        this.c = c;

    }
    public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }
}
