/**
 * @Title: UserLoginInfoDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 上午10:42:54
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *@Description:用户登录信息dao实体类
 *@Author:李焱生
 *@Since:2015年5月6日上午10:42:54  
 */
public class UserLoginInfoDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = -5744244524674509527L;

    // 上一次登录的时间
    private Date              lastLoginTime;

    // 用户id
    private String            userId;

    // 登录时间
    @JSONField(format = "yyyyMMddHHmmss")
    private Date              loginTime;

    // 登录次数
    private long              loginNums;

    // 备注
    private String            memo;

    public Date getLastLoginTime(){
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime){
        this.lastLoginTime = lastLoginTime;
    }

    public String getMemo(){
        return memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

    public Date getLoginTime(){
        return loginTime;
    }

    public void setLoginTime(Date loginTime){
        this.loginTime = loginTime;
    }

    public long getLoginNums(){
        return loginNums;
    }

    public void setLoginNums(long loginNums){
        this.loginNums = loginNums;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

}
