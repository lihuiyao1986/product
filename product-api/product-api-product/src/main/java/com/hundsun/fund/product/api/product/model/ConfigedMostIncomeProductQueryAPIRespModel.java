/**
 * @Title: MostIncomeProductQueryAPIRespModel.java
 * @Package com.hundsun.fund.product.api.product.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月10日 下午6:25:19
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.product.model;

import java.util.List;

import com.hundsun.fund.product.commons.model.BaseAPIRespParam;
import com.hundsun.fund.product.dao.model.ConfigedMostIncomeProductDaoModel;

/**
 *@Description:查询最高收益产品信息
 *@Author:李焱生
 *@Since:2015年5月10日下午6:25:19  
 */
public class ConfigedMostIncomeProductQueryAPIRespModel extends BaseAPIRespParam {

    private static final long               serialVersionUID = 8199035253963890262L;

    private List<ConfigedMostIncomeProductDaoModel> list;

    private String                          city;

    public List<ConfigedMostIncomeProductDaoModel> getList(){
        return list;
    }

    public void setList(List<ConfigedMostIncomeProductDaoModel> list){
        this.list = list;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

}
