/**
 *@Title: BaseHandlerInterceptorAdapter.java 
 *@Package com.hundsun.fund.product.mvc.interceptor 
 *@Description: TODO(用一句话描述该文件做什么) 
 *@author A18ccms A18ccms_gmail_com   
 *@date 2015年5月5日 下午5:12:09 
 *@Copyright:Copyright (c) 
 *@Company:whty李焱生
 *@version V1.0 
 */
package com.hundsun.fund.product.mvc.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年5月5日下午5:12:09  
 */

public class BaseHandlerInterceptorAdapter extends HandlerInterceptorAdapter 
{
    protected Logger logger = Logger.getLogger (this.getClass ().getName ());
}
