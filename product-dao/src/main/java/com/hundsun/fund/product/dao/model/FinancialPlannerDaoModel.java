/**
 * @Title: FinancialPlannerDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 上午11:11:33
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;


/**
 *@Description:
 *@Author:李焱生
 *@Since:2015年5月6日上午11:11:33  
 */
public class FinancialPlannerDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = 1938655266151600999L;

    // 头像
    private String            icon;

    // 姓名
    private String            name;

    // 手机号
    private String            mobile;

    // 固定电话
    private String            phone;

    // 微信号
    private String            webchat;

    // qq
    private String            qq;

    // 账号
    private String            account;

    // 密码
    private String            pwd;

    // 备注
    private String            memo;

    public String getIcon(){
        return icon;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getMobile(){
        return mobile;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getWebchat(){
        return webchat;
    }

    public void setWebchat(String webchat){
        this.webchat = webchat;
    }

    public String getQq(){
        return qq;
    }

    public void setQq(String qq){
        this.qq = qq;
    }

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

    public String getMemo(){
        return memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

}
