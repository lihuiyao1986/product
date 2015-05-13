/**
 * @Title: SaleOrgDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 上午11:08:43
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

/**
 *@Description:销售机构
 *@Author:李焱生
 *@Since:2015年5月6日上午11:08:43  
 */
public class ProductSaleOrgDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = 2577354598141977514L;

    // 机构名称
    private String            name;

    // 纬度
    private String            latitude;

    // 经度
    private String            longtitude;

    // 备注
    private String            memo;

    // 城市
    private String            city;

    // 销售机构所在的区域
    private String            district;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLatitude(){
        return latitude;
    }

    public void setLatitude(String latitude){
        this.latitude = latitude;
    }

    public String getLongtitude(){
        return longtitude;
    }

    public void setLongtitude(String longtitude){
        this.longtitude = longtitude;
    }

    public String getMemo(){
        return memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getDistrict(){
        return district;
    }

    public void setDistrict(String district){
        this.district = district;
    }

}
