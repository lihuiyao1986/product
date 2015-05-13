/**
 * @Title: ProductMapperTest.java
 * @Package com.dao.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月9日 下午10:14:37
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.dao.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hundsun.fund.product.dao.mapper.ProductMapper;
import com.hundsun.fund.product.dao.model.ConfigedMostIncomeProductDaoModel;
import com.hundsun.fund.product.dao.model.ProductCollectSaveDaoModel;
import com.hundsun.fund.product.dao.model.ProductCollectionDaoModel;
import com.hundsun.fund.product.dao.model.ProductDaoModel;
import com.hundsun.fund.product.dao.model.ProductListQueryParamModel;
import com.hundsun.fund.product.dao.model.ProductListQueryResultModel;
import com.hundsun.fund.product.dao.model.ProductOrgPlannerDaoModel;

/**
 *@Description:ProductMapper测试
 *@Author:李焱生
 *@Since:2015年5月9日下午10:14:37  
 */
public class ProductMapperTest extends BaseTest {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 查询推荐产品信息
     *@Description: TODO(这里用一句话描述这个方法的作用) 
     *@Author: 李焱生
     *@Since: 2015年5月10日下午5:37:27
     */
    //@Test
    public void testQueryRecommendProductList(){
        List<ProductDaoModel> list = productMapper.queryRecommendProductList (null, null);
        for ( ProductDaoModel productDaoModel : list ) {
            logger.debug ("------begin---------");
            logger.debug ("productcode=" + productDaoModel.getProductCode ());
            logger.debug ("productname=" + productDaoModel.getProductName ());
            logger.debug ("riskType=" + productDaoModel.getRiskType ());
            logger.debug ("------end---------");
        }
    }

    /**
     * 
     *@Description: 查询最高收益的产品信息
     *@Author: 李焱生
     *@Since: 2015年5月10日下午5:33:35
     */
    @Test
    public void testQueryConfigedMostIncomeProductInfo(){
        List<ConfigedMostIncomeProductDaoModel> list = productMapper.queryConfigedMostIncomeProductInfo ("杭州市");
        for ( ConfigedMostIncomeProductDaoModel mostIncomeProductDaoModel : list ) {
            logger.debug ("city=" + mostIncomeProductDaoModel.getCity ());
            logger.debug ("limitDesc=" + mostIncomeProductDaoModel.getLimitDesc ());
            logger.debug ("MinSaleSumDesc=" + mostIncomeProductDaoModel.getMinSaleSumDesc ());
            logger.debug ("YearIncomeRateDesc=" + mostIncomeProductDaoModel.getYearIncomeRateDesc ());
        }
    }
    
    /**
     * 
     *@Description: 查询用户收藏的产品列表 
     *@Author: 李焱生
     *@Since: 2015年5月10日下午7:56:01
     */
    //@Test
    public void testQueryUserCollectionProductList()
    {
        List<ProductCollectionDaoModel> list =  productMapper.queryUserCollectionProductList ("1");
        for ( ProductCollectionDaoModel productCollectionDaoModel : list ) {
            logger.debug (""+productCollectionDaoModel.getOrgName () );
            logger.debug (""+productCollectionDaoModel.getCollectionTime ().toString ());
        }
    }
    
    /**
     * 
     *@Description: 查询理财师，销售机构，产品信息 
     *@Author: 李焱生
     *@Since: 2015年5月10日下午10:19:09
     */
    //@Test
    public void testQueryPlannerOrgListByProductId(){
        List<ProductOrgPlannerDaoModel> list = productMapper.queryPlannerOrgListByProductId ("2");
        logger.debug (list);
    }
    
    
    /**
     * 
     *@Description: 根据用户id和产品is查询收藏的产品信息 
     *@Author: 李焱生
     *@Since: 2015年5月11日下午4:26:05
     */
    //@Test
    public void testQueryUserCollectByUserIdAndProductId()
    {
        ProductCollectionDaoModel model =  productMapper.queryUserCollectByUserIdAndProductId ("1", "2");
        if(model!=null)
        {
            logger.debug (model);
            logger.debug ("产品名称:" + model.getProductName());
        }
        
    }
    
    /**
     * 
     *@Description: 查询即将到期的产品信息
     *@Author: 李焱生
     *@Since: 2015年5月11日下午5:01:46
     */
    //@Test
    public void testQueryMostOverDueProductList()
    {
        ProductListQueryParamModel params = new ProductListQueryParamModel ();
        params.setCity ("杭州市");
        //params.setMaxLimit ("1233");
        //params.setMinLimit ("90");
        //params.setProductType ("01");
        List<ProductListQueryResultModel> list = productMapper.queryMostOverDueProductList (params);
        for ( ProductListQueryResultModel productListQueryRespModel : list ) {
            System.out.println ("------------begin-----------------");
            System.out.println (" productName="+productListQueryRespModel.getProductName ());
            System.out.println (" overdueTime= "+new SimpleDateFormat ("yyyy-MM-dd").format (productListQueryRespModel.getOverdueTime()));
            System.out.println ("------------end-----------------");
        }
    }
    
    /**
     * 
     *@Description: 查询附近的产品 
     *@Author: 李焱生
     *@Since: 2015年5月11日下午5:45:39
     */
    //@Test
    public void testQueryMostNearProductList(){
        ProductListQueryParamModel params = new ProductListQueryParamModel ();
        params.setCity ("杭州市");
        //params.setMaxLimit ("1233");
        //params.setMinLimit ("90");
        params.setDistance ("5000");
        params.setLatitude ("22.299439");
        params.setLongtitude ("6378.138");
        //params.setProductType ("01");
        List<ProductListQueryResultModel> list = productMapper.queryMostNearProductList (params);
        for ( ProductListQueryResultModel productListQueryRespModel : list ) {
            System.out.println ("------------begin-----------------");
            System.out.println (" productName="+productListQueryRespModel.getProductName ());
            System.out.println (" distance="+productListQueryRespModel.getDistance());
            System.out.println (" overdueTime= "+new SimpleDateFormat ("yyyy-MM-dd").format (productListQueryRespModel.getOverdueTime()));
            System.out.println ("------------end-----------------");
        } 
    }
    
    /**
     * 
     *@Description: 查询收益最高的产品信息 
     *@Author: 李焱生
     *@Since: 2015年5月11日下午7:38:50
     */
    //@Test
    public void testQueryMostIncomeProductList()
    {
        ProductListQueryParamModel params = new ProductListQueryParamModel ();
        params.setCity ("杭州市");
        //params.setMaxLimit ("1233");
        //params.setMinLimit ("90");
        //params.setProductType ("01");
        List<ProductListQueryResultModel> list = productMapper.queryMostIncomeProductList(params);
        for ( ProductListQueryResultModel productListQueryRespModel : list ) {
            System.out.println ("------------begin-----------------");
            System.out.println (" productName="+productListQueryRespModel.getProductName ());
            System.out.println (" year_rate_income=" + productListQueryRespModel.getYearIncomeRate ());
            System.out.println (" overdueTime= "+new SimpleDateFormat ("yyyy-MM-dd").format (productListQueryRespModel.getOverdueTime()));
            System.out.println ("------------end-----------------");
        }
    }
    
    
    /**
     * 
     *@Description: 产品收藏
     *@Author: 李焱生
     *@Since: 2015年5月11日下午11:05:12
     */
    //@Test
    public void testCollectProduct(){
        ProductCollectSaveDaoModel model = new ProductCollectSaveDaoModel();
        model.setCollectionTime (new Date());
        model.setProductId ("2");
        model.setUserId ("1");
        productMapper.collectProduct (model);
    }

}
