/**
 * @Title: UserFeedBackInfoDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 下午12:32:36
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *@Description:反馈信息表
 *@Author:李焱生
 *@Since:2015年5月6日下午12:32:36  
 */

public class UserFeedBackInfoDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = -3117327138451428331L;

    // 反馈内容
    private String            feedbackInfo;

    // 用户id
    private String            userId;

    // 创建时间
    @JSONField(format="yyyyMMddHHmmss")
    private Date              feedbackTime;

    // 邮箱
    private String            email;

    // 手机号
    private String            mobile;

    // 备注
    private String            memo;

    public String getFeedbackInfo(){
        return feedbackInfo;
    }

    public void setFeedbackInfo(String feedbackInfo){
        this.feedbackInfo = feedbackInfo;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
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
