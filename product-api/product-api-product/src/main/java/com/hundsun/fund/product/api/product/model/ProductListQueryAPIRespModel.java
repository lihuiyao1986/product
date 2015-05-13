/**
 * @Title: ProductListQueryAPIRespModel.java
 * @Package com.hundsun.fund.product.api.product.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月11日 上午10:29:59
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.product.model;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hundsun.fund.product.commons.model.BaseAPIRespParam;
import com.hundsun.fund.product.dao.model.ProductListQueryResultModel;

/**
 *@Description:产品信息列表查询
 *@Author:李焱生
 *@Since:2015年5月11日上午10:29:59  
 */
public class ProductListQueryAPIRespModel extends BaseAPIRespParam {

    private static final long         serialVersionUID = 9053998228982829073L;

    /** 是否分页 **/
    private String                    isPage;

    /** 产品列表 **/
    private List<ProductListQueryResultModel>     productList;

    /** 分页产品列表 **/
    private PageInfo<ProductListQueryResultModel> productPageList;

    public String getIsPage(){
        return isPage;
    }

    public void setIsPage(String isPage){
        this.isPage = isPage;
    }

    public List<ProductListQueryResultModel> getProductList(){
        return productList;
    }

    public void setProductList(List<ProductListQueryResultModel> productList){
        this.productList = productList;
    }

    public PageInfo<ProductListQueryResultModel> getProductPageList(){
        return productPageList;
    }

    public void setProductPageList(PageInfo<ProductListQueryResultModel> productPageList){
        this.productPageList = productPageList;
    }

}
