/**
 * @Title: UserHobbyQueryReqParam.java
 * @Package com.hundsun.fund.product.api.user.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月7日 下午4:46:51
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.user.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;

/**
 *@Description:查询用户的爱好请求入参
 *@Author:李焱生
 *@Since:2015年5月7日下午4:46:51  
 */
public class UserHobbyQueryAPIReqParam extends BaseAPIReqParam {

    private static final long serialVersionUID = -8094618350237303356L;
    
    /** 用户id **/
    private String            userId;

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

}
