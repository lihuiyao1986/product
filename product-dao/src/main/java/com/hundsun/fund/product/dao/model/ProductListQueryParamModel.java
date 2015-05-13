/**
 * @Title: ProductListQueryParamModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月11日 上午11:24:56
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

import java.io.Serializable;

/**
 *@Description: 查询产品列表的参数
 *@Author:李焱生
 *@Since:2015年5月11日上午11:24:56  
 */
public class ProductListQueryParamModel implements Serializable {

    private static final long serialVersionUID = 5428877940292218267L;

    private String            city;

    /** 最低产品周期 **/
    private String            minLimit;

    /** 最高产品周期 **/
    private String            maxLimit;

    /** 产品类型 **/
    private String            productType;

    /** 纬度 **/
    private String            latitude;

    /** 经度 **/
    private String            longtitude;

    /** 最大距离 **/
    private String            distance;

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getMinLimit(){
        return minLimit;
    }

    public void setMinLimit(String minLimit){
        this.minLimit = minLimit;
    }

    public String getMaxLimit(){
        return maxLimit;
    }

    public void setMaxLimit(String maxLimit){
        this.maxLimit = maxLimit;
    }

    public String getProductType(){
        return productType;
    }

    public void setProductType(String productType){
        this.productType = productType;
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

    public String getDistance(){
        return distance;
    }

    public void setDistance(String distance){
        this.distance = distance;
    }

}
