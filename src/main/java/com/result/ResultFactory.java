package com.result;

public class ResultFactory {
    static Result rs=new  Result();
    public static Result buildSuccessResult(Object data) {
        if(data.equals(1)){
            return buildResult(ResultCode.SUCCESS, "成功", data);
        }else if (data.equals(0)) {
            return buildResult(ResultCode.FAIL, "失败", data);
        }else if(data.equals(true)){
            return buildResult(ResultCode.SUCCESS, "成功", data);
        }else if(data.equals(false)){
            return buildResult(ResultCode.FAIL, "失败", data);
        }else {
            return buildResult(ResultCode.SUCCESS, "成功", data);
        }

    }
    public static Result buildResult(Object data,Object data1,Object data2) {
        return new Result(200, data, data1,data2);
    }

    public static Result buildResult(Object data1,Object data2) {
        return new Result(200, data1,data2);
    }
    public static Result buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, message, null);
    }

    public static Result buildResult(ResultCode resultCode, String message, Object data) {
        return buildResult(resultCode.code, message, data);
    }
    public static Result buildResult(int resultCode, String message, Object date,Object data1) {
        return new Result(resultCode, message, date,data1);
    }
    public static   Result buildResult1(Object w,Object data,Object data1,Object data2) {
        return new  Result(200,w, data, data1,data2);
    }
    public static Result buildResult(int resultCode, String message, Object data) {
        return new Result(resultCode, message, data);
    }

}
