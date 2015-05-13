/**
 * @Title: RecommentProductInfoQueryReqModel.java
 * @Package com.hundsun.fund.product.mvc.model.product
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月9日 下午3:27:47
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.product;

import com.hundsun.fund.product.mvc.model.base.BaseReqModel;

/**
 *@Description:推荐产品信息查询请求参数
 *@Author:李焱生
 *@Since:2015年5月9日下午3:27:47  
 */
public class RecommentProductInfoQueryReqModel extends BaseReqModel {

    private static final long serialVersionUID = -2599772581949675268L;
    
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
