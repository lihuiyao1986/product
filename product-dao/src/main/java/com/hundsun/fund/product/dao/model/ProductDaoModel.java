/**
 * @Title: ProductDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 上午10:52:11
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *@Description:产品信息
 *@Author:李焱生
 *@Since:2015年5月6日上午10:52:11  
 */
public class ProductDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = 4968253690419753424L;

    // 产品代码
    private String            productCode;

    // 产品名称
    private String            productName;

    // 年化收益率
    private String            yearIncomeRate;

    // 产品期限
    private String            limit;

    // 起投金额
    private String            minInvestSum;

    // 销售起始日期
    @JSONField(format="yyyyMMdd")
    private Date              saleStartTime;

    // 销售截止日期
    @JSONField(format="yyyyMMdd")
    private Date              saleEndTime;

    // 产品到期时间
    @JSONField(format="yyyyMMdd")
    private Date              overdueTime;

    // 产品审核状态 00-待审核 01-已审核 02-审核退回
    private String            verifyStatus;

    // 产品类型 00-银行理财 01--货币基金
    private String            type;

    // 产品销售规模
    private String            saleTotalSum;

    // 产品剩余规模
    private String            saleRemainSum;

    // 已销售产品规模
    private String            saleSaledSum;

    // 产品风险类型 00-保本 01-非保本 02-保本浮动 03-保本预期
    private String            riskType;

    // 产品描述
    private String            productDesc;

    // 付息方式描述
    private String            interestPayDesc;

    // 理财产品发型机构名称
    private String            orgName;

    // 备注
    private String            memo;

    public String getProductCode(){
        return productCode;
    }

    public void setProductCode(String productCode){
        this.productCode = productCode;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getYearIncomeRate(){
        return yearIncomeRate;
    }

    public void setYearIncomeRate(String yearIncomeRate){
        this.yearIncomeRate = yearIncomeRate;
    }

    public String getLimit(){
        return limit;
    }

    public void setLimit(String limit){
        this.limit = limit;
    }

    public String getMinInvestSum(){
        return minInvestSum;
    }

    public void setMinInvestSum(String minInvestSum){
        this.minInvestSum = minInvestSum;
    }

    public Date getSaleStartTime(){
        return saleStartTime;
    }

    public void setSaleStartTime(Date saleStartTime){
        this.saleStartTime = saleStartTime;
    }

    public Date getSaleEndTime(){
        return saleEndTime;
    }

    public void setSaleEndTime(Date saleEndTime){
        this.saleEndTime = saleEndTime;
    }

    public Date getOverdueTime(){
        return overdueTime;
    }

    public void setOverdueTime(Date overdueTime){
        this.overdueTime = overdueTime;
    }

    public String getVerifyStatus(){
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus){
        this.verifyStatus = verifyStatus;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getRiskType(){
        return riskType;
    }

    public void setRiskType(String riskType){
        this.riskType = riskType;
    }

    public String getMemo(){
        return memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

    public String getProductDesc(){
        return productDesc;
    }

    public void setProductDesc(String productDesc){
        this.productDesc = productDesc;
    }

    public String getInterestPayDesc(){
        return interestPayDesc;
    }

    public void setInterestPayDesc(String interestPayDesc){
        this.interestPayDesc = interestPayDesc;
    }

    public String getOrgName(){
        return orgName;
    }

    public void setOrgName(String orgName){
        this.orgName = orgName;
    }

    public String getSaleTotalSum(){
        return saleTotalSum;
    }

    public void setSaleTotalSum(String saleTotalSum){
        this.saleTotalSum = saleTotalSum;
    }

    public String getSaleRemainSum(){
        return saleRemainSum;
    }

    public void setSaleRemainSum(String saleRemainSum){
        this.saleRemainSum = saleRemainSum;
    }

    public String getSaleSaledSum(){
        return saleSaledSum;
    }

    public void setSaleSaledSum(String saleSaledSum){
        this.saleSaledSum = saleSaledSum;
    }

}
