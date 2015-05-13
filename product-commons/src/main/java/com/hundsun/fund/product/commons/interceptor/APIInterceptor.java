/**
 * @Title: APIInterceptor.java
 * @Package com.hundsun.fund.product.commons.interceptor
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月30日 上午11:22:31
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.commons.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.util.StopWatch;

import com.hundsun.fund.product.commons.exception.BaseException;
import com.hundsun.fund.product.commons.model.BaseAPIRespParam;
import com.hundsun.fund.product.commons.utils.Errorcode;
import com.hundsun.fund.product.commons.utils.StringUtil;

/**
 *@Description:api拦截对应的拦截器
 *@Author:李焱生
 *@Since:2015年4月30日上午11:22:31  
 */
public class APIInterceptor implements MethodInterceptor {

    private final static Logger logger = Logger.getLogger (APIInterceptor.class.getName ());

    @Override
    @SuppressWarnings("unchecked")
    public Object invoke(MethodInvocation invokeHandler) throws Throwable{
        Object result = null;
        BaseAPIRespParam response = null;
        logMethodInvokeBefore (invokeHandler);
        String methodname = invokeHandler.getMethod ().getName ();
        String clazzName = invokeHandler.getThis ().getClass ().getName ();
        String taskName = "method[" + methodname + "]clazz[" + clazzName + "]";
        StopWatch watch = new StopWatch (APIInterceptor.class.getSimpleName ());
        Class<? extends BaseAPIRespParam> returnType = (Class<? extends BaseAPIRespParam>) invokeHandler.getMethod ().getReturnType ();
        watch.start (taskName);
        try {
            Object invokeResult = invokeHandler.proceed ();
            if (invokeResult != null && invokeResult instanceof BaseAPIRespParam) {
                response = (BaseAPIRespParam) invokeResult;
                if (response != null) {
                    String code = StringUtil.trimNull (response.getCode (), Errorcode.DEFAULT_SUCCESS_CODE);
                    String message = StringUtil.trimNull (response.getMessage (), "调用接口成功");
                    response.setCode (code);
                    response.setMessage (message);
                }
            } else if (invokeResult == null) {
                response = new BaseAPIRespParam ();
                response.setCode (Errorcode.DEFAULT_ERROR_CODE);
                response.setMessage ("调用接口失败");
            }
        } catch (BaseException ex1) {
            response =returnType.newInstance ();
            response.setCode (ex1.getErrorcode ());
            response.setMessage (StringUtil.trimNull (ex1.getErrormsg (), ex1.getDefaultmsg ()));
        } catch (Exception ex2) {
            response =returnType.newInstance ();
            response.setCode (Errorcode.DEFAULT_ERROR_CODE);
            response.setMessage (StringUtil.trimNull (ex2.getMessage (), "调用接口失败"));
        } finally {
            result = response;
            logMethodInvokeAfter (invokeHandler);
            watch.stop ();
            logger.debug (watch.prettyPrint ());
        }
        return result;
    }

    /**
     *@Description: TODO(这里用一句话描述这个方法的作用) 
     *@Author: 李焱生
     *@Since: 2015年4月30日下午12:52:10
     *@param invokeHandler
     */
    private void logMethodInvokeAfter(MethodInvocation invokeHandler){
        Object[] objs = invokeHandler.getArguments ();
        String methodName = invokeHandler.getMethod ().getName ();
        String clazzName = invokeHandler.getThis ().getClass ().getName ();
        StringBuffer sb = new StringBuffer ();
        sb.append ("调用方法结束:");
        sb.append ("参数[");
        for ( Object obj : objs ) {
            sb.append (obj.toString ());
            sb.append (",");
        }
        sb.append ("]");
        sb.append ("方法[").append (methodName).append ("]");
        sb.append ("类[").append (clazzName).append ("]");
        logger.debug (sb.toString ());
    }

    /**
     *@Description: logMethodInvoke
     *@Author: 李焱生
     *@Since: 2015年4月30日上午11:31:15
     *@param invokeHandler
     */
    private void logMethodInvokeBefore(MethodInvocation invokeHandler){
        Object[] objs = invokeHandler.getArguments ();
        String methodName = invokeHandler.getMethod ().getName ();
        String clazzName = invokeHandler.getThis ().getClass ().getName ();
        StringBuffer sb = new StringBuffer ();
        sb.append ("开始调用方法:");
        sb.append ("参数[");
        for ( Object obj : objs ) {
            sb.append (obj.toString ());
            sb.append (",");
        }
        sb.append ("]");
        sb.append ("方法[").append (methodName).append ("]");
        sb.append ("类[").append (clazzName).append ("]");
        logger.debug (sb.toString ());
    }

}
