/**
 * @Title: ProductPraiseNumDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 上午11:23:20
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;


/**
 *@Description:产品点赞数
 *@Author:李焱生
 *@Since:2015年5月6日上午11:23:20  
 */
public class ProductPraiseNumDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = -1600497161958683906L;

    // 产品id
    private String            productId;

    // 投资人id
    private String            userId;

    // 备注
    private String            memo;

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

}
