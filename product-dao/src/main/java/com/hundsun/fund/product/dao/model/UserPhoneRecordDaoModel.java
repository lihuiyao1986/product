/**
 * @Title: UserPhoneRecordDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月10日 下午2:27:03
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *@Description:用户电话记录
 *@Author:李焱生
 *@Since:2015年5月10日下午2:27:03  
 */
public class UserPhoneRecordDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = 6784613260523832965L;

    // 拨打电话的投资者
    private String            userId;

    // 被叫的理财师
    private String            plannerId;

    // 拨打时间
    @JSONField(format="yyyyMMddHHmmss")
    private Date              createTime;

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getPlannerId(){
        return plannerId;
    }

    public void setPlannerId(String plannerId){
        this.plannerId = plannerId;
    }

    public Date getCreateTime(){
        return createTime;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

}
