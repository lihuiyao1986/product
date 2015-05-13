/**
 * @Title: ProductDao.java
 * @Package com.hundsun.fund.product.dao.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月9日 下午8:55:31
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hundsun.fund.product.dao.mapper.ProductMapper;
import com.hundsun.fund.product.dao.model.ProductCollectionDaoModel;
import com.hundsun.fund.product.dao.model.ProductDaoModel;
import com.hundsun.fund.product.dao.model.ProductListQueryParamModel;
import com.hundsun.fund.product.dao.model.ProductListQueryResultModel;

/**
 *@Description:产品信息DAO
 *@Author:李焱生
 *@Since:2015年5月9日下午8:55:31  
 */
@Repository
public class ProductDao {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 
     *@Description: 分页查询推荐产品信息列表
     *@Author: 李焱生
     *@Since: 2015年5月9日下午8:57:28
     *@param longtitude
     *@param latitude
     *@param pageNo
     *@param pageSize
     *@return
     */
    public PageInfo<ProductDaoModel> queryRecommendProductListByPage(String longtitude,String latitude,int pageNo,int pageSize){
        PageHelper.startPage (pageNo, pageSize);
        List<ProductDaoModel> list = productMapper.queryRecommendProductList (latitude, longtitude);
        return new PageInfo<ProductDaoModel> (list);
    }
    
    /**
     * 
     *@Description: 分页查询用户的收藏产品信息列表 
     *@Author: 李焱生
     *@Since: 2015年5月10日下午7:47:13
     *@param userId
     *@param pageNo
     *@param pageSize
     *@return
     */
    public PageInfo<ProductCollectionDaoModel>queryUserCollectionProductList(String userId,int pageNo,int pageSize)
    {
        PageHelper.startPage (pageNo, pageSize);
        List<ProductCollectionDaoModel> list = productMapper.queryUserCollectionProductList (userId);
        return new PageInfo<ProductCollectionDaoModel> (list);
    }

    /**
     *@Description: 分页查询即将到期的产品信息
     *@Author: 李焱生
     *@Since: 2015年5月11日上午11:30:56
     *@param queryParams
     *@param pageNo
     *@param pageSize
     *@return
     */
    public PageInfo<ProductListQueryResultModel> queryMostOverDueProductList(ProductListQueryParamModel queryParams,int pageNo,int pageSize){
        PageHelper.startPage (pageNo, pageSize);
        List<ProductListQueryResultModel> list = productMapper.queryMostOverDueProductList (queryParams);
        return new PageInfo<ProductListQueryResultModel> (list);
    }

    /**
     *@Description: 分页查询附近的产品信息 
     *@Author: 李焱生
     *@Since: 2015年5月11日上午11:32:11
     *@param queryParams
     *@param pageNo
     *@param pageSize
     *@return
     */
    public PageInfo<ProductListQueryResultModel> queryMostNearProductList(ProductListQueryParamModel queryParams,int pageNo,int pageSize){
        PageHelper.startPage (pageNo, pageSize);
        List<ProductListQueryResultModel> list = productMapper.queryMostNearProductList (queryParams);
        return new PageInfo<ProductListQueryResultModel> (list);
    }

    /**
     *@Description: 分页查询收益最高的产品信息 
     *@Author: 李焱生
     *@Since: 2015年5月11日上午11:33:03
     *@param queryParams
     *@param pageNo
     *@param pageSize
     *@return
     */
    public PageInfo<ProductListQueryResultModel> queryMostIncomeProductList(ProductListQueryParamModel queryParams,int pageNo,int pageSize){
        PageHelper.startPage (pageNo, pageSize);
        List<ProductListQueryResultModel> list = productMapper.queryMostIncomeProductList (queryParams);
        return new PageInfo<ProductListQueryResultModel> (list);
    }
    
    
}
