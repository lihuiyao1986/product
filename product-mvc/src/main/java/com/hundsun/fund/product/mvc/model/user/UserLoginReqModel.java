/**
 * @Title: UserLoginReqModel.java
 * @Package com.hundsun.fund.product.mvc.model.user
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 上午9:07:02
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.user;

import com.hundsun.fund.product.mvc.model.base.BaseReqModel;

/**
 *@Description:用户登录对应的入参数类
 *@Author:李焱生
 *@Since:2015年5月6日上午9:07:02  
 */
public class UserLoginReqModel extends BaseReqModel {

    private static final long serialVersionUID = -8610627801269868791L;

    // 账号
    private String            account;

    // 密码
    private String            pwd;

    public String getAccount(){
        return account;
    }

    public void setAccount(String account){
        this.account = account;
    }

    public String getPwd(){
        return pwd;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }

}
