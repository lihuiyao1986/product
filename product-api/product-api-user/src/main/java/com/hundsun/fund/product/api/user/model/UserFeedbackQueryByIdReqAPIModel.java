/**
 * @Title: UserFeedbackQueryByIdReqAPIModel.java
 * @Package com.hundsun.fund.product.api.user.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月9日 上午11:35:20
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.user.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;

/**
 *@Description:根据反馈信息id查询用户的反馈信息
 *@Author:李焱生
 *@Since:2015年5月9日上午11:35:20  
 */
public class UserFeedbackQueryByIdReqAPIModel extends BaseAPIReqParam {

    private static final long  serialVersionUID     = 3107172833623657820L;

    /** 查询回复信息 **/
    public static final String QUERY_REPLY_FLAG     = "1";

    /** 不查询回复信息 **/
    public static final String NOT_QUERY_REPLY_FLAG = "0";

    // 反馈信息id
    private String             feedbackId;

    // 是否查询反馈信息的回复信息的标识 1-是，其他-否
    private String             queryReplyFlag;

    // 用户id
    private String             userId;

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

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

}
