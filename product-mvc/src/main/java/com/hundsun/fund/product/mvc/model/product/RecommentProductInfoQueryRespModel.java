/**
 * @Title: RecommentProductInfoQueryRespModel.java
 * @Package com.hundsun.fund.product.mvc.model.product
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月9日 下午3:18:24
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.product;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hundsun.fund.product.dao.model.ProductDaoModel;
import com.hundsun.fund.product.mvc.model.base.BaseRespModel;

/**
 *@Description:推荐产品信息查询
 *@Author:李焱生
 *@Since:2015年5月9日下午3:18:24  
 */
public class RecommentProductInfoQueryRespModel extends BaseRespModel {

    private static final long         serialVersionUID = -3281373309555637445L;

    /** 产品信息列表 **/
    private List<ProductDaoModel>     productList;

    /** 分页产品信息列表 **/
    private PageInfo<ProductDaoModel> productPageList;

    /** 是否分页 **/
    private String                    isPage;

    public List<ProductDaoModel> getProductList(){
        return productList;
    }

    public void setProductList(List<ProductDaoModel> productList){
        this.productList = productList;
    }

    public String getIsPage(){
        return isPage;
    }

    public void setIsPage(String isPage){
        this.isPage = isPage;
    }

    public PageInfo<ProductDaoModel> getProductPageList(){
        return productPageList;
    }

    public void setProductPageList(PageInfo<ProductDaoModel> productPageList){
        this.productPageList = productPageList;
    }

}
