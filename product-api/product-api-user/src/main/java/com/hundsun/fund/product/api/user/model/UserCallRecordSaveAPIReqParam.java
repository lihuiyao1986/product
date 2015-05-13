/**
 * @Title: UserCallRecordSaveAPIReqParam.java
 * @Package com.hundsun.fund.product.api.user.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月11日 下午7:48:15
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.user.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;

/**
 *@Description:保存用户的电话记录
 *@Author:李焱生
 *@Since:2015年5月11日下午7:48:15  
 */
public class UserCallRecordSaveAPIReqParam extends BaseAPIReqParam {

    private static final long serialVersionUID = 1274480062232904607L;

    /** 用户id **/
    private String            userId;

    /** 理财师id **/
    private String            plannerId;

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getPlannerId(){
        return plannerId;
    }

    public void setPlannerId(String plannerId){
        this.plannerId = plannerId;
    }

}
