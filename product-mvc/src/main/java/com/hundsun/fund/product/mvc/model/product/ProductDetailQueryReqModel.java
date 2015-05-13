/**
 * @Title: ProductDetailQueryReqModel.java
 * @Package com.hundsun.fund.product.mvc.model.product
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月12日 上午8:58:14
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.product;

import com.hundsun.fund.product.mvc.model.base.BaseReqModel;

/**
 *@Description:产品详情查询
 *@Author:李焱生
 *@Since:2015年5月12日上午8:58:14  
 */
public class ProductDetailQueryReqModel extends BaseReqModel {

    private static final long serialVersionUID = 1387284383438006968L;

    // 产品id
    private String            productId;

    public String getProductId(){
        return productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

}
