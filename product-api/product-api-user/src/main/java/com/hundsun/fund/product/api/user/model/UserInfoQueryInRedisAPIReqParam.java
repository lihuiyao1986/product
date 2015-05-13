/**
 * @Title: UserInfoQueryInRedisReqParam.java
 * @Package com.hundsun.fund.product.api.user.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月7日 下午4:28:36
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.user.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;

/**
 *@Description:从redis中查询用户信息入参
 *@Author:李焱生
 *@Since:2015年5月7日下午4:28:36  
 */
public class UserInfoQueryInRedisAPIReqParam extends BaseAPIReqParam {

    private static final long serialVersionUID = 1043951228426778746L;

    /** 用户令牌 **/
    private String            token;

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }
}
