/**
 * @Title: UserFeedbackQueryByIdRespModel.java
 * @Package com.hundsun.fund.product.mvc.model.user
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月9日 上午11:01:43
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.user;

import com.hundsun.fund.product.dao.model.UserFeedBackInfoDaoModel;
import com.hundsun.fund.product.dao.model.UserFeenbackReplyDaoModel;
import com.hundsun.fund.product.mvc.model.base.BaseRespModel;

import java.util.List;

/**
 *@Description:根据反馈信息id查询用户的反馈信息
 *@Author:李焱生
 *@Since:2015年5月9日上午11:01:43  
 */
public class UserFeedbackQueryByIdRespModel extends BaseRespModel {

    private static final long               serialVersionUID = 649552874720741369L;

    // 反馈信息
    private UserFeedBackInfoDaoModel        feedbackInfo;

    // 回复信息
    private List<UserFeenbackReplyDaoModel> replyInfoList;

    // 是否查询回复信息
    private String                          queryReplyFlag;

    // 反馈信息id
    private String                          feedbackId;

    public UserFeedBackInfoDaoModel getFeedbackInfo(){
        return feedbackInfo;
    }

    public void setFeedbackInfo(UserFeedBackInfoDaoModel feedbackInfo){
        this.feedbackInfo = feedbackInfo;
    }

    public List<UserFeenbackReplyDaoModel> getReplyInfoList(){
        return replyInfoList;
    }

    public void setReplyInfoList(List<UserFeenbackReplyDaoModel> replyInfoList){
        this.replyInfoList = replyInfoList;
    }

    public String getQueryReplyFlag(){
        return queryReplyFlag;
    }

    public void setQueryReplyFlag(String queryReplyFlag){
        this.queryReplyFlag = queryReplyFlag;
    }

    public String getFeedbackId(){
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId){
        this.feedbackId = feedbackId;
    }

}
