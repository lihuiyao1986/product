/**
 * @Title: UserFeedbackQueryReqModel.java
 * @Package com.hundsun.fund.product.mvc.model.user
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月8日 下午11:38:08
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.user;

import com.hundsun.fund.product.mvc.model.base.BaseReqModel;

/**
 *@Description:查询用户反馈信息请求参数
 *@Author:李焱生
 *@Since:2015年5月8日下午11:38:08  
 */
public class UserFeedbackQueryReqModel extends BaseReqModel {

    private static final long serialVersionUID = -4650878233209897938L;

    // 用户id
    private String            userId;

    // 反馈信息id
    private String            feedbackId;

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getFeedbackId(){
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId){
        this.feedbackId = feedbackId;
    }
}
