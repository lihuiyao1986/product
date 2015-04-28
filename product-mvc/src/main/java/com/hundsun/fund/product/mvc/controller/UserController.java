/**
 * @Title: UserController.java
 * @Package com.hundsun.fund.product.mvc.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月27日 下午3:24:28
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hundsun.fund.product.api.user.IUserService;
import com.hundsun.fund.product.model.api.User;

/**
 *@Description:用户对应的控制器类
 *@Author:李焱生
 *@Since:2015年4月27日下午3:24:28  
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping("/getUser")
    public User getUser(){
        // throw new RuntimeException ("wwwww");
        return userService.getUser ();
    }

    public void setUserService(IUserService userService){
        this.userService = userService;
    }

}
