/**
 * @Title: UserLoginRespModel.java
 * @Package com.hundsun.fund.product.mvc.model.user
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 上午9:19:40
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.user;

import com.hundsun.fund.product.dao.model.UserInfoDaoModel;
import com.hundsun.fund.product.mvc.model.base.BaseRespModel;

/**
 *@Description:用户登录响应类
 *@Author:李焱生
 *@Since:2015年5月6日上午9:19:40  
 */
public class UserLoginRespModel extends BaseRespModel {

    private static final long     serialVersionUID = 3447552823490620926L;

    /** 登录的用户信息 **/
    private UserInfoDaoModel loginUser;

    /** 登录用户的token信息 **/
    private String                token;

    public UserInfoDaoModel getLoginUser(){
        return loginUser;
    }

    public void setLoginUser(UserInfoDaoModel loginUser){
        this.loginUser = loginUser;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }

}
