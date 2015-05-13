/**
 * @Title: ProductOrgPlannerDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月10日 下午8:41:24
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

import java.io.Serializable;

/**
 *@Description:销售机构，理财师，产品
 *@Author:李焱生
 *@Since:2015年5月10日下午8:41:24  
 */
public class ProductOrgPlannerDaoModel implements Serializable {

    private static final long serialVersionUID = 6222737598065418329L;

    // 产品ID
    private String            productId;

    // 销售机构id
    private String            orgId;

    // 机构名称
    private String            orgName;

    // 纬度
    private String            orgLatitude;

    // 经度
    private String            orgLongtitude;

    // 城市
    private String            orgCity;

    // 销售机构所在的区域
    private String            orgDistrict;

    // 理财师id
    private String            plannerId;

    // 头像
    private String            plannerIcon;

    // 姓名
    private String            plannerName;

    // 手机号
    private String            plannerMobile;

    // 固定电话
    private String            plannerPhone;

    // 微信号
    private String            plannerWebchat;

    // qq
    private String            plannerQQ;

    // 账号
    private String            plannerAccount;

    // 密码
    private String            plannerPwd;

    public String getProductId(){
        return productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

    public String getOrgName(){
        return orgName;
    }

    public void setOrgName(String orgName){
        this.orgName = orgName;
    }

    public String getOrgLatitude(){
        return orgLatitude;
    }

    public void setOrgLatitude(String orgLatitude){
        this.orgLatitude = orgLatitude;
    }

    public String getOrgLongtitude(){
        return orgLongtitude;
    }

    public void setOrgLongtitude(String orgLongtitude){
        this.orgLongtitude = orgLongtitude;
    }

    public String getOrgCity(){
        return orgCity;
    }

    public void setOrgCity(String orgCity){
        this.orgCity = orgCity;
    }

    public String getOrgDistrict(){
        return orgDistrict;
    }

    public void setOrgDistrict(String orgDistrict){
        this.orgDistrict = orgDistrict;
    }

    public String getPlannerIcon(){
        return plannerIcon;
    }

    public void setPlannerIcon(String plannerIcon){
        this.plannerIcon = plannerIcon;
    }

    public String getPlannerName(){
        return plannerName;
    }

    public void setPlannerName(String plannerName){
        this.plannerName = plannerName;
    }

    public String getPlannerMobile(){
        return plannerMobile;
    }

    public void setPlannerMobile(String plannerMobile){
        this.plannerMobile = plannerMobile;
    }

    public String getPlannerPhone(){
        return plannerPhone;
    }

    public void setPlannerPhone(String plannerPhone){
        this.plannerPhone = plannerPhone;
    }

    public String getPlannerWebchat(){
        return plannerWebchat;
    }

    public void setPlannerWebchat(String plannerWebchat){
        this.plannerWebchat = plannerWebchat;
    }

    public String getPlannerQQ(){
        return plannerQQ;
    }

    public void setPlannerQQ(String plannerQQ){
        this.plannerQQ = plannerQQ;
    }

    public String getPlannerAccount(){
        return plannerAccount;
    }

    public void setPlannerAccount(String plannerAccount){
        this.plannerAccount = plannerAccount;
    }

    public String getPlannerPwd(){
        return plannerPwd;
    }

    public void setPlannerPwd(String plannerPwd){
        this.plannerPwd = plannerPwd;
    }

    public String getPlannerId(){
        return plannerId;
    }

    public void setPlannerId(String plannerId){
        this.plannerId = plannerId;
    }

    public String getOrgId(){
        return orgId;
    }

    public void setOrgId(String orgId){
        this.orgId = orgId;
    }

}
