/**
 * @Title: RecommentQueryReqAPIModel.java
 * @Package com.hundsun.fund.product.api.product.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月9日 下午3:34:54
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.product.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;

/**
 *@Description:推荐产品信息查询请求信息
 *@Author:李焱生
 *@Since:2015年5月9日下午3:34:54  
 */
public class RecommendQueryReqAPIModel extends BaseAPIReqParam {

    private static final long serialVersionUID = -7836997188488092867L;

    // 纬度
    private String            latitude;

    // 经度
    private String            longtitude;

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
}
