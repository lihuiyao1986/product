/**
 * @Title: UserHobbyDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 上午11:26:02
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

/**
 *@Description:用户爱好
 *@Author:李焱生
 *@Since:2015年5月6日上午11:26:02  
 */
public class UserHobbyDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = -3054807955493535747L;

    // 用户id
    private String            userId;

    // 投资规模
    private String            assest;

    // 年化收益率
    private String            yearIncomeRate;

    // 产品期限
    private String            limit;

    // 风险承受类型 00-保本 01-非保本 02-保本浮动 03-保本预期
    private String            riskAbility;

    // 备注
    private String            memo;

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getAssest(){
        return assest;
    }

    public void setAssest(String assest){
        this.assest = assest;
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

    public String getRiskAbility(){
        return riskAbility;
    }

    public void setRiskAbility(String riskAbility){
        this.riskAbility = riskAbility;
    }

    public String getMemo(){
        return memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

}
