/**
 * @Title: UserInfoEditReqModel.java
 * @Package com.hundsun.fund.product.mvc.model.user
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月11日 下午8:59:39
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.user;

import com.hundsun.fund.product.mvc.model.base.BaseReqModel;

/**
 *@Description:编辑用户的信息
 *@Author:李焱生
 *@Since:2015年5月11日下午8:59:39  
 */
public class UserInfoEditReqModel extends BaseReqModel {

    private static final long serialVersionUID = 5449690110834708756L;

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

    public String getIcon(){
        return icon;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public String getUuid(){
        return uuid;
    }

    public void setUuid(String uuid){
        this.uuid = uuid;
    }

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

}
