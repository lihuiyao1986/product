/**
 *@Title: CommonMapper.java 
 *@Package com.hundsun.fund.product.dao.mapper 
 *@Description: TODO(用一句话描述该文件做什么) 
 *@author A18ccms A18ccms_gmail_com   
 *@date 2015年5月12日 下午9:09:02 
 *@Copyright:Copyright (c) 
 *@Company:whty李焱生
 *@version V1.0 
 */
package com.hundsun.fund.product.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hundsun.fund.product.dao.model.DictDaoDaoModel;



/**
 *@Description:公共表中的操作
 *@Author:李焱生
 *@Since:2015年5月12日下午9:09:02  
 */
public interface CommonMapper extends BaseMapper {

    /**
     * 
     *@Description: 根据字典代码查询对应的字典
     *@Author: 李焱生
     *@Since: 2015年5月12日下午9:13:29
     *@param code
     *@return
     */
    public List<DictDaoDaoModel> queryDictByCode(@Param("dictCode") String dictCode);
}
