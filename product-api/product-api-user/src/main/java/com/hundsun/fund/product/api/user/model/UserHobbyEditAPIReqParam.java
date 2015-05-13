/**
 * @Title: UserHobbyEditAPIReqParam.java
 * @Package com.hundsun.fund.product.api.user.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月7日 下午11:10:39
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.user.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;

/**
 *@Description:编辑用户的爱好信息入参
 *@Author:李焱生
 *@Since:2015年5月7日下午11:10:39  
 */
public class UserHobbyEditAPIReqParam extends BaseAPIReqParam {

    private static final long serialVersionUID = 1122507940421699981L;
    // 爱好id
    private String            hobbyId;

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

    public String getHobbyId(){
        return hobbyId;
    }

    public void setHobbyId(String hobbyId){
        this.hobbyId = hobbyId;
    }

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
