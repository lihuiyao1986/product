/**
 * @Title: ProductCollectSaveReqAPIModel.java
 * @Package com.hundsun.fund.product.api.product.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月11日 下午10:45:44
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.product.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;

/**
 *@Description:保存收藏产品信息
 *@Author:李焱生
 *@Since:2015年5月11日下午10:45:44  
 */
public class ProductCollectEditReqAPIModel extends BaseAPIReqParam {

    private static final long serialVersionUID = -5952556137737853640L;
    
    // 产品id
    private String            productId;
    // 用户id
    private String            userId;

    public String getProductId(){
        return productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }
}
