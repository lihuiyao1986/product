/**
 * @Title: ProductCollectSaveDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月11日 下午10:47:45
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *@Description:保存收藏产品信息
 *@Author:李焱生
 *@Since:2015年5月11日下午10:47:45  
 */
public class ProductCollectSaveDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = -1562461295001796009L;

    // 产品id
    private String            productId;
    // 用户id
    private String            userId;
    // 备注
    private String            memo;
    // 收藏时间
    @JSONField(format="yyyyMMddHHmmss")
    private Date              collectionTime;

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

    public String getMemo(){
        return memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

    public Date getCollectionTime(){
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime){
        this.collectionTime = collectionTime;
    }

}
