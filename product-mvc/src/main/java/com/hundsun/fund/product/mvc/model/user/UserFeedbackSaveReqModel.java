/**
 * @Title: UserFeedbackReqModel.java
 * @Package com.hundsun.fund.product.mvc.model.user
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月8日 下午12:52:02
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.user;

import com.hundsun.fund.product.mvc.model.base.BaseReqModel;

/**
 *@Description:保存反馈信息请求参数
 *@Author:李焱生
 *@Since:2015年5月8日下午12:52:02  
 */
public class UserFeedbackSaveReqModel extends BaseReqModel {

    private static final long serialVersionUID = -1813393147345170276L;

    // 反馈内容
    private String            feedbackInfo;

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

}
