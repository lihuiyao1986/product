/**
 * @Title: ExceptionHandler.java
 * @Package com.hundsun.fund.product.mvc.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月29日 下午9:07:06
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hundsun.fund.product.commons.exception.BaseException;
import com.hundsun.fund.product.commons.utils.Errorcode;
import com.hundsun.fund.product.commons.utils.StringUtil;
import com.hundsun.fund.product.mvc.model.base.BaseRespModel;

/**
 *@Description:处理所有的异常
 *@Author:李焱生
 *@Since:2015年4月29日下午9:07:06  
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseRespModel handleException(Exception ex,HttpServletRequest request){
        BaseRespModel model = new BaseRespModel ();
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext (request.getServletContext ());
        String errorcode = Errorcode.DEFAULT_ERROR_CODE;
        String errorMsg = "";
        if (ex instanceof BaseException) {
            BaseException baseException = (BaseException) ex;
            errorcode = StringUtil.trimNull (baseException.getErrorcode ());
            errorMsg = StringUtil.trimNull (baseException.getErrormsg (), baseException.getDefaultmsg ());
            errorMsg = applicationContext.getMessage (errorcode, baseException.getArgs (), errorMsg, Locale.getDefault ());
        } else {
            errorMsg = applicationContext.getMessage (errorcode, null, "服务器忙，稍后重试", Locale.getDefault ());
        }
        model.setCode (errorcode);
        model.setMessage (errorMsg);
        return model;
    }

}
