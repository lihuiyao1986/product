/**
 * @Title: ProductDetailQueryRespModel.java
 * @Package com.hundsun.fund.product.mvc.model.product
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月12日 上午8:57:32
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.product;

import java.util.List;

import com.hundsun.fund.product.dao.model.ProductDaoModel;
import com.hundsun.fund.product.dao.model.ProductOrgPlannerDaoModel;
import com.hundsun.fund.product.mvc.model.base.BaseRespModel;

/**
 *@Description:产品详情查询
 *@Author:李焱生
 *@Since:2015年5月12日上午8:57:32  
 */
public class ProductDetailQueryRespModel extends BaseRespModel {

    private static final long               serialVersionUID = -2840639117708021506L;
    
    // 产品信息
    private ProductDaoModel                 product;

    // 理财师和理财机构信息列表
    private List<ProductOrgPlannerDaoModel> plannerOrgList;

    // 是否收藏 0-－未收藏 1--收藏
    private String                          collected;

    public ProductDaoModel getProduct(){
        return product;
    }

    public void setProduct(ProductDaoModel product){
        this.product = product;
    }

    public List<ProductOrgPlannerDaoModel> getPlannerOrgList(){
        return plannerOrgList;
    }

    public void setPlannerOrgList(List<ProductOrgPlannerDaoModel> plannerOrgList){
        this.plannerOrgList = plannerOrgList;
    }

    public String getCollected(){
        return collected;
    }

    public void setCollected(String collected){
        this.collected = collected;
    }
}
