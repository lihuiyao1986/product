/**
 * @Title: UserFeedbackQueryReqAPIParam.java
 * @Package com.hundsun.fund.product.api.user.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月8日 下午7:27:28
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.user.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;

/**
 *@Description:用户反馈信息查询
 *@Author:李焱生
 *@Since:2015年5月8日下午7:27:28  
 */
public class UserFeedbackQueryReqAPIParam extends BaseAPIReqParam {

    private static final long serialVersionUID = -7877441669103315187L;

    // 用户id
    private String            userId;

    // 反馈信息id 
    private String            feedbackId;

    // 是否分页 0--不分页 1--分页
    private String            isPage;

    // 页码
    private int               pageNo;

    // 每页记录数
    private int               pageSize;

    public String getIsPage(){
        return isPage;
    }

    public void setIsPage(String isPage){
        this.isPage = isPage;
    }

    public int getPageNo(){
        return pageNo;
    }

    public void setPageNo(int pageNo){
        this.pageNo = pageNo;
    }

    public int getPageSize(){
        return pageSize;
    }

    public void setPageSize(int pageSize){
        this.pageSize = pageSize;
    }

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
