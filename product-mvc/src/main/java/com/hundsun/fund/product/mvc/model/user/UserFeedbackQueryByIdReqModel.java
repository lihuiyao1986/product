/**
 * @Title: UserFeedbackQueryByIdReqModel.java
 * @Package com.hundsun.fund.product.mvc.model.user
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月9日 上午11:05:01
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.user;

import com.hundsun.fund.product.mvc.model.base.BaseReqModel;

/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年5月9日上午11:05:01  
 */
public class UserFeedbackQueryByIdReqModel extends BaseReqModel {

    private static final long serialVersionUID = -2686837423328920013L;

    // 反馈信息id
    private String            feedbackId;

    // 是否查询反馈信息的回复信息的标识 1-是，其他-否
    private String            queryReplyFlag;

    public String getFeedbackId(){
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId){
        this.feedbackId = feedbackId;
    }

    public String getQueryReplyFlag(){
        return queryReplyFlag;
    }

    public void setQueryReplyFlag(String queryReplyFlag){
        this.queryReplyFlag = queryReplyFlag;
    }
}
