package com.hundsun.fund.product.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *@Description:用户有效性拦截器
 *@Author:李焱生
 *@Since:2014年10月30日下午2:01:23
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private Logger log = LoggerFactory.getLogger (LoginInterceptor.class);

    /**
     *@Description:用户是否登录校验
     *@Author: 张聪
     *@Since: 2014年10月31日下午4:37:40
     *@param request
     *@param response
     *@param arg2
     *@return
     *@throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handle){
        log.info ("loginInterceptor........");
        return true;
    }
}
