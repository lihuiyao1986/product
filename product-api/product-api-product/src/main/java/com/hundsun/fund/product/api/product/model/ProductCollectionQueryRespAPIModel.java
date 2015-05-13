/**
 * @Title: ProductCollectionQueryRespAPIModel.java
 * @Package com.hundsun.fund.product.api.product.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月10日 上午9:08:41
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.product.model;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hundsun.fund.product.commons.model.BaseAPIRespParam;
import com.hundsun.fund.product.dao.model.ProductCollectionDaoModel;

/**
 *@Description:产品收藏列表查询
 *@Author:李焱生
 *@Since:2015年5月10日上午9:08:41  
 */
public class ProductCollectionQueryRespAPIModel extends BaseAPIRespParam {

    private static final long                   serialVersionUID = 1332015417918792565L;

    /** 集合列表 全部 **/
    private List<ProductCollectionDaoModel>     productList;

    /** 集合列表 分页 **/
    private PageInfo<ProductCollectionDaoModel> productPageList;

    /** 是否分页 **/
    private String                              isPage;

    public List<ProductCollectionDaoModel> getProductList(){
        return productList;
    }

    public void setProductList(List<ProductCollectionDaoModel> productList){
        this.productList = productList;
    }

    public PageInfo<ProductCollectionDaoModel> getProductPageList(){
        return productPageList;
    }

    public void setProductPageList(PageInfo<ProductCollectionDaoModel> productPageList){
        this.productPageList = productPageList;
    }

    public String getIsPage(){
        return isPage;
    }

    public void setIsPage(String isPage){
        this.isPage = isPage;
    }

}
