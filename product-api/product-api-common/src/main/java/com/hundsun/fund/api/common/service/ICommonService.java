/**
 *@Title: ICommonService.java 
 *@Package com.hundsun.fund.api.common.service 
 *@Description: TODO(用一句话描述该文件做什么) 
 *@author A18ccms A18ccms_gmail_com   
 *@date 2015年5月12日 下午8:48:20 
 *@Copyright:Copyright (c) 
 *@Company:whty李焱生
 *@version V1.0 
 */
package com.hundsun.fund.api.common.service;

import com.hundsun.fund.api.common.model.DictQueryByCodeAPIReqModel;
import com.hundsun.fund.api.common.model.DictQueryByCodeAPIRespModel;



/**
 *@Description:公共类接口
 *@Author:李焱生
 *@Since:2015年5月12日下午8:48:20  
 */
public interface ICommonService {

    /**
     * 
     *@Description: 根据code查询字典 
     *@Author: 李焱生
     *@Since: 2015年5月12日下午10:10:55
     *@param params
     *@return
     */
    public DictQueryByCodeAPIRespModel queryDictByCode(DictQueryByCodeAPIReqModel params);
}
