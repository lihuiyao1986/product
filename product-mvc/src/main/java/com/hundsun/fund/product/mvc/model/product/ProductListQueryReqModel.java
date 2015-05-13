/**
 * @Title: ProductListQueryReqModel.java
 * @Package com.hundsun.fund.product.mvc.model.product
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月11日 下午9:52:38
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.product;

import com.hundsun.fund.product.mvc.model.base.BaseReqModel;

/**
 *@Description:产品信息列表查询
 *@Author:李焱生
 *@Since:2015年5月11日下午9:52:38  
 */
public class ProductListQueryReqModel extends BaseReqModel {

    private static final long serialVersionUID = -2003191830594770235L;
    
    /** 查询类型 0--最高收益 1--附近产品 2-－即将结束 **/
    private String            type;

    /** 最低产品周期 **/
    private String            minLimit;

    /** 最高产品周期 **/
    private String            maxLimit;

    /** 产品类型 **/
    private String            productType;

    /** 城市 **/
    private String            city;

    /** 纬度 **/
    private String            latitude;

    /** 经度 **/
    private String            longtitude;

    /** 最大距离 默认是5公里**/
    private String            distance         = "5000";

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
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

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
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
