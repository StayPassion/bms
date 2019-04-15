package com.xzt.util;

public class RetResponse {

    public static <T> RetResult<T> makeOKRsp(String message) {
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(message);
    }

    public static <T> RetResult<T> makeOKRsp(String message, T data) {
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(message).setData(data);
    }

    public static <T> RetResult<T> makeErrRsp(String message) {
        return new RetResult<T>().setCode(RetCode.FAIL).setMsg(message);
    }

    public static <T> RetResult<T> makeInternalServiceErrors(String message) {
        return new RetResult<T>().setCode(RetCode.INTERNAL_SERVER_ERROR).setMsg(message);
    }

    public static <T> RetResult<T> makeRsp(int code, String msg) {
        return new RetResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> RetResult<T> makeRsp(int code, String msg, T data) {
        return new RetResult<T>().setCode(code).setMsg(msg).setData(data);
    }

}
