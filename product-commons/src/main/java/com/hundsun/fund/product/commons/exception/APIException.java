/**
 * @Title: APIException.java
 * @Package com.hundsun.fund.product.commons.exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月29日 下午9:15:55
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.commons.exception;

/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年4月29日下午9:15:55  
 */
public class APIException extends BaseException {

    private static final long serialVersionUID = 470306329446409921L;

    public APIException(Throwable cause) {
        super (cause);
    }

    public APIException(Throwable cause, String errorcode) {
        super (cause, errorcode);
    }

    public APIException(Throwable cause, String errorcode, String errormsg, String defaultmsg) {
        super (cause, errorcode, errormsg, defaultmsg);
    }

    public APIException(String errorcode, String errormsg, String defaultmsg) {
        super (errorcode, errormsg, defaultmsg);
    }

    public APIException(String errorcode, String errormsg, String[] args, String defaultmsg) {
        super (errorcode, errormsg, args, defaultmsg);
    }

    public APIException(String errorcode, String defaultmsg) {
        super (errorcode, defaultmsg);
    }
}
