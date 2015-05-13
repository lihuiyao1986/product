/**
 * @Title: UserFeenbackReplyDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 下午12:41:39
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *@Description:反馈信息的回复
 *@Author:李焱生
 *@Since:2015年5月6日下午12:41:39  
 */
public class UserFeenbackReplyDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = -1022358157734475911L;
    // 内容
    private String            content;
    // 反馈的id
    private String            feedbackId;
    // 回复时间
    @JSONField(format="yyyyMMddHHmmss")
    private Date              replyTime;
    // 回复人
    private String            replyAuthor;
    // 备注
    private String            memo;

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getFeedbackId(){
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId){
        this.feedbackId = feedbackId;
    }

    public Date getReplyTime(){
        return replyTime;
    }

    public void setReplyTime(Date replyTime){
        this.replyTime = replyTime;
    }

    public String getReplyAuthor(){
        return replyAuthor;
    }

    public void setReplyAuthor(String replyAuthor){
        this.replyAuthor = replyAuthor;
    }

    public String getMemo(){
        return memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

}
