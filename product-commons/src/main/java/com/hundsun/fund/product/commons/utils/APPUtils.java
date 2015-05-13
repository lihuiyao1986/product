/**
 *@Title: APPUtils.java 
 *@Package com.hundsun.fund.product.commons.utils 
 *@Description: TODO(用一句话描述该文件做什么) 
 *@author A18ccms A18ccms_gmail_com   
 *@date 2015年5月7日 下午4:38:53 
 *@Copyright:Copyright (c) 
 *@Company:whty李焱生
 *@version V1.0 
 */
package com.hundsun.fund.product.commons.utils;

import com.hundsun.fund.product.commons.model.BaseAPIRespParam;



/**
 *@Description:APPUtils
 *@Author:李焱生
 *@Since:2015年5月7日下午4:38:53  
 */
public class APPUtils {

    /**
     * 判断api是否调用成功
     *@Description: TODO(这里用一句话描述这个方法的作用) 
     *@Author: 李焱生
     *@Since: 2015年5月6日上午10:04:51
     *@param params
     *@return
     */
    public static boolean isAPISuccess(BaseAPIRespParam params)
    {
        return params!=null && Errorcode.DEFAULT_SUCCESS_CODE.equals (StringUtil.trimNull (params.getCode ()));
    }
}
