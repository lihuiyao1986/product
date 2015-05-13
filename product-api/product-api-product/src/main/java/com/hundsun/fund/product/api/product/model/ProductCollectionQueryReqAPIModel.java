/**
 * @Title: ProductCollectionQueryReqAPIModel.java
 * @Package com.hundsun.fund.product.api.product.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月10日 上午9:09:26
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.product.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;

/**
 *@Description:收藏列表查询
 *@Author:李焱生
 *@Since:2015年5月10日上午9:09:26  
 */
public class ProductCollectionQueryReqAPIModel extends BaseAPIReqParam {

    private static final long serialVersionUID = -4436972443231605033L;

    /** 用户id **/
    private String            userId;

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

}
