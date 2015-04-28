/**
 * @Title: FastJsonpHttpMessageConverter.java
 * @Package com.hundsun.fund.product.mvc.viewResolver
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月27日 下午11:38:34
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.converter;

import java.io.IOException;
import java.io.PrintStream;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年4月27日下午11:38:34  
 */

public class FastJsonpHttpMessageConverter extends FastJsonHttpMessageConverter {

    /**
     *@Description: TODO(这里用一句话描述这个方法的作用) 
     *@Author: 李焱生
     *@Since: 2015年4月27日下午11:38:41
     *@param obj
     *@param outputMessage
     *@throws IOException
     *@throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(Object obj,HttpOutputMessage outputMessage) throws IOException,HttpMessageNotWritableException{
        String jsonpCallback = null;
        RequestAttributes reqAttrs = RequestContextHolder.currentRequestAttributes ();
        if (reqAttrs instanceof ServletRequestAttributes) 
        {
            jsonpCallback = ((ServletRequestAttributes) reqAttrs).getRequest ().getParameter ("callback");
        }
        if (!StringUtils.isEmpty (jsonpCallback)) 
        {
            new PrintStream (outputMessage.getBody ()).print (jsonpCallback + "(");
        }
        super.writeInternal (obj, outputMessage);
        if (!StringUtils.isEmpty (jsonpCallback)) 
        {
            new PrintStream (outputMessage.getBody ()).println (");");
        }
    }

}
