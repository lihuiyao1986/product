/**
 * @Title: UserFeedbackQueryRespModel.java
 * @Package com.hundsun.fund.product.mvc.model.user
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月8日 下午11:20:55
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.user;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hundsun.fund.product.dao.model.UserFeedBackInfoDaoModel;
import com.hundsun.fund.product.mvc.model.base.BaseRespModel;

/**
 *@Description:查询用户反馈信息
 *@Author:李焱生
 *@Since:2015年5月8日下午11:20:55  
 */
public class UserFeedbackQueryRespModel extends BaseRespModel {
    private static final long                  serialVersionUID = -5981629065225586039L;
    
    /** 集合对象 －－不分页时返回 **/
    private List<UserFeedBackInfoDaoModel>     feedbackList;

    /** 集合对象 --分页时返回 **/
    private PageInfo<UserFeedBackInfoDaoModel> pageList;

    /** 是否分页标识 **/
    private String                             isPage;

    public List<UserFeedBackInfoDaoModel> getFeedbackList(){
        return feedbackList;
    }

    public void setFeedbackList(List<UserFeedBackInfoDaoModel> feedbackList){
        this.feedbackList = feedbackList;
    }

    public PageInfo<UserFeedBackInfoDaoModel> getPageList(){
        return pageList;
    }

    public void setPageList(PageInfo<UserFeedBackInfoDaoModel> pageList){
        this.pageList = pageList;
    }

    public String getIsPage(){
        return isPage;
    }

    public void setIsPage(String isPage){
        this.isPage = isPage;
    }
}
