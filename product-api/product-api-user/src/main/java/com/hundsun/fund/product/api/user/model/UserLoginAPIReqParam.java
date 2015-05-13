/**
 * @Title: UserLoginAPIReqBean.java
 * @Package com.hundsun.fund.product.api.user.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 上午9:27:29
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.user.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;

/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年5月6日上午9:27:29  
 */
public class UserLoginAPIReqParam extends BaseAPIReqParam {

    private static final long serialVersionUID = 6180517860027457442L;

    // 账号
    private String            account;

    // 密码
    private String            pwd;

    // 用户代理
    private String            useragent;

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

    public String getUseragent(){
        return useragent;
    }

    public void setUseragent(String useragent){
        this.useragent = useragent;
    }
}
