package com.hundsun.fund.product.commons.exception;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -6412861495820342841L;
    // 错误编码
    protected String          errorcode;
    // 错误描述
    protected String          errormsg;
    // 默认错误信息
    protected String          defaultmsg;
    // 错误
    protected String[]        args;

    public BaseException() {
        super ();
    }

    public BaseException(Throwable cause) {
        super (cause);
        if (cause instanceof BaseException) {
            BaseException e = (BaseException) cause;
            this.defaultmsg = e.defaultmsg;
            this.errormsg = e.errormsg;
            this.errorcode = e.errorcode;
        }
    }

    /**
     * @param cause  原始的异常信息
     * @param errorCode 错误编码
     */
    public BaseException(Throwable cause, String errorcode) {
        super (cause);
        this.errorcode = errorcode;
    }

    /**
     * @param cause  原始的异常信息
     * @param errorCode   错误编码
     * @param defaultMessage  默认显示信息，配置文件无对应值时显示
     */
    public BaseException(Throwable cause, String errorcode, String errormsg, String defaultmsg) {
        this (cause, errorcode);
        this.errormsg = errormsg;
        this.defaultmsg = defaultmsg;
    }

    /**
     * 
     * @param errorCode   错误编码
     * @param defaultMessage  默认显示信息，配置文件无对应值时显示
     */
    public BaseException(String errorcode, String errormsg, String defaultmsg) {
        super ();
        this.errorcode = errorcode;
        this.defaultmsg = defaultmsg;
        this.errormsg = errormsg;
    }
    
    public BaseException(String errorcode,String defaultmsg) {
        super ();
        this.errorcode = errorcode;
        this.defaultmsg = defaultmsg;
    }

    public BaseException(String errorcode, String errormsg, String[] args, String defaultmsg) {
        super ();
        this.errorcode = errorcode;
        this.errormsg = errormsg;
        this.args = args;
        this.defaultmsg = defaultmsg;
    }

    public String[] getArgs(){
        return args;
    }

    public void setArgs(String[] args){
        this.args = args;
    }

    public String getErrormsg(){
        return errormsg;
    }

    public void setErrormsg(String errormsg){
        this.errormsg = errormsg;
    }

    public String getErrorcode(){
        return errorcode;
    }

    public void setErrorcode(String errorcode){
        this.errorcode = errorcode;
    }

    public String getDefaultmsg(){
        return defaultmsg;
    }

    public void setDefaultmsg(String defaultmsg){
        this.defaultmsg = defaultmsg;
    }

}
