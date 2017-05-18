package com.shine.video.bean;

/**
 * 结果bean
 */
public class ResultBean {

    final public static ResultBean SUCCESS = new ResultBean(200, "success");
    final public static ResultBean ERROR = new ResultBean(400, "error");

    protected int status;
    protected String msg;
    protected Object data;

    public ResultBean() {
    }

    private ResultBean(int status, String msg) {
        this(status, msg, null);
    }

    public ResultBean(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    private ResultBean copyThis() {
        return new ResultBean(status, msg, null);
    }

    public static ResultBean error(String error) {
        return new ResultBean(ERROR.status, error);
    }

    public static ResultBean success(String error) {
        return new ResultBean(SUCCESS.status, error);
    }

    public static ResultBean success(Object object) {
        ResultBean r = ResultBean.SUCCESS.copyThis();
        r.setData(object);
        return r;
    }
}
