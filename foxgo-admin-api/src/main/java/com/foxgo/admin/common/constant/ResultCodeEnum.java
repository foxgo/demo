package com.foxgo.admin.common.constant;


import com.foxgo.admin.common.util.IResultCode;

public enum ResultCodeEnum implements IResultCode {
    FAILED(-1, "失败"),
    SUCCESS(20000, "成功"),
    SERVICE_ERROR(500,"服务器报错");


    private final int code;
    private final String message;

    ResultCodeEnum(int code,String message) {
        this.code=code;
        this.message=message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return String.format(" ResultCodeEnum:{code=%s, Message=%s} ", this.code, this.message);
    }
}
