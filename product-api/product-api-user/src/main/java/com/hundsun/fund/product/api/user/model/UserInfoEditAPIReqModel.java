/**
 * @Title: UserInfoEditAPIRe1Model.java
 * @Package com.hundsun.fund.product.api.user.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月10日 下午3:06:15
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.user.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;
import com.hundsun.fund.product.dao.model.UserInfoDaoModel;

/**
 *@Description:编辑用户信息
 *@Author:李焱生
 *@Since:2015年5月10日下午3:06:15  
 */
public class UserInfoEditAPIReqModel extends BaseAPIReqParam {

    private static final long serialVersionUID = -5585672764022435257L;

    /** 用户信息 **/
    private UserInfoDaoModel  userInfo;

    public UserInfoDaoModel getUserInfo(){
        return userInfo;
    }

    public void setUserInfo(UserInfoDaoModel userInfo){
        this.userInfo = userInfo;
    }
}
