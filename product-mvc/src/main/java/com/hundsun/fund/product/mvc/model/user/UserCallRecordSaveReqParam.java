/**
 * @Title: UserCallRecordSaveReqParam.java
 * @Package com.hundsun.fund.product.mvc.model.user
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月11日 下午9:28:39
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.user;

import com.hundsun.fund.product.mvc.model.base.BaseReqModel;

/**
 *@Description:保存用户的电话记录信息
 *@Author:李焱生
 *@Since:2015年5月11日下午9:28:39  
 */
public class UserCallRecordSaveReqParam extends BaseReqModel {

    private static final long serialVersionUID = 1532102334789567106L;

    /** 理财师id **/
    private String            plannerId;

    public String getPlannerId(){
        return plannerId;
    }

    public void setPlannerId(String plannerId){
        this.plannerId = plannerId;
    }
}
