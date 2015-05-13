/**
 * @Title: UserInfoQueryByUuidAPIRespModel.java
 * @Package com.hundsun.fund.product.api.user.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月10日 下午2:40:40
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.user.model;

import com.hundsun.fund.product.commons.model.BaseAPIRespParam;
import com.hundsun.fund.product.dao.model.UserInfoDaoModel;

/**
 *@Description:根据uuid查询用户的信息
 *@Author:李焱生
 *@Since:2015年5月10日下午2:40:40  
 */
public class UserInfoQueryByUuidAPIRespModel extends BaseAPIRespParam {

    private static final long serialVersionUID = 6533103519243040296L;

    /** 用户信息 **/
    private UserInfoDaoModel  userInfo;

    public UserInfoDaoModel getUserInfo(){
        return userInfo;
    }

    public void setUserInfo(UserInfoDaoModel userInfo){
        this.userInfo = userInfo;
    }

}
