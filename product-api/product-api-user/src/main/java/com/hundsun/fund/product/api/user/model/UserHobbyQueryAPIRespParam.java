/**
 * @Title: UserHobbyQueryRespParam.java
 * @Package com.hundsun.fund.product.api.user.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月7日 下午4:48:25
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.user.model;

import com.hundsun.fund.product.commons.model.BaseAPIRespParam;
import com.hundsun.fund.product.dao.model.UserHobbyDaoModel;

/**
 *@Description:用户爱好查询响应结果
 *@Author:李焱生
 *@Since:2015年5月7日下午4:48:25  
 */
public class UserHobbyQueryAPIRespParam extends BaseAPIRespParam {

    private static final long serialVersionUID = -2673429040819440438L;
    
    /** 用户的爱好信息 **/
    private UserHobbyDaoModel hobby;

    public UserHobbyDaoModel getHobby(){
        return hobby;
    }

    public void setHobby(UserHobbyDaoModel hobby){
        this.hobby = hobby;
    }

}
