/**
 * @Title: UserDeviceInfoDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 下午12:46:33
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

/**
 *@Description:用户的设备信息
 *@Author:李焱生
 *@Since:2015年5月6日下午12:46:33  
 */
public class UserDeviceInfoDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = -6324200119736621773L;

    // 用户id
    private String            userId;
    // 手机系统名称
    private String            sysname;
    // 系统版本
    private String            sysversion;
    // 当前应用的版本号
    private String            appversion;
    // 当前应用的版本名称
    private String            appversionname;
    // 设备信息
    private String            deviceInfo;
    // 屏幕高度
    private String            screenHeight;
    // 屏幕宽度
    private String            screenWidth;
    // 屏幕的密度
    private String            density;
    // 设备的唯一标示
    private String            uuid;
    // 网络类型
    private String            nettype;
    // 备注
    private String            memo;

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getSysversion(){
        return sysversion;
    }

    public void setSysversion(String sysversion){
        this.sysversion = sysversion;
    }

    public String getDeviceInfo(){
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo){
        this.deviceInfo = deviceInfo;
    }

    public String getScreenHeight(){
        return screenHeight;
    }

    public void setScreenHeight(String screenHeight){
        this.screenHeight = screenHeight;
    }

    public String getScreenWidth(){
        return screenWidth;
    }

    public void setScreenWidth(String screenWidth){
        this.screenWidth = screenWidth;
    }

    public String getDensity(){
        return density;
    }

    public void setDensity(String density){
        this.density = density;
    }

    public String getUuid(){
        return uuid;
    }

    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    public String getNettype(){
        return nettype;
    }

    public void setNettype(String nettype){
        this.nettype = nettype;
    }

    public String getMemo(){
        return memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

    public String getSysname(){
        return sysname;
    }

    public void setSysname(String sysname){
        this.sysname = sysname;
    }

    public String getAppversion(){
        return appversion;
    }

    public void setAppversion(String appversion){
        this.appversion = appversion;
    }

    public String getAppversionname(){
        return appversionname;
    }

    public void setAppversionname(String appversionname){
        this.appversionname = appversionname;
    }

}
