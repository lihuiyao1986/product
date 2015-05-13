/**
 *@Title: MostIncomeProductQueryAPIReqModel.java 
 *@Package com.hundsun.fund.product.api.product.model 
 *@Description: TODO(用一句话描述该文件做什么) 
 *@author A18ccms A18ccms_gmail_com   
 *@date 2015年5月10日 下午6:24:33 
 *@Copyright:Copyright (c) 
 *@Company:whty李焱生
 *@version V1.0 
 */
package com.hundsun.fund.product.api.product.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;



/**
 *@Description:查询最高收益产品信息
 *@Author:李焱生
 *@Since:2015年5月10日下午6:24:33  
 */
public class ConfigedMostIncomeProductQueryAPIReqModel extends BaseAPIReqParam {

    private static final long serialVersionUID = -9033176765170069673L;
    
    /** 城市 **/
    private String city;

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

}
