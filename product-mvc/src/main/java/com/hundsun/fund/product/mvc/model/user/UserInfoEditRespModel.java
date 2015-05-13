/**
 * @Title: UserInfoEditRespModel.java
 * @Package com.hundsun.fund.product.mvc.model.user
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月11日 下午8:59:02
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.user;

import com.hundsun.fund.product.dao.model.UserInfoDaoModel;
import com.hundsun.fund.product.mvc.model.base.BaseRespModel;

/**
 *@Description:编辑用户的信息
 *@Author:李焱生
 *@Since:2015年5月11日下午8:59:02  
 */
public class UserInfoEditRespModel extends BaseRespModel {

    private static final long serialVersionUID = 8991223460676144453L;
    
    /** 用户信息 **/
    private UserInfoDaoModel  userInfo;

    public UserInfoDaoModel getUserInfo(){
        return userInfo;
    }

    public void setUserInfo(UserInfoDaoModel userInfo){
        this.userInfo = userInfo;
    }
}
