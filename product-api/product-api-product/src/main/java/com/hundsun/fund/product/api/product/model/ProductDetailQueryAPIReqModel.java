/**
 * @Title: ProductDetailQueryAPIReqModel.java
 * @Package com.hundsun.fund.product.api.product.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月10日 下午8:37:32
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.product.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;

/**
 *@Description:产品详情查询
 *@Author:李焱生
 *@Since:2015年5月10日下午8:37:32  
 */
public class ProductDetailQueryAPIReqModel extends BaseAPIReqParam {

    private static final long serialVersionUID = 8484597455558450688L;

    /** 产品id **/
    private String            productId;

    /** 用户id **/
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
