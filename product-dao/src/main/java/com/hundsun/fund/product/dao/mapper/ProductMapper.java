/**
 * @Title: ProductMapper.java
 * @Package com.hundsun.fund.product.dao.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 下午12:52:36
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hundsun.fund.product.dao.model.ConfigedMostIncomeProductDaoModel;
import com.hundsun.fund.product.dao.model.ProductCollectSaveDaoModel;
import com.hundsun.fund.product.dao.model.ProductCollectionDaoModel;
import com.hundsun.fund.product.dao.model.ProductDaoModel;
import com.hundsun.fund.product.dao.model.ProductListQueryParamModel;
import com.hundsun.fund.product.dao.model.ProductListQueryResultModel;
import com.hundsun.fund.product.dao.model.ProductOrgPlannerDaoModel;

/**
 *@Description:产品mapper
 *@Author:李焱生
 *@Since:2015年5月6日下午12:52:36  
 */
public interface ProductMapper extends BaseMapper {

    /**
     *@Description: 查询推荐产品列表
     *@Author: 李焱生
     *@Since: 2015年5月9日下午8:58:05
     *@param latitude
     *@param longtitude
     *@return
     */
    List<ProductDaoModel> queryRecommendProductList(@Param("latitude") String latitude,@Param("longtitude") String longtitude);

    /**
     * 
     *@Description: 查询最高收益的产品描述信息
     *@Author: 李焱生
     *@Since: 2015年5月10日下午5:31:39
     *@param city
     *@return
     */
    List<ConfigedMostIncomeProductDaoModel> queryConfigedMostIncomeProductInfo(@Param("city") String city);

    /**
     * 
     *@Description: 查询用户收藏产品列表
     *@Author: 李焱生
     *@Since: 2015年5月10日下午7:22:24
     *@param userId
     *@return
     */
    List<ProductCollectionDaoModel> queryUserCollectionProductList(@Param("userId") String userId);

    /**
     *@Description: 查询产品详情 
     *@Author: 李焱生
     *@Since: 2015年5月10日下午9:09:04
     *@param productId
     *@return
     */
    ProductDaoModel queryProductDetail(@Param("productId") String productId);

    /**
     *@Description: 根据产品ID查询销售网点以及理财师的信息 
     *@Author: 李焱生
     *@Since: 2015年5月10日下午9:13:17
     *@param productId
     *@return
     */
    List<ProductOrgPlannerDaoModel> queryPlannerOrgListByProductId(@Param("productId") String productId);

    /**
     *@Description: 根据产品id和用户id查询收藏信息 
     *@Author: 李焱生
     *@Since: 2015年5月10日下午11:28:58
     *@param userId
     *@param productId
     *@return
     */
    ProductCollectionDaoModel queryUserCollectByUserIdAndProductId(@Param("userId") String userId,@Param("productId") String productId);

    /**
     *@Description: 查询即将到期的产品信息列表 
     *@Author: 李焱生
     *@Since: 2015年5月11日上午11:31:16
     *@param queryParams
     *@return
     */
    List<ProductListQueryResultModel> queryMostOverDueProductList(ProductListQueryParamModel queryParams);

    /**
     *@Description: 查询附近的产品信息
     *@Author: 李焱生
     *@Since: 2015年5月11日上午11:32:29
     *@param queryParams
     *@return
     */
    List<ProductListQueryResultModel> queryMostNearProductList(ProductListQueryParamModel queryParams);

    /**
     *@Description: 查询最高收益的产品
     *@Author: 李焱生
     *@Since: 2015年5月11日下午12:58:20
     *@param queryParams
     *@return
     */
    List<ProductListQueryResultModel> queryMostIncomeProductList(ProductListQueryParamModel queryParams);

    /**
     *@Description: 收藏产品信息 
     *@Author: 李焱生
     *@Since: 2015年5月11日下午10:53:35
     *@param model
     */
    void collectProduct(ProductCollectSaveDaoModel model);

    /**
     * 
     *@Description: 判断对应的产品是否已经被收藏 
     *@Author: 李焱生
     *@Since: 2015年5月11日下午11:09:47
     *@param userId
     *@param productId
     *@return
     */
    ProductCollectSaveDaoModel hasProductCollectByUser(@Param("userId") String userId,@Param("productId") String productId);

    /**
     *@Description:  取消收藏
     *@Author: 李焱生
     *@Since: 2015年5月11日下午11:21:42
     *@param id
     */
    void deleteCollectProductByCollectId(@Param("collectId")String collectId);
}
