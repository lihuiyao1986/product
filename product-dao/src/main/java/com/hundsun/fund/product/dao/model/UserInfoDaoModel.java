/**
 * @Title: UserDaoModel.java
 * @Package com.hundsun.fund.product.model.dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月29日 下午1:36:29
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

/**
 *@Description:投资人信息
 *@Author:李焱生
 *@Since:2015年4月29日下午1:36:29  
 */
public class UserInfoDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = -4056368299181430770L;

    // 头像
    private String            icon;

    // 标示用户的唯一标识
    private String            uuid;

    // 姓名
    private String            name;

    // 邮箱
    private String            email;

    // qq
    private String            qq;

    // 微信号
    private String            webchat;

    // 手机号
    private String            mobile;

    // 地址
    private String            address;

    // 账号
    private String            account;

    // 密码
    private String            pwd;

    // 备注
    private String            memo;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getQq(){
        return qq;
    }

    public void setQq(String qq){
        this.qq = qq;
    }

    public String getWebchat(){
        return webchat;
    }

    public void setWebchat(String webchat){
        this.webchat = webchat;
    }

    public String getMobile(){
        return mobile;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
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

    public String getIcon(){
        return icon;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    @Override
    public String toString(){
        return "id=" + this.id + "-icon=" + this.icon + "-name=" + this.name + "-email=" + this.email + "-qq=" + this.qq + "-webchat=" + this.webchat
                + "-mobile=" + this.mobile + "-address=" + this.address + "-account=" + this.account + "-pwd=" + this.pwd + "-memo=" + this.memo;
    }

    public String getUuid(){
        return uuid;
    }

    public void setUuid(String uuid){
        this.uuid = uuid;
    }

}
