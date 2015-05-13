package com.hundsun.fund.product.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hundsun.fund.product.commons.exception.BusinessException;
import com.hundsun.fund.product.commons.utils.Constant;
import com.hundsun.fund.product.commons.utils.Errorcode;
import com.hundsun.fund.product.commons.utils.MD5;
import com.hundsun.fund.product.mvc.model.base.BaseReqModel;

/**
 *@Description:请求有效性拦截器
 *@Author:李焱生
 *@Since:2014年10月30日下午2:08:22
 */
public class RequestInterceptor extends BaseHandlerInterceptorAdapter {

    /**
     *@Description: http请求合法性校验
     *@Author: 李焱生
     *@Since: 2014年10月31日下午4:35:09
     *@param request
     *@param response
     *@param handler
     *@return
     *@throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler){
        // 请求数据
        String random = request.getParameter (Constant.REQUEST_RANDOMONCE);
        String version = request.getParameter (Constant.REQUEST_VERSION);
        String timestamp = request.getParameter (Constant.REQUEST_TIMESTAMP);
        String token = request.getParameter (Constant.REQUEST_TOKEN);
        String useragent = request.getParameter (Constant.REQUEST_USER_AGENT);
        String uuid = request.getParameter (Constant.REQUEST_UUID);
        String url = request.getParameter (Constant.REQUEST_URL);
        String signature = request.getParameter (Constant.REQUEST_SIGNATURE);
        String source = request.getParameter (Constant.REQUEST_SOURCE);
        //创建对象
        BaseReqModel reqModel = new BaseReqModel ();
        reqModel.setRandom (random);
        reqModel.setSign (signature);
        reqModel.setSource (source);
        reqModel.setTimestamp (timestamp);
        reqModel.setToken (token);
        reqModel.setUrl (url);
        reqModel.setUseragent (useragent);
        reqModel.setUuid (uuid);
        reqModel.setVersion (version);
        String MD5String = MD5.encodeByMD5 (MD5.encodeByMD5 (reqModel.toString ()) + MD5.encodeByMD5 (Constant.SECRETKEY));
        if (!StringUtils.equals (MD5String, signature)) {
            throw new BusinessException (Errorcode.ILLEGAL_REQ_CODE, "请求非法");
        } 
        logger.info ("http合法性校验,不通过");
        return true;
    }

}
