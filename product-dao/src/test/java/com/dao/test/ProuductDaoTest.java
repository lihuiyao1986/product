/**
 *@Title: ProuductDaoTest.java 
 *@Package com.dao.test 
 *@Description: TODO(用一句话描述该文件做什么) 
 *@author A18ccms A18ccms_gmail_com   
 *@date 2015年5月9日 下午10:14:21 
 *@Copyright:Copyright (c) 
 *@Company:whty李焱生
 *@version V1.0 
 */
package com.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.hundsun.fund.product.dao.model.ProductDaoModel;
import com.hundsun.fund.product.dao.service.ProductDao;



/**
 *@Description:productDao测试
 *@Author:李焱生
 *@Since:2015年5月9日下午10:14:21  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/*.xml")
public class ProuductDaoTest extends BaseTest {

    @Autowired
    private ProductDao productDao;
    
    @Test
    public void testQueryRecommendProductListByPage()
    {
        PageInfo<ProductDaoModel> pageList = productDao.queryRecommendProductListByPage (null, null, 1, 2);
        logger.debug (pageList);
    }
    
}
