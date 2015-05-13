/**
 * @Title: BaseAPIRespParam.java
 * @Package com.hundsun.fund.product.commons.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月30日 上午11:16:53
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.commons.model;

import java.io.Serializable;

/**
 *@Description:调用api的出参
 *@Author:李焱生
 *@Since:2015年4月30日上午11:16:53  
 */
public class BaseAPIRespParam implements Serializable {
    private static final long serialVersionUID = 2021634025260532504L;
    /** 错误码 **/
    private String            code;
    /** 错误描述 **/
    private String            message;

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

}
