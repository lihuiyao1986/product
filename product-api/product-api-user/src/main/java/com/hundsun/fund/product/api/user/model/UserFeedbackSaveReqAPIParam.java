/**
 * @Title: UserFeedbackSaveReqAPIParam.java
 * @Package com.hundsun.fund.product.api.user.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月8日 下午12:59:59
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.user.model;

import java.util.Date;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;

/**
 *@Description:保存用户的反馈信息
 *@Author:李焱生
 *@Since:2015年5月8日下午12:59:59  
 */
public class UserFeedbackSaveReqAPIParam extends BaseAPIReqParam {

    private static final long serialVersionUID = 5995580619532922544L;

    // 用户id
    private String            userId;

    // 反馈内容
    private String            feedbackInfo;

    // 反馈时间
    private Date              feedbackTime;

    // 邮箱
    private String            email;

    // 手机号
    private String            mobile;

    // 备注
    private String            memo;

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getFeedbackInfo(){
        return feedbackInfo;
    }

    public void setFeedbackInfo(String feedbackInfo){
        this.feedbackInfo = feedbackInfo;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getMobile(){
        return mobile;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getMemo(){
        return memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

    public Date getFeedbackTime(){
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime){
        this.feedbackTime = feedbackTime;
    }

}
