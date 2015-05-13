/**
 * @Title: MostIncomeProductDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月10日 下午4:23:37
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

/**
 *@Description:最高收益产品描述
 *@Author:李焱生
 *@Since:2015年5月10日下午4:23:37  
 */
public class ConfigedMostIncomeProductDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = 8450305865477051376L;

    // 年化收益描述
    private String            yearIncomeRateDesc;

    // 产品周期描述
    private String            limitDesc;

    // 产品最低起购金额描述
    private String            minSaleSumDesc;

    // 城市
    private String            city;

    // 描述
    private String            memo;

    public String getYearIncomeRateDesc(){
        return yearIncomeRateDesc;
    }

    public void setYearIncomeRateDesc(String yearIncomeRateDesc){
        this.yearIncomeRateDesc = yearIncomeRateDesc;
    }

    public String getLimitDesc(){
        return limitDesc;
    }

    public void setLimitDesc(String limitDesc){
        this.limitDesc = limitDesc;
    }

    public String getMinSaleSumDesc(){
        return minSaleSumDesc;
    }

    public void setMinSaleSumDesc(String minSaleSumDesc){
        this.minSaleSumDesc = minSaleSumDesc;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getMemo(){
        return memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

}
