/**
 * @Title: ConfigedMostIncomProductRespModel.java
 * @Package com.hundsun.fund.product.mvc.model.product
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月13日 上午9:28:34
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.product;

import java.util.List;

import com.hundsun.fund.product.dao.model.ConfigedMostIncomeProductDaoModel;
import com.hundsun.fund.product.mvc.model.base.BaseRespModel;

/**
 *@Description:配置的最高信息收益产品信息查询
 *@Author:李焱生
 *@Since:2015年5月13日上午9:28:34  
 */
public class ConfigedMostIncomProductRespModel extends BaseRespModel {

    private static final long                       serialVersionUID = 2486331480699947866L;

    /** 列表 **/
    private List<ConfigedMostIncomeProductDaoModel> list;

    /** 城市 **/
    private String                                  city;

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
