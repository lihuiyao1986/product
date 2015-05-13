/**
 *@Title: UserInfoQueryInRedisRespParam.java 
 *@Package com.hundsun.fund.product.api.user.model 
 *@Description: TODO(用一句话描述该文件做什么) 
 *@author A18ccms A18ccms_gmail_com   
 *@date 2015年5月7日 下午4:29:24 
 *@Copyright:Copyright (c) 
 *@Company:whty李焱生
 *@version V1.0 
 */
package com.hundsun.fund.product.api.user.model;

import com.hundsun.fund.product.commons.model.BaseAPIRespParam;
import com.hundsun.fund.product.dao.model.UserInfoDaoModel;



/**
 *@Description:从redis中查询用户信息的出参类
 *@Author:李焱生
 *@Since:2015年5月7日下午4:29:24  
 */
public class UserInfoQueryInRedisAPIRespParam extends BaseAPIRespParam{
    
    private static final long serialVersionUID = 6647698475914079101L;
    
    private UserInfoDaoModel userInfo;

    public UserInfoDaoModel getUserInfo(){
        return userInfo;
    }

    public void setUserInfo(UserInfoDaoModel userInfo){
        this.userInfo = userInfo;
    }
}
