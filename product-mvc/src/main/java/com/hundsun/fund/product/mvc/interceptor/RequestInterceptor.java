package com.hundsun.fund.product.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *@Description:请求有效性拦截器
 *@Author:李焱生
 *@Since:2014年10月30日下午2:08:22
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    /**
     *@Description: http请求合法性校验
     *@Author: 张聪
     *@Since: 2014年10月31日下午4:35:09
     *@param request
     *@param response
     *@param handler
     *@return
     *@throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler){
        return true;
    }

}
