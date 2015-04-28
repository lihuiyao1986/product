/**
 * @Title: UserServiceImpl.java
 * @Package com.hundsun.fund.product.provider.user
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月27日 下午4:49:04
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.provider.user;

import org.springframework.stereotype.Service;

import com.hundsun.fund.product.api.user.IUserService;
import com.hundsun.fund.product.model.api.User;

/**
 *@Description:用户信息service
 *@Author:李焱生
 *@Since:2015年4月27日下午4:49:04  
 */
@Service(value="userService")
public class UserServiceImpl implements IUserService {

    /**
     *@Description: TODO(这里用一句话描述这个方法的作用) 
     *@Author: 李焱生
     *@Since: 2015年4月27日下午4:50:33
     *@return
     */
    @Override
    public User getUser(){
        User user = new User ();
        user.setName ("李焱生");
        user.setSex ('M');
        user.setAge (28);
        return user;
    }
    
}
