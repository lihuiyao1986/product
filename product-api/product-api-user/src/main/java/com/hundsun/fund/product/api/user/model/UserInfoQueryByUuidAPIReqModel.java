/**
 * @Title: UserInfoQueryByUuidAPIReqModel.java
 * @Package com.hundsun.fund.product.api.user.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月10日 下午2:40:30
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.user.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;

/**
 *@Description:根据uuid查询用户信息
 *@Author:李焱生
 *@Since:2015年5月10日下午2:40:30  
 */
public class UserInfoQueryByUuidAPIReqModel extends BaseAPIReqParam {

    private static final long serialVersionUID = -7693107600244103527L;

    /** 用户的uuid **/
    private String            uuid;

    public String getUuid(){
        return uuid;
    }

    public void setUuid(String uuid){
        this.uuid = uuid;
    }

}
