/**
 *@Title: BaseRespModel.java 
 *@Package com.hundsun.fund.product.model.mvc.base 
 *@Description: TODO(用一句话描述该文件做什么) 
 *@author A18ccms A18ccms_gmail_com   
 *@date 2015年4月29日 上午10:41:00 
 *@Copyright:Copyright (c) 
 *@Company:whty李焱生
 *@version V1.0 
 */
package com.hundsun.fund.product.mvc.model.base;

import java.io.Serializable;



/**
 *@Description:所有请求出参的基类
 *@Author:李焱生
 *@Since:2015年4月29日上午10:41:00  
 */
public class BaseRespModel implements Serializable
{
    private static final long serialVersionUID = -5844552753374691210L;
    
    /** 错误码 **/
    protected String code;
    
    /** 错误描述 **/
    protected String message;
    
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
