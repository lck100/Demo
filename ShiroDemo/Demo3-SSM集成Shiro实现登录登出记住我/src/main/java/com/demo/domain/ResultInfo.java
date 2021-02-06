package com.demo.domain;

import java.io.Serializable;

public class ResultInfo implements Serializable {
    private int code;// 1表示成功，0表示执行失败
    private String msg;// 执行结果状态描述
    private Object data;// 执行结果

    public ResultInfo() {
    }

    public ResultInfo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultInfo(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
