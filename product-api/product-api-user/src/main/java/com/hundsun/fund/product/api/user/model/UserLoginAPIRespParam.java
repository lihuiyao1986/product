/**
 *@Title: UserLoginAPIRespBean.java 
 *@Package com.hundsun.fund.product.api.user.model 
 *@Description: TODO(用一句话描述该文件做什么) 
 *@author A18ccms A18ccms_gmail_com   
 *@date 2015年5月6日 上午9:32:27 
 *@Copyright:Copyright (c) 
 *@Company:whty李焱生
 *@version V1.0 
 */
package com.hundsun.fund.product.api.user.model;

import com.hundsun.fund.product.commons.model.BaseAPIRespParam;
import com.hundsun.fund.product.dao.model.UserInfoDaoModel;



/**
 *@Description:用户登录出参类
 *@Author:李焱生
 *@Since:2015年5月6日上午9:32:27  
 */
public class UserLoginAPIRespParam extends BaseAPIRespParam {
    
    private static final long serialVersionUID = 361478931175628201L;
    
    /** 用户信息 **/
    private UserInfoDaoModel userInfo;
    
    /** 标识登录用户 **/
    private String token;

    public UserInfoDaoModel getUserInfo(){
        return userInfo;
    }

    public void setUserInfo(UserInfoDaoModel userInfo){
        this.userInfo = userInfo;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }
}
