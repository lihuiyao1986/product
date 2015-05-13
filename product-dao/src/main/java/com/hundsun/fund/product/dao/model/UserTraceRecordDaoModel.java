/**
 * @Title: UserTraceRecordDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 上午11:36:26
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *@Description:用户浏览记录
 *@Author:李焱生
 *@Since:2015年5月6日上午11:36:26  
 */
public class UserTraceRecordDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = -1484454040487965959L;

    // 用户id
    private String            userId;

    // 产品id
    private String            productId;

    // 浏览时间
    @JSONField(format="yyyyMMddHHmmss")
    private Date            tracetime;

    // 备注
    private String            memo;

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getProductId(){
        return productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

    public Date getTracetime(){
        return tracetime;
    }

    public void setTracetime(Date tracetime){
        this.tracetime = tracetime;
    }

    public String getMemo(){
        return memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

}
