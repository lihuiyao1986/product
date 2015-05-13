/**
 * @Title: UserDao.java
 * @Package com.hundsun.fund.product.dao.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月8日 下午10:18:24
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hundsun.fund.product.dao.mapper.UserMapper;
import com.hundsun.fund.product.dao.model.UserFeedBackInfoDaoModel;

/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年5月8日下午10:18:24  
 */
@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    /**
     * 
     *@Description: 分页查询用户的反馈信息  
     *@Author: 李焱生
     *@Since: 2015年5月8日下午9:45:17
     *@param userId
     *@param pageNo
     *@param pageSize
     *@return
     */
    public PageInfo<UserFeedBackInfoDaoModel> queryUserFeedbackInfoListByUserId(String userId,String feedbackId,int pageNo,int pageSize){
        PageHelper.startPage (pageNo, pageSize);
        List<UserFeedBackInfoDaoModel> list = userMapper.queryUserFeedbackInfoListByUserId (userId,feedbackId);
        return new PageInfo<UserFeedBackInfoDaoModel> (list);
    }
}
