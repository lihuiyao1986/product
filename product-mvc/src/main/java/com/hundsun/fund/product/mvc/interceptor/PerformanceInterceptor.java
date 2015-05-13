/**
 * @Title: PerformanceInterceptor.java
 * @Package com.hundsun.fund.product.mvc.interceptor
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月2日 下午9:32:05
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StopWatch;

/**
 *@Description:监控性能的拦截器
 *@Author:李焱生
 *@Since:2015年5月2日下午9:32:05  
 */

public class PerformanceInterceptor extends BaseHandlerInterceptorAdapter {

    private StopWatch watch;

    /**
     *@Description: TODO(这里用一句话描述这个方法的作用) 
     *@Author: 李焱生
     *@Since: 2015年5月2日下午9:33:04
     *@param request
     *@param response
     *@param handler
     *@return
     *@throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
        watch = new StopWatch ();
        String url = request.getRequestURL ().toString ();
        watch.start (url);
        return super.preHandle (request, response, handler);
    }

    /**
     *@Description: TODO(这里用一句话描述这个方法的作用) 
     *@Author: 李焱生
     *@Since: 2015年5月3日上午11:39:06
     *@param request
     *@param response
     *@param handler
     *@param ex
     *@throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,Exception ex) throws Exception{
        if (watch != null) {
            watch.stop ();
            logger.debug (watch.prettyPrint ());
        }
        super.afterCompletion (request, response, handler, ex);
    }

}
