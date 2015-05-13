package com.hundsun.fund.product.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.hundsun.fund.product.api.user.model.UserInfoQueryByUuidAPIReqModel;
import com.hundsun.fund.product.api.user.model.UserInfoQueryByUuidAPIRespModel;
import com.hundsun.fund.product.api.user.service.IUserService;
import com.hundsun.fund.product.commons.exception.BusinessException;
import com.hundsun.fund.product.commons.utils.APPUtils;
import com.hundsun.fund.product.commons.utils.Constant;
import com.hundsun.fund.product.commons.utils.StringUtil;

/**
 *@Description:用户有效性拦截器
 *@Author:李焱生
 *@Since:2014年10月30日下午2:01:23
 */
public class LoginInterceptor extends BaseHandlerInterceptorAdapter {

    @Autowired
    private IUserService userService;

    /**
     *@Description:将用户信息设置到request中，供后续使用
     *@Author: 李焱生
     *@Since: 2014年10月31日下午4:37:40
     *@param request
     *@param response
     *@param handle
     *@return
     *@throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handle){
        String uuid = StringUtil.trimNull (request.getParameter (Constant.REQUEST_UUID));
        UserInfoQueryByUuidAPIReqModel params = new UserInfoQueryByUuidAPIReqModel ();
        params.setUuid (uuid);
        UserInfoQueryByUuidAPIRespModel resultBean = userService.queryUserInfoByUuid (params);
        if (!APPUtils.isAPISuccess (resultBean)) {
            throw new BusinessException (resultBean.getCode (),resultBean.getMessage (),resultBean.getMessage ());
        } else {
            request.setAttribute (Constant.USER_INFO_KEY_IN_REDIS, resultBean.getUserInfo ());
        }
        return true;
    }
}
