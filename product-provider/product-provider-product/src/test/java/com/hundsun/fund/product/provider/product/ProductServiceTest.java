/**
 *@Title: ProductServiceTest.java 
 *@Package com.hundsun.fund.product.provider.product 
 *@Description: TODO(用一句话描述该文件做什么) 
 *@author A18ccms A18ccms_gmail_com   
 *@date 2015年5月9日 下午10:58:48 
 *@Copyright:Copyright (c) 
 *@Company:whty李焱生
 *@version V1.0 
 */
package com.hundsun.fund.product.provider.product;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hundsun.fund.product.api.product.model.RecommendQueryReqAPIModel;
import com.hundsun.fund.product.api.product.model.RecommendQueryRespAPIModel;
import com.hundsun.fund.product.api.product.service.IProductService;
import com.hundsun.fund.product.commons.utils.Constant;



/**
 *@Description:测试产品相关的service
 *@Author:李焱生
 *@Since:2015年5月9日下午10:58:48  
 */
public class ProductServiceTest extends BaseTest{

    @Autowired
    private IProductService productService;
    
    /**
     * 
     *@Description: 推荐产品查询
     *@Author: 李焱生
     *@Since: 2015年5月9日下午11:02:10
     */
    @Test
    public void testQueryRecommend()
    {
        RecommendQueryReqAPIModel params = new RecommendQueryReqAPIModel();
        params.setIsPage (Constant.IS_PAGING_YES);
        params.setPageNo (1);
        params.setPageSize (3);
        RecommendQueryRespAPIModel respBean = productService.queryRecommend (params);
        logger.debug (respBean.toString ());
    }
}
