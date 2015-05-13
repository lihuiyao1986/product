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
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.hundsun.fund.product.commons.utils.StringUtil;
import com.hundsun.fund.product.mvc.model.base.BaseRespModel;

/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年4月27日下午11:38:34  
 */

public class FastJsonpHttpMessageConverter extends FastJsonHttpMessageConverter {

    public static final Logger logger = Logger.getLogger (FastJsonpHttpMessageConverter.class.getName ());

    @Override
    protected void writeInternal(Object obj,HttpOutputMessage outputMessage) throws IOException,HttpMessageNotWritableException{
        String jsonpCallback = null;
        RequestAttributes reqAttrs = RequestContextHolder.currentRequestAttributes ();
        HttpServletRequest request = ((ServletRequestAttributes) reqAttrs).getRequest ();
        if (reqAttrs instanceof ServletRequestAttributes) {
            jsonpCallback = request.getParameter ("callback");
        }
        if (StringUtil.isNotEmpty (jsonpCallback)) {
            new PrintStream (outputMessage.getBody ()).print (jsonpCallback + "(");
        }
        Object respObj = obj;
        if (obj instanceof BaseRespModel) {
            BaseRespModel respBean = (BaseRespModel) obj;
            String code = StringUtil.trimNull (respBean.getCode (), "9999");
            String message = StringUtil.trimNull (respBean.getMessage (), "服务器忙，稍后重试");
            WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext (request.getServletContext ());
            message = applicationContext.getMessage (code, null, message, Locale.getDefault ());
            respBean.setCode (code);
            respBean.setMessage (message);
            respObj = respBean;
        }
        super.writeInternal (respObj, outputMessage);
        if (StringUtil.isNotEmpty (jsonpCallback)) {
            new PrintStream (outputMessage.getBody ()).println (");");
        }
    }

}
