/**
 * @Title: ProductCollectSaveReqModel.java
 * @Package com.hundsun.fund.product.mvc.model.product
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月11日 下午11:27:29
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.product;

import com.hundsun.fund.product.mvc.model.base.BaseReqModel;

/**
 *@Description:编辑产品收藏信息
 *@Author:李焱生
 *@Since:2015年5月11日下午11:27:29  
 */
public class ProductCollectEditReqModel extends BaseReqModel {

    private static final long serialVersionUID = -4790705849880741211L;

    // 产品id
    private String            productId;

    public String getProductId(){
        return productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

}
