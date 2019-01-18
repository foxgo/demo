package com.foxgo.admin.common.exception;

public class DAOException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String msg;
    private long code = 50002;

    public DAOException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public DAOException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public DAOException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public DAOException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
