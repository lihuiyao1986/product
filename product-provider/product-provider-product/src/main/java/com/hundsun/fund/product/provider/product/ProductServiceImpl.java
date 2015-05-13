/**
 * @Title: ProductServiceImpl.java
 * @Package com.hundsun.fund.product.provider.product
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月9日 下午3:54:42
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.provider.product;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
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
import com.hundsun.fund.product.api.product.service.IProductService;
import com.hundsun.fund.product.commons.exception.APIException;
import com.hundsun.fund.product.commons.utils.Constant;
import com.hundsun.fund.product.commons.utils.Errorcode;
import com.hundsun.fund.product.commons.utils.StringUtil;
import com.hundsun.fund.product.dao.mapper.ProductMapper;
import com.hundsun.fund.product.dao.model.ConfigedMostIncomeProductDaoModel;
import com.hundsun.fund.product.dao.model.ProductCollectSaveDaoModel;
import com.hundsun.fund.product.dao.model.ProductCollectionDaoModel;
import com.hundsun.fund.product.dao.model.ProductDaoModel;
import com.hundsun.fund.product.dao.model.ProductListQueryParamModel;
import com.hundsun.fund.product.dao.model.ProductListQueryResultModel;
import com.hundsun.fund.product.dao.model.ProductOrgPlannerDaoModel;
import com.hundsun.fund.product.dao.service.ProductDao;

/**
 *@Description:产品service
 *@Author:李焱生
 *@Since:2015年5月9日下午3:54:42  
 */
@Service(value = "productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDao    productDao;

    /**
     *@Description: 推荐产品列表查询
     *@Author: 李焱生
     *@Since: 2015年5月9日下午3:54:42
     *@param params
     *@return
     */
    @Override
    public RecommendQueryRespAPIModel queryRecommend(RecommendQueryReqAPIModel params){
        List<ProductDaoModel> productList = null;
        PageInfo<ProductDaoModel> productPageList = null;
        if (Constant.IS_PAGING_YES.equals (params.getIsPage ())) {
            productPageList = productDao.queryRecommendProductListByPage (params.getLongtitude (), params.getLatitude (), params.getPageNo (),
                    params.getPageSize ());
        } else {
            productList = productMapper.queryRecommendProductList (params.getLatitude (), params.getLongtitude ());
        }
        RecommendQueryRespAPIModel respbean = new RecommendQueryRespAPIModel ();
        respbean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        respbean.setMessage ("查询推荐产品信息成功");
        respbean.setIsPage (params.getIsPage ());
        respbean.setProductList (productList);
        respbean.setProductPageList (productPageList);
        return respbean;
    }

    /**
     *@Description: 产品收藏列表查询 
     *@Author: 李焱生
     *@Since: 2015年5月10日下午6:21:12
     *@param reqParam
     *@return
     */
    @Override
    public ProductCollectionQueryRespAPIModel collectionQuery(ProductCollectionQueryReqAPIModel params){
        List<ProductCollectionDaoModel> productList = null;
        PageInfo<ProductCollectionDaoModel> productPageList = null;
        if (Constant.IS_PAGING_YES.equals (params.getIsPage ())) {
            productPageList = productDao.queryUserCollectionProductList (params.getUserId (), params.getPageNo (), params.getPageSize ());
        } else {
            productList = productMapper.queryUserCollectionProductList (params.getUserId ());
        }
        ProductCollectionQueryRespAPIModel respbean = new ProductCollectionQueryRespAPIModel ();
        respbean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        respbean.setMessage ("查询推荐产品信息成功");
        respbean.setIsPage (params.getIsPage ());
        respbean.setProductList (productList);
        respbean.setProductPageList (productPageList);
        return respbean;
    }

    /**
     *@Description:最高收益产品描述查询
     *@Author: 李焱生
     *@Since: 2015年5月10日下午6:27:11
     *@param params
     *@return
     */
    @Override
    public ConfigedMostIncomeProductQueryAPIRespModel configedMostIncomeProductQuery(ConfigedMostIncomeProductQueryAPIReqModel params){
        String city = StringUtil.trimNull (params.getCity ());
        List<ConfigedMostIncomeProductDaoModel> list = productMapper.queryConfigedMostIncomeProductInfo (city);
        ConfigedMostIncomeProductQueryAPIRespModel respBean = new ConfigedMostIncomeProductQueryAPIRespModel ();
        respBean.setCity (city);
        respBean.setList (list);
        respBean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        respBean.setMessage ("查询成功");
        return respBean;
    }

    /**
     * 
     *@Description: 产品详情查询
     *@Author: 李焱生
     *@Since: 2015年5月10日下午8:58:54
     *@param params
     *@return
     */
    @Override
    public ProductDetailQueryAPIRespModel productDetailQuery(ProductDetailQueryAPIReqModel params){
        String productId = StringUtil.trimNull (params.getProductId ());
        if (StringUtil.isEmpty (productId)) { throw new APIException (Errorcode.PRODUCT_ID_IS_NULL,"产品ID为空"); }
        ProductDaoModel product = productMapper.queryProductDetail (productId);
        if (product == null) { throw new APIException (Errorcode.PRODUCT_NOT_EXISTS,"该产品不存在"); }
        List<ProductOrgPlannerDaoModel> plannerOrgList = productMapper.queryPlannerOrgListByProductId (productId);
        String userId = StringUtil.trimNull (params.getUserId ());
        ProductCollectionDaoModel collectProduct = null;
        String isCollected = ProductDetailQueryAPIRespModel.uncollected_type;
        if (!StringUtil.isEmpty (userId)) {
            collectProduct = productMapper.queryUserCollectByUserIdAndProductId (userId, productId);
            if (collectProduct != null) {
                isCollected = ProductDetailQueryAPIRespModel.collected_type;
            }
        }
        ProductDetailQueryAPIRespModel respBean = new ProductDetailQueryAPIRespModel ();
        respBean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        respBean.setMessage ("查询详情成功");
        respBean.setProduct (product);
        respBean.setPlannerOrgList (plannerOrgList);
        respBean.setCollected (isCollected);
        return respBean;
    }

    /**
     *@Description: 产品列表查询
     *@Author: 李焱生
     *@Since: 2015年5月11日上午10:45:15
     *@param params
     *@return
     */
    @Override
    public ProductListQueryAPIRespModel productListQuery(ProductListQueryAPIReqModel params){
        // 查询类型
        String type = StringUtil.trimNull (params.getType (), ProductListQueryAPIReqModel.query_type_most_income);

        if (ProductListQueryAPIReqModel.query_type_most_income.equals (type)) {
            return queryMostIncomeProductList (params);
        } else if (ProductListQueryAPIReqModel.query_type_most_near.equals (type)) {
            return queryMostNearProductList (params);
        } else if (ProductListQueryAPIReqModel.query_type_most_overdue.equals (type)) {
            return queryMostOverDueProductList (params);
        } else {
            throw new APIException (Errorcode.PRODUCT_QUERY_TYPE_UNKNOW,"查询类型为未知");
        }
    }

    /**
     *@Description: 查询即将到期的产品列表信息 
     *@Author: 李焱生
     *@Since: 2015年5月11日上午10:53:18
     *@param params
     *@return
     */
    private ProductListQueryAPIRespModel queryMostOverDueProductList(ProductListQueryAPIReqModel params){
        String isPage = StringUtil.trimNull (params.getIsPage ());
        ProductListQueryParamModel queryParams = new ProductListQueryParamModel ();
        queryParams.setCity (StringUtil.trimNull (params.getCity ()));
        queryParams.setDistance (StringUtil.trimNull (params.getDistance ()));
        queryParams.setLatitude (StringUtil.trimNull (params.getLatitude ()));
        queryParams.setLongtitude (StringUtil.trimNull (params.getLongtitude ()));
        queryParams.setMaxLimit (StringUtil.trimNull (params.getMaxLimit ()));
        queryParams.setMinLimit (StringUtil.trimNull (params.getMinLimit ()));
        queryParams.setProductType (StringUtil.trimNull (params.getProductType ()));
        List<ProductListQueryResultModel> productList = null;
        PageInfo<ProductListQueryResultModel> productPageList = null;
        if (Constant.IS_PAGING_YES.equals (isPage)) {
            productPageList = productDao.queryMostOverDueProductList (queryParams, params.getPageNo (), params.getPageSize ());
        } else {
            productList = productMapper.queryMostOverDueProductList (queryParams);
        }
        ProductListQueryAPIRespModel respBean = new ProductListQueryAPIRespModel ();
        respBean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        respBean.setMessage ("查询成功");
        respBean.setIsPage (isPage);
        respBean.setProductList (productList);
        respBean.setProductPageList (productPageList);
        return respBean;
    }

    /**
     *@Description: 查询附近的产品列表信息
     *@Author: 李焱生
     *@Since: 2015年5月11日上午10:52:37
     *@param params
     *@return
     */
    private ProductListQueryAPIRespModel queryMostNearProductList(ProductListQueryAPIReqModel params){
        String isPage = StringUtil.trimNull (params.getIsPage ());
        ProductListQueryParamModel queryParams = new ProductListQueryParamModel ();
        queryParams.setCity (StringUtil.trimNull (params.getCity ()));
        queryParams.setDistance (StringUtil.trimNull (params.getDistance ()));
        queryParams.setLatitude (StringUtil.trimNull (params.getLatitude ()));
        queryParams.setLongtitude (StringUtil.trimNull (params.getLongtitude ()));
        queryParams.setMaxLimit (StringUtil.trimNull (params.getMaxLimit ()));
        queryParams.setMinLimit (StringUtil.trimNull (params.getMinLimit ()));
        queryParams.setProductType (StringUtil.trimNull (params.getProductType ()));
        List<ProductListQueryResultModel> productList = null;
        PageInfo<ProductListQueryResultModel> productPageList = null;
        if (Constant.IS_PAGING_YES.equals (isPage)) {
            productPageList = productDao.queryMostNearProductList (queryParams, params.getPageNo (), params.getPageSize ());
        } else {
            productList = productMapper.queryMostNearProductList (queryParams);
        }
        ProductListQueryAPIRespModel respBean = new ProductListQueryAPIRespModel ();
        respBean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        respBean.setMessage ("查询成功");
        respBean.setIsPage (isPage);
        respBean.setProductList (productList);
        respBean.setProductPageList (productPageList);
        return respBean;
    }

    /**
     *@Description: 查询最高收益的产品列表信息 
     *@Author: 李焱生
     *@Since: 2015年5月11日上午10:48:59
     *@param params
     *@return
     */
    private ProductListQueryAPIRespModel queryMostIncomeProductList(ProductListQueryAPIReqModel params){
        String isPage = StringUtil.trimNull (params.getIsPage ());
        ProductListQueryParamModel queryParams = new ProductListQueryParamModel ();
        queryParams.setCity (StringUtil.trimNull (params.getCity ()));
        queryParams.setDistance (StringUtil.trimNull (params.getDistance ()));
        queryParams.setLatitude (StringUtil.trimNull (params.getLatitude ()));
        queryParams.setLongtitude (StringUtil.trimNull (params.getLongtitude ()));
        queryParams.setMaxLimit (StringUtil.trimNull (params.getMaxLimit ()));
        queryParams.setMinLimit (StringUtil.trimNull (params.getMinLimit ()));
        queryParams.setProductType (StringUtil.trimNull (params.getProductType ()));
        List<ProductListQueryResultModel> productList = null;
        PageInfo<ProductListQueryResultModel> productPageList = null;
        if (Constant.IS_PAGING_YES.equals (isPage)) {
            productPageList = productDao.queryMostIncomeProductList (queryParams, params.getPageNo (), params.getPageSize ());
        } else {
            productList = productMapper.queryMostIncomeProductList (queryParams);
        }
        ProductListQueryAPIRespModel respBean = new ProductListQueryAPIRespModel ();
        respBean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        respBean.setMessage ("查询成功");
        respBean.setIsPage (isPage);
        respBean.setProductList (productList);
        respBean.setProductPageList (productPageList);
        return respBean;
    }

    /**
     *@Description: 编辑收藏产品，如果已收藏则取消收藏，否则收藏
     *@Author: 李焱生
     *@Since: 2015年5月11日下午10:51:10
     *@param params
     *@return
     */
    @Override
    public ProductCollectEditRespAPIModel editCollectProduct(ProductCollectEditReqAPIModel params){
        String productId = StringUtil.trimNull (params.getProductId ());
        String userId = StringUtil.trimNull (params.getUserId ());
        if (StringUtil.isEmpty (userId) || StringUtil.isEmpty (productId)) { throw new APIException (Errorcode.PRODUCT_ID_OR_USERID_IS_NULL,"产品id或用户id为空"); }
        ProductDaoModel product = productMapper.queryProductDetail (params.getProductId ());
        if (product == null) { throw new APIException (Errorcode.PRODUCT_NOT_EXISTS,"该产品不存在"); }
        ProductCollectSaveDaoModel collectProductInfo = productMapper.hasProductCollectByUser (userId, productId);
        if (collectProductInfo == null) {
            ProductCollectSaveDaoModel model = new ProductCollectSaveDaoModel ();
            model.setCollectionTime (new Date ());
            model.setProductId (params.getProductId ());
            model.setUserId (params.getUserId ());
            productMapper.collectProduct (model);
        } else {
            productMapper.deleteCollectProductByCollectId (collectProductInfo.getId ());
        }
        ProductCollectEditRespAPIModel respBean = new ProductCollectEditRespAPIModel ();
        respBean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        respBean.setMessage ("调用接口成功");
        return respBean;
    }

}
