/**
 * @Title: UserHobbyQueryRespModel.java
 * @Package com.hundsun.fund.product.mvc.model.user
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月7日 下午4:16:11
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.user;

import com.hundsun.fund.product.dao.model.UserHobbyDaoModel;
import com.hundsun.fund.product.mvc.model.base.BaseRespModel;

/**
 *@Description:用户爱好查询响应结果
 *@Author:李焱生
 *@Since:2015年5月7日下午4:16:11  
 */
public class UserHobbyQueryRespModel extends BaseRespModel {

    private static final long serialVersionUID = 336138713327715145L;
    
    /** 用户的爱好信息 **/
    private UserHobbyDaoModel userHobby;

    public UserHobbyDaoModel getUserHobby(){
        return userHobby;
    }

    public void setUserHobby(UserHobbyDaoModel userHobby){
        this.userHobby = userHobby;
    }

}
