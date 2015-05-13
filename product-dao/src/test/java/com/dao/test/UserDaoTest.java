/**
 * @Title: UserDaoTest.java
 * @Package com.dao.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月8日 下午9:48:16
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.dao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.hundsun.fund.product.dao.model.UserFeedBackInfoDaoModel;
import com.hundsun.fund.product.dao.service.UserDao;

/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年5月8日下午9:48:16  
 */
public class UserDaoTest extends BaseTest{

    @Autowired
    private UserDao userDao;

    @Test
    public void testQueryUserFeedbackInfoListByUserId(){
        PageInfo<UserFeedBackInfoDaoModel> infoList = userDao.queryUserFeedbackInfoListByUserId ("1", "8", 1, 2);
        List<UserFeedBackInfoDaoModel> listView = infoList.getList ();
        logger.debug (listView);
    }

}
