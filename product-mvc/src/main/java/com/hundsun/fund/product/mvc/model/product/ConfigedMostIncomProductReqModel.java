/**
 * @Title: ConfigedMostIncomProductReqModel.java
 * @Package com.hundsun.fund.product.mvc.model.product
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月13日 上午9:27:53
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.product;

import com.hundsun.fund.product.mvc.model.base.BaseReqModel;

/**
 *@Description:配置的最高信息收益产品信息查询
 *@Author:李焱生
 *@Since:2015年5月13日上午9:27:53  
 */
public class ConfigedMostIncomProductReqModel extends BaseReqModel {

    private static final long serialVersionUID = 2822466792680977751L;

    // 城市
    private String            city;

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

}
