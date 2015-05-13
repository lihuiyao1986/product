/**
 * @Title: ProductController.java
 * @Package com.hundsun.fund.product.mvc.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 上午9:05:18
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.hundsun.fund.product.api.user.model.UserInfoQueryByUuidAPIReqModel;
import com.hundsun.fund.product.api.user.model.UserInfoQueryByUuidAPIRespModel;
import com.hundsun.fund.product.api.user.service.IUserService;
import com.hundsun.fund.product.commons.utils.APPUtils;
import com.hundsun.fund.product.commons.utils.Constant;
import com.hundsun.fund.product.commons.utils.StringUtil;
import com.hundsun.fund.product.dao.model.UserInfoDaoModel;
import com.hundsun.fund.product.mvc.model.product.ConfigedMostIncomProductReqModel;
import com.hundsun.fund.product.mvc.model.product.ConfigedMostIncomProductRespModel;
import com.hundsun.fund.product.mvc.model.product.ProductCollectEditReqModel;
import com.hundsun.fund.product.mvc.model.product.ProductCollectEditRespModel;
import com.hundsun.fund.product.mvc.model.product.ProductCollectionQueryReqModel;
import com.hundsun.fund.product.mvc.model.product.ProductCollectionQueryRespModel;
import com.hundsun.fund.product.mvc.model.product.ProductDetailQueryReqModel;
import com.hundsun.fund.product.mvc.model.product.ProductDetailQueryRespModel;
import com.hundsun.fund.product.mvc.model.product.ProductListQueryReqModel;
import com.hundsun.fund.product.mvc.model.product.ProductListQueryRespModel;
import com.hundsun.fund.product.mvc.model.product.RecommentProductInfoQueryReqModel;
import com.hundsun.fund.product.mvc.model.product.RecommentProductInfoQueryRespModel;

/**
 *@Description:产品对应的控制器类
 *@Author:李焱生
 *@Since:2015年5月6日上午9:05:18  
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    private IProductService productServie;

    @Autowired
    private IUserService    userService;

    /**
     * 
     *@Description: 推荐产品信息
     *@Author: 李焱生
     *@Since: 2015年5月9日下午3:28:50
     *@param params
     *@param request
     *@return
     */
    @ResponseBody
    @RequestMapping("/recommend_list.json")
    public RecommentProductInfoQueryRespModel recommendInfoQuery(RecommentProductInfoQueryReqModel params,HttpServletRequest request){
        RecommendQueryReqAPIModel reqParam = new RecommendQueryReqAPIModel ();
        reqParam.setIsPage (params.getIsPage ());
        reqParam.setLatitude (StringUtil.trimNull (params.getLatitude ()));
        reqParam.setLongtitude (StringUtil.trimNull (params.getLongtitude ()));
        reqParam.setPageNo (params.getPageNo ());
        reqParam.setPageSize (params.getPageSize ());
        RecommendQueryRespAPIModel respBean = productServie.queryRecommend (reqParam);
        RecommentProductInfoQueryRespModel resultBean = new RecommentProductInfoQueryRespModel ();
        resultBean.setCode (respBean.getCode ());
        resultBean.setMessage (respBean.getMessage ());
        resultBean.setIsPage (respBean.getIsPage ());
        if (APPUtils.isAPISuccess (respBean)) {
            resultBean.setProductList (respBean.getProductList ());
            resultBean.setProductPageList (respBean.getProductPageList ());
        }
        return resultBean;
    }

    /***
     * 
     *@Description: 收藏列表查询
     *@Author: 李焱生
     *@Since: 2015年5月10日上午8:54:11
     *@param params
     *@param request
     *@return
     */
    @ResponseBody
    @RequestMapping("/collection_query.json")
    public ProductCollectionQueryRespModel productCollectQuery(ProductCollectionQueryReqModel params,HttpServletRequest request){
        UserInfoDaoModel userInfo = (UserInfoDaoModel) request.getAttribute (Constant.USER_INFO_KEY_IN_REDIS);
        String userId = userInfo.getId ();
        ProductCollectionQueryReqAPIModel reqParam = new ProductCollectionQueryReqAPIModel ();
        reqParam.setIsPage (params.getIsPage ());
        reqParam.setPageNo (params.getPageNo ());
        reqParam.setPageSize (params.getPageSize ());
        reqParam.setUserId (userId);
        ProductCollectionQueryRespAPIModel respBean = productServie.collectionQuery (reqParam);
        ProductCollectionQueryRespModel resultBean = new ProductCollectionQueryRespModel ();
        resultBean.setCode (respBean.getCode ());
        resultBean.setMessage (respBean.getMessage ());
        resultBean.setIsPage (params.getIsPage ());
        if (APPUtils.isAPISuccess (respBean)) {
            resultBean.setProductList (respBean.getProductList ());
            resultBean.setProductPageList (respBean.getProductPageList ());
        }
        return resultBean;
    }

    /**
     * 
     *@Description: 产品列表查询
     *@Author: 李焱生
     *@Since: 2015年5月11日下午9:58:09
     *@param params
     *@return
     */
    @ResponseBody
    @RequestMapping("/product_list_query.json")
    public ProductListQueryRespModel productListQuery(ProductListQueryReqModel params){
        ProductListQueryAPIReqModel reqParam = new ProductListQueryAPIReqModel ();
        reqParam.setCity (StringUtil.trimNull (params.getCity ()));
        reqParam.setDistance (StringUtil.trimNull (params.getDistance ()));
        reqParam.setLatitude (StringUtil.trimNull (params.getLatitude ()));
        reqParam.setLongtitude (StringUtil.trimNull (params.getLongtitude ()));
        reqParam.setMaxLimit (StringUtil.trimNull (params.getMaxLimit ()));
        reqParam.setMinLimit (StringUtil.trimNull (params.getMinLimit ()));
        reqParam.setIsPage (StringUtil.trimNull (params.getIsPage ()));
        reqParam.setPageNo (params.getPageNo ());
        reqParam.setPageSize (params.getPageSize ());
        reqParam.setProductType (StringUtil.trimNull (params.getProductType ()));
        reqParam.setType (StringUtil.trimNull (params.getType ()));
        ProductListQueryAPIRespModel respBean = productServie.productListQuery (reqParam);
        ProductListQueryRespModel result = new ProductListQueryRespModel ();
        result.setCode (respBean.getCode ());
        result.setMessage (respBean.getMessage ());
        result.setIsPage (params.getIsPage ());
        result.setProductList (respBean.getProductList ());
        result.setProductPageList (respBean.getProductPageList ());
        return result;
    }

    /**
     * 
     *@Description: 编辑收藏产品信息 
     *@Author: 李焱生
     *@Since: 2015年5月11日下午11:33:09
     *@param params
     *@param request
     *@return
     */
    @ResponseBody
    @RequestMapping("/collect_product_edit.json")
    public ProductCollectEditRespModel collectProductEdit(ProductCollectEditReqModel params,HttpServletRequest request){
        UserInfoDaoModel userInfo = (UserInfoDaoModel) request.getAttribute (Constant.USER_INFO_KEY_IN_REDIS);
        String userId = userInfo.getId ();
        ProductCollectEditReqAPIModel reqParam = new ProductCollectEditReqAPIModel ();
        reqParam.setProductId (StringUtil.trimNull (params.getProductId ()));
        reqParam.setUserId (userId);
        ProductCollectEditRespAPIModel respBean = productServie.editCollectProduct (reqParam);
        ProductCollectEditRespModel result = new ProductCollectEditRespModel ();
        result.setCode (respBean.getCode ());
        result.setMessage (respBean.getMessage ());
        return result;

    }

    /**
     * 
     *@Description: 产品详情查询 
     *@Author: 李焱生
     *@Since: 2015年5月12日上午9:03:52
     *@param params
     *@return
     */
    @ResponseBody
    @RequestMapping("/detail_query.json")
    public ProductDetailQueryRespModel detailQuery(ProductDetailQueryReqModel params){
        String userId = null;
        UserInfoQueryByUuidAPIReqModel userInfoQueryParam = new UserInfoQueryByUuidAPIReqModel ();
        userInfoQueryParam.setUuid (StringUtil.trimNull (params.getUuid ()));
        UserInfoQueryByUuidAPIRespModel userInfoQueryResp = userService.queryUserInfoByUuid (userInfoQueryParam);
        if (APPUtils.isAPISuccess (userInfoQueryResp)) {
            userId = userInfoQueryResp.getUserInfo ().getId ();
        }
        ProductDetailQueryAPIReqModel reqParam = new ProductDetailQueryAPIReqModel ();
        reqParam.setProductId (StringUtil.trimNull (params.getProductId ()));
        reqParam.setUserId (StringUtil.trimNull (userId));
        ProductDetailQueryAPIRespModel respBean = productServie.productDetailQuery (reqParam);
        ProductDetailQueryRespModel resultBean = new ProductDetailQueryRespModel ();
        resultBean.setCode (respBean.getCode ());
        resultBean.setMessage (respBean.getMessage ());
        resultBean.setCollected (respBean.getCollected ());
        resultBean.setPlannerOrgList (respBean.getPlannerOrgList ());
        resultBean.setProduct (respBean.getProduct ());
        return resultBean;
    }

    /**
     * 
     *@Description: 配置的最高收益产品信息查询
     *@Author: 李焱生
     *@Since: 2015年5月13日上午9:34:48
     *@param params
     *@return
     */
    @ResponseBody
    @RequestMapping("/configed_most_income_query.json")
    public ConfigedMostIncomProductRespModel configedMostIncomeQuery(ConfigedMostIncomProductReqModel params){
        ConfigedMostIncomeProductQueryAPIReqModel reqParam = new ConfigedMostIncomeProductQueryAPIReqModel ();
        reqParam.setCity (StringUtil.trimNull (params.getCity ()));
        ConfigedMostIncomeProductQueryAPIRespModel respBean = productServie.configedMostIncomeProductQuery (reqParam);
        ConfigedMostIncomProductRespModel result = new ConfigedMostIncomProductRespModel ();
        result.setCode (respBean.getCode ());
        result.setMessage (respBean.getMessage ());
        result.setList (respBean.getList ());
        result.setCity (StringUtil.trimNull (params.getCity ()));
        return result;
    }

}
