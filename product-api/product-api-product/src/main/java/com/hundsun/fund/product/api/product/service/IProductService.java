/**
 *@Title: IProductService.java 
 *@Package com.hundsun.fund.product.api.product.service 
 *@Description: TODO(用一句话描述该文件做什么) 
 *@author A18ccms A18ccms_gmail_com   
 *@date 2015年5月9日 下午3:50:01 
 *@Copyright:Copyright (c) 
 *@Company:whty李焱生
 *@version V1.0 
 */
package com.hundsun.fund.product.api.product.service;

import com.hundsun.fund.product.api.product.model.ConfigedMostIncomeProductQueryAPIReqModel;
import com.hundsun.fund.product.api.product.model.ConfigedMostIncomeProductQueryAPIRespModel;
import com.hundsun.fund.product.api.product.model.ProductCollectEditReqAPIModel;
import com.hundsun.fund.product.api.product.model.ProductCollectEditRespAPIModel;
import com.hundsun.fund.product.api.product.model.ProductCollectionQueryReqAPIModel;
import com.hundsun.fund.product.api.product.model.ProductCollectionQueryRespAPIModel;
import com.hundsun.fund.product.api.product.model.ProductDetailQueryAPIReqModel;
import com.hundsun.fund.product.api.product.model.ProductDetailQueryAPIRespModel;
import com.hundsun.fund.product.api.product.model.ProductListQueryAPIReqModel;
import com.hundsun.fund.product.api.product.model.ProductListQueryAPIRespModel;
import com.hundsun.fund.product.api.product.model.RecommendQueryReqAPIModel;
import com.hundsun.fund.product.api.product.model.RecommendQueryRespAPIModel;



/**
 *@Description:产品相关的service
 *@Author:李焱生
 *@Since:2015年5月9日下午3:50:01  
 */
public interface IProductService {
    
    /**
     * 
     *@Description: 查询推荐产品列表 
     *@Author: 李焱生
     *@Since: 2015年5月9日下午3:51:19
     *@param params
     *@return
     */
    public RecommendQueryRespAPIModel queryRecommend(RecommendQueryReqAPIModel params);

    /**
     *@Description: 收藏列表查询 
     *@Author: 李焱生
     *@Since: 2015年5月10日上午9:13:52
     *@param reqParam
     *@return
     */
    public ProductCollectionQueryRespAPIModel collectionQuery(ProductCollectionQueryReqAPIModel reqParam);
    
    /**
     * 
     *@Description: 最高收益产品描述查询
     *@Author: 李焱生
     *@Since: 2015年5月10日下午6:26:27
     *@param params
     *@return
     */
    public ConfigedMostIncomeProductQueryAPIRespModel configedMostIncomeProductQuery(ConfigedMostIncomeProductQueryAPIReqModel params);

    
    /**
     * 
     *@Description: 产品详情查询
     *@Author: 李焱生
     *@Since: 2015年5月10日下午8:58:54
     *@param params
     *@return
     */
    public ProductDetailQueryAPIRespModel productDetailQuery(ProductDetailQueryAPIReqModel params);
    
    
    /**
     * 
     *@Description: 产品列表查询 
     *@Author: 李焱生
     *@Since: 2015年5月11日上午10:44:30
     *@param params
     *@return
     */
    public ProductListQueryAPIRespModel productListQuery(ProductListQueryAPIReqModel params);
    
    
    /**
     * 
     *@Description: 编辑收藏产品,如果已收藏则取消收藏，否则收藏
     *@Author: 李焱生
     *@Since: 2015年5月11日下午10:50:53
     *@param params
     *@return
     */
    public ProductCollectEditRespAPIModel editCollectProduct(ProductCollectEditReqAPIModel params);
}
