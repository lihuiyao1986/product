/**
 * @Title: DeviceInfoModel.java
 * @Package com.hundsun.fund.product.mvc.model.base
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月5日 下午6:03:26
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.commons.model;

import java.io.Serializable;

/**
 *@Description:终端设备信息
 *@Author:李焱生
 *@Since:2015年5月5日下午6:03:26  
 */
public class DeviceInfoModel implements Serializable {

    private static final long serialVersionUID = 6422333770175699916L;

    // 用户id
    private String            userId;

    // 系统版本
    private String            sysversion;

    // 设备信息
    private String            deviceinfo;

    // 屏幕高度
    private String            screenheight;

    // 屏幕宽度
    private String            screenwidth;

    // 手机密度
    private String            density;

    // 手机唯一标识
    private String            mobileuuid;

    // 网络类型
    private String            nettype;

    public String getSysversion(){
        return sysversion;
    }

    public void setSysversion(String sysversion){
        this.sysversion = sysversion;
    }

    public String getDeviceinfo(){
        return deviceinfo;
    }

    public void setDeviceinfo(String deviceinfo){
        this.deviceinfo = deviceinfo;
    }

    public String getScreenheight(){
        return screenheight;
    }

    public void setScreenheight(String screenheight){
        this.screenheight = screenheight;
    }

    public String getScreenwidth(){
        return screenwidth;
    }

    public void setScreenwidth(String screenwidth){
        this.screenwidth = screenwidth;
    }

    public String getDensity(){
        return density;
    }

    public void setDensity(String density){
        this.density = density;
    }

    public String getMobileuuid(){
        return mobileuuid;
    }

    public void setMobileuuid(String mobileuuid){
        this.mobileuuid = mobileuuid;
    }

    public String getNettype(){
        return nettype;
    }

    public void setNettype(String nettype){
        this.nettype = nettype;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

}
