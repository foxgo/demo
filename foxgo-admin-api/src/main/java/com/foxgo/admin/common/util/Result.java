package com.foxgo.admin.common.util;

import com.foxgo.admin.common.constant.ResultCodeEnum;

import java.io.Serializable;
import java.util.Optional;

public class Result<T> implements Serializable {
    private int code;
    private T data;
    private String message;

    public Result() {
    }

    public Result(IResultCode resultCode) {
        resultCode = Optional.ofNullable(resultCode).orElse(ResultCodeEnum.FAILED);
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public static Result fail(String Message) {
        return buildResult(null, ResultCodeEnum.FAILED.getCode(), Message);
    }

    public static Result fail(IResultCode resultCode) {
        return buildResult(null, resultCode);
    }

    public static <T> Result<T> success(T data) {
        IResultCode resultCode = ResultCodeEnum.SUCCESS;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            resultCode = ResultCodeEnum.FAILED;
        }
        return buildResult(data, resultCode);
    }

    public static <T> Result<T> buildResult(T data, IResultCode resultCode) {
        return buildResult(data, resultCode.getCode(), resultCode.getMessage());
    }

    private static <T> Result<T> buildResult(T data, int code, String Message) {
        Result<T> result = new Result();
        result.setCode(code);
        result.setData(data);
        result.setMessage(Message);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return "Result(code=" + this.getCode() + ", data=" + this.getData() + ", Message=" + this.getMessage() + ")";
    }
}
