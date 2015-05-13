/**
 * @Title: CommonMapperTest.java
 * @Package com.dao.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月12日 下午9:22:27
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.dao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hundsun.fund.product.dao.mapper.CommonMapper;
import com.hundsun.fund.product.dao.model.DictDaoDaoModel;

/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年5月12日下午9:22:27  
 */
public class CommonMapperTest extends BaseTest {

    @Autowired
    private CommonMapper commonMapper;

    @Test
    public void testDictQueryByCode(){
        List<DictDaoDaoModel> list = commonMapper.queryDictByCode ("1");
        for ( DictDaoDaoModel dictDaoDaoModel : list ) {
              System.out.println ("dictCode=" + dictDaoDaoModel.getDictCode ());
              System.out.println ("dictName=" + dictDaoDaoModel.getDictName ());
              System.out.println ("dictValue=" + dictDaoDaoModel.getDictValue ());
        }
    }

}
