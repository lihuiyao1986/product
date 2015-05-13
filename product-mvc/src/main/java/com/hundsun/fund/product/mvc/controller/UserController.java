/**
 * @Title: UserController.java
 * @Package com.hundsun.fund.product.mvc.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月27日 下午3:24:28
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hundsun.fund.product.api.user.model.UserCallRecordSaveAPIReqParam;
import com.hundsun.fund.product.api.user.model.UserCallRecordSaveAPIRespParam;
import com.hundsun.fund.product.api.user.model.UserFeedbackQueryByIdReqAPIModel;
import com.hundsun.fund.product.api.user.model.UserFeedbackQueryByIdRespAPIModel;
import com.hundsun.fund.product.api.user.model.UserFeedbackQueryReqAPIParam;
import com.hundsun.fund.product.api.user.model.UserFeedbackQueryRespAPIParam;
import com.hundsun.fund.product.api.user.model.UserFeedbackSaveReqAPIParam;
import com.hundsun.fund.product.api.user.model.UserFeedbackSaveRespAPIParam;
import com.hundsun.fund.product.api.user.model.UserHobbyEditAPIReqParam;
import com.hundsun.fund.product.api.user.model.UserHobbyEditAPIRespParam;
import com.hundsun.fund.product.api.user.model.UserHobbyQueryAPIReqParam;
import com.hundsun.fund.product.api.user.model.UserHobbyQueryAPIRespParam;
import com.hundsun.fund.product.api.user.model.UserInfoEditAPIReqModel;
import com.hundsun.fund.product.api.user.model.UserInfoEditAPIRespModel;
import com.hundsun.fund.product.api.user.model.UserInfoQueryByUuidAPIReqModel;
import com.hundsun.fund.product.api.user.model.UserInfoQueryByUuidAPIRespModel;
import com.hundsun.fund.product.api.user.model.UserLoginAPIReqParam;
import com.hundsun.fund.product.api.user.model.UserLoginAPIRespParam;
import com.hundsun.fund.product.api.user.service.IUserService;
import com.hundsun.fund.product.commons.exception.BusinessException;
import com.hundsun.fund.product.commons.utils.APPUtils;
import com.hundsun.fund.product.commons.utils.Constant;
import com.hundsun.fund.product.commons.utils.Errorcode;
import com.hundsun.fund.product.commons.utils.MD5;
import com.hundsun.fund.product.commons.utils.StringUtil;
import com.hundsun.fund.product.dao.model.UserInfoDaoModel;
import com.hundsun.fund.product.mvc.model.user.UserCallRecordSaveReqParam;
import com.hundsun.fund.product.mvc.model.user.UserCallRecordSaveRespParam;
import com.hundsun.fund.product.mvc.model.user.UserFeedbackQueryByIdReqModel;
import com.hundsun.fund.product.mvc.model.user.UserFeedbackQueryByIdRespModel;
import com.hundsun.fund.product.mvc.model.user.UserFeedbackQueryReqModel;
import com.hundsun.fund.product.mvc.model.user.UserFeedbackQueryRespModel;
import com.hundsun.fund.product.mvc.model.user.UserFeedbackSaveReqModel;
import com.hundsun.fund.product.mvc.model.user.UserFeedbackSaveRespModel;
import com.hundsun.fund.product.mvc.model.user.UserHobbyEditReqModel;
import com.hundsun.fund.product.mvc.model.user.UserHobbyEditRespModel;
import com.hundsun.fund.product.mvc.model.user.UserHobbyQueryReqModel;
import com.hundsun.fund.product.mvc.model.user.UserHobbyQueryRespModel;
import com.hundsun.fund.product.mvc.model.user.UserInfoEditReqModel;
import com.hundsun.fund.product.mvc.model.user.UserInfoEditRespModel;
import com.hundsun.fund.product.mvc.model.user.UserInfoQueryByUUIDReqModel;
import com.hundsun.fund.product.mvc.model.user.UserInfoQueryByUUIDRespModel;
import com.hundsun.fund.product.mvc.model.user.UserLoginReqModel;
import com.hundsun.fund.product.mvc.model.user.UserLoginRespModel;

/**
 *@Description:用户对应的控制器类
 *@Author:李焱生
 *@Since:2015年4月27日下午3:24:28  
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    /**
     * 
     *@Description: 根据用户的uuid查询用户的信息 
     *@Author: 李焱生
     *@Since: 2015年5月11日下午8:52:38
     *@param params
     *@return
     */
    @ResponseBody
    @RequestMapping("/userinfo_query_by_uuid.json")
    public UserInfoQueryByUUIDRespModel userInfoQueryByUUID(UserInfoQueryByUUIDReqModel params){
        String uuid = StringUtil.trimNull (params.getUuid ());
        if (StringUtil.isEmpty (uuid)) { throw new BusinessException (Errorcode.DEFAULT_ERROR_CODE,"uuid为空"); }
        UserInfoQueryByUuidAPIReqModel reqParam = new UserInfoQueryByUuidAPIReqModel ();
        reqParam.setUuid (uuid);
        UserInfoQueryByUuidAPIRespModel respBean = userService.queryUserInfoByUuid (reqParam);
        UserInfoQueryByUUIDRespModel resultBean = new UserInfoQueryByUUIDRespModel ();
        resultBean.setCode (respBean.getCode ());
        resultBean.setMessage (respBean.getMessage ());
        if (APPUtils.isAPISuccess (respBean)) {
            resultBean.setUserInfo (respBean.getUserInfo ());
        }
        return resultBean;
    }

    /**
     * 
     *@Description: 编辑用户的信息
     *@Author: 李焱生
     *@Since: 2015年5月11日下午9:00:36
     *@param params
     *@return
     */
    @ResponseBody
    @RequestMapping("/userinfo_edit.json")
    public UserInfoEditRespModel editUserInfo(UserInfoEditReqModel params){
        UserInfoEditAPIReqModel reqParam = new UserInfoEditAPIReqModel ();
        UserInfoDaoModel userInfo = new UserInfoDaoModel ();
        userInfo.setAccount (StringUtil.trimNull (params.getAccount ()));
        userInfo.setAddress (StringUtil.trimNull (params.getAddress ()));
        userInfo.setEmail (StringUtil.trimNull (params.getEmail ()));
        userInfo.setIcon (StringUtil.trimNull (params.getIcon ()));
        userInfo.setMobile (StringUtil.trimNull (params.getMobile ()));
        userInfo.setName (StringUtil.trimNull (params.getName ()));
        userInfo.setPwd (MD5.encodeByMD5 (StringUtil.trimNull (params.getPwd ())));
        userInfo.setQq (StringUtil.trimNull (params.getQq ()));
        userInfo.setUuid (StringUtil.trimNull (params.getUuid ()));
        userInfo.setWebchat (StringUtil.trimNull (params.getWebchat ()));
        reqParam.setUserInfo (userInfo);
        UserInfoEditAPIRespModel respBean = userService.editUserInfo (reqParam);
        UserInfoEditRespModel resultBean = new UserInfoEditRespModel ();
        resultBean.setCode (respBean.getCode ());
        resultBean.setMessage (respBean.getMessage ());
        resultBean.setUserInfo (respBean.getUserInfo ());
        return resultBean;
    }

    /**
     * 
     *@Description: 保存用户的电话记录 
     *@Author: 李焱生
     *@Since: 2015年5月11日下午9:40:40
     *@param params
     *@return
     */
    @ResponseBody
    @RequestMapping("/phone_record_save.json")
    public UserCallRecordSaveRespParam savePhoneRecord(UserCallRecordSaveReqParam params,HttpServletRequest request){
        UserInfoDaoModel userInfo = (UserInfoDaoModel) request.getAttribute (Constant.USER_INFO_KEY_IN_REDIS);
        UserCallRecordSaveAPIReqParam reqParam = new UserCallRecordSaveAPIReqParam ();
        reqParam.setUserId (userInfo.getId ());
        reqParam.setPlannerId (StringUtil.trimNull (params.getPlannerId ()));
        UserCallRecordSaveAPIRespParam respBean = userService.saveUserCallRecord (reqParam);
        UserCallRecordSaveRespParam result = new UserCallRecordSaveRespParam ();
        result.setCode (respBean.getCode ());
        result.setMessage (respBean.getMessage ());
        return result;
    }

    /**
     *@Description: 用户登录
     *@Author: 李焱生
     *@Since: 2015年5月6日上午10:17:37
     *@param params
     *@return
     */
    @ResponseBody
    @RequestMapping("/login.json")
    public UserLoginRespModel login(UserLoginReqModel params){

        // 1.出参
        UserLoginRespModel resultBean = new UserLoginRespModel ();

        // 2.校验登录参数
        validateLoginParams (params);

        // 3.登录
        UserLoginAPIReqParam loginParams = new UserLoginAPIReqParam ();
        loginParams.setAccount (StringUtil.trimNull (params.getAccount ()));
        loginParams.setPwd (MD5.encodeByMD5 (StringUtil.trimNull (params.getPwd ())));
        loginParams.setUseragent (StringUtil.trimNull (params.getUseragent ()));
        UserLoginAPIRespParam loginRespRs = userService.login (loginParams);
        resultBean.setCode (loginRespRs.getCode ());
        resultBean.setMessage (loginRespRs.getMessage ());
        if (APPUtils.isAPISuccess (loginRespRs)) {
            resultBean.setLoginUser (loginRespRs.getUserInfo ());
            resultBean.setToken (loginRespRs.getToken ());
        }
        return resultBean;
    }

    /**
     *@Description: 校验登录参数
     *@Author: 李焱生
     *@Since: 2015年5月6日上午9:21:59
     *@param params
     */
    private void validateLoginParams(UserLoginReqModel params){
        String pwd = StringUtil.trimNull (params.getPwd ());
        String account = StringUtil.trimNull (params.getAccount ());
        if (StringUtils.isEmpty (account) || StringUtil.isEmpty (pwd)) { throw new BusinessException (Errorcode.LOGIN_PWD_OR_ACCOUNT_IS_NULL,"账号或密码为空"); }
    }

    /**
     * 
     *@Description:用户爱好查询
     *@Author: 李焱生
     *@Since: 2015年5月7日下午4:18:34
     *@param params
     *@return
     */
    @ResponseBody
    @RequestMapping("/hobby_query.json")
    public UserHobbyQueryRespModel userHobbyQuery(UserHobbyQueryReqModel params,HttpServletRequest request){

        // 1.从数据库中查询用户的爱好信息
        UserInfoDaoModel userInfo = (UserInfoDaoModel) request.getAttribute (Constant.USER_INFO_KEY_IN_REDIS);
        String userId = userInfo.getId ();
        UserHobbyQueryAPIReqParam hobbyParams = new UserHobbyQueryAPIReqParam ();
        hobbyParams.setUserId (userId);
        UserHobbyQueryAPIRespParam hobbyResult = userService.queryUserHobbyByUserId (hobbyParams);

        // 2.返回结果
        UserHobbyQueryRespModel result = new UserHobbyQueryRespModel ();
        result.setCode (hobbyResult.getCode ());
        result.setMessage (hobbyResult.getMessage ());
        if (APPUtils.isAPISuccess (hobbyResult)) {
            result.setUserHobby (hobbyResult.getHobby ());
        }
        return result;
    }

    /**
     * 
     *@Description: 编辑用户的爱好信息 
     *@Author: 李焱生
     *@Since: 2015年5月7日下午11:02:21
     *@param params
     *@param request
     *@return
     */
    @ResponseBody
    @RequestMapping("/hobby_edit.json")
    public UserHobbyEditRespModel userHobbyEdit(UserHobbyEditReqModel params,HttpServletRequest request){
        UserHobbyEditAPIReqParam reqParam = new UserHobbyEditAPIReqParam ();
        UserInfoDaoModel userInfo = (UserInfoDaoModel) request.getAttribute (Constant.USER_INFO_KEY_IN_REDIS);
        reqParam.setAssest (params.getAssest ());
        reqParam.setHobbyId (params.getHobbyId ());
        reqParam.setLimit (params.getLimit ());
        reqParam.setMemo (params.getMemo ());
        reqParam.setRiskAbility (params.getRiskAbility ());
        reqParam.setUserId (userInfo.getId ());
        reqParam.setYearIncomeRate (params.getYearIncomeRate ());
        UserHobbyEditAPIRespParam resultBean = userService.editUserHobbyInfo (reqParam);
        UserHobbyEditRespModel result = new UserHobbyEditRespModel ();
        result.setCode (resultBean.getCode ());
        result.setMessage (resultBean.getMessage ());
        return result;
    }

    /**
     * 
     *@Description: 保存用户的反馈信息
     *@Author: 李焱生
     *@Since: 2015年5月8日下午12:56:14
     *@param params
     *@param request
     *@return
     */
    @ResponseBody
    @RequestMapping("/feedback_save.json")
    public UserFeedbackSaveRespModel saveFeedbackInfo(UserFeedbackSaveReqModel params,HttpServletRequest request){
        UserInfoDaoModel userInfo = (UserInfoDaoModel) request.getAttribute (Constant.USER_INFO_KEY_IN_REDIS);
        UserFeedbackSaveReqAPIParam reqParam = new UserFeedbackSaveReqAPIParam ();
        reqParam.setEmail (StringUtil.trimNull (params.getEmail (), userInfo.getEmail ()));
        reqParam.setFeedbackInfo (StringUtil.trimNull (params.getFeedbackInfo ()));
        reqParam.setFeedbackTime (new Date ());
        reqParam.setMemo (StringUtil.trimNull (params.getMemo ()));
        reqParam.setMobile (StringUtil.trimNull (params.getMobile (), userInfo.getMobile ()));
        reqParam.setUserId (userInfo.getId ());
        UserFeedbackSaveRespAPIParam result = userService.saveUserFeedbackInfo (reqParam);
        UserFeedbackSaveRespModel resultBean = new UserFeedbackSaveRespModel ();
        resultBean.setCode (result.getCode ());
        resultBean.setMessage (result.getMessage ());
        return resultBean;
    }

    /**
     * 
     *@Description:根据用户的id查询反馈信息
     *@Author: 李焱生
     *@Since: 2015年5月8日下午11:42:18
     *@param params
     *@param request
     *@return
     */
    @ResponseBody
    @RequestMapping("/feedback_query_by_userid.json")
    public UserFeedbackQueryRespModel queryUserFeedbackInfoByUserId(UserFeedbackQueryReqModel params,HttpServletRequest request){
        UserInfoDaoModel userInfo = (UserInfoDaoModel) request.getAttribute (Constant.USER_INFO_KEY_IN_REDIS);
        UserFeedbackQueryReqAPIParam reqParam = new UserFeedbackQueryReqAPIParam ();
        reqParam.setFeedbackId (StringUtil.trimNull (params.getFeedbackId ()));
        reqParam.setIsPage (StringUtil.trimNull (params.getIsPage ()));
        reqParam.setPageNo (params.getPageNo ());
        reqParam.setPageSize (params.getPageSize ());
        reqParam.setUserId (userInfo.getId ());
        UserFeedbackQueryRespAPIParam resultBean = userService.queryFeedbackInfoByUserId (reqParam);
        UserFeedbackQueryRespModel respBean = new UserFeedbackQueryRespModel ();
        respBean.setCode (resultBean.getCode ());
        respBean.setMessage (resultBean.getMessage ());
        if (APPUtils.isAPISuccess (resultBean)) {
            respBean.setFeedbackList (resultBean.getFeedbackList ());
            respBean.setIsPage (resultBean.getIsPage ());
            respBean.setPageList (resultBean.getPageList ());
        }
        return respBean;
    }

    /**
     * 
     *@Description:根据反馈信息id查询反馈信息
     *@Author: 李焱生
     *@Since: 2015年5月8日下午11:42:18
     *@param params
     *@param request
     *@return
     */
    @ResponseBody
    @RequestMapping("/feedback_query_by_id.json")
    public UserFeedbackQueryByIdRespModel queryUserFeedbackInfoByFeedBackId(UserFeedbackQueryByIdReqModel params,HttpServletRequest request){
        // 1.校验参数
        validateQueryUserFeedbackInfoByFeedBackIdParams (params);

        // 2.查询
        UserInfoDaoModel userInfo = (UserInfoDaoModel) request.getAttribute (Constant.USER_INFO_KEY_IN_REDIS);
        UserFeedbackQueryByIdReqAPIModel reqParam = new UserFeedbackQueryByIdReqAPIModel ();
        reqParam.setFeedbackId (StringUtil.trimNull (params.getFeedbackId ()));
        reqParam.setQueryReplyFlag (StringUtil.trimNull (params.getQueryReplyFlag ()));
        reqParam.setUserId (StringUtil.trimNull (userInfo.getId ()));
        UserFeedbackQueryByIdRespAPIModel result = userService.queryUserFeedbackInfoByFeedBackId (reqParam);
        UserFeedbackQueryByIdRespModel respBean = new UserFeedbackQueryByIdRespModel ();
        respBean.setCode (StringUtil.trimNull (result.getCode ()));
        respBean.setMessage (StringUtil.trimNull (result.getMessage ()));
        respBean.setFeedbackId (StringUtil.trimNull (result.getFeedbackId ()));
        respBean.setQueryReplyFlag (StringUtil.trimNull (result.getQueryReplyFlag (), UserFeedbackQueryByIdReqAPIModel.NOT_QUERY_REPLY_FLAG));
        if (APPUtils.isAPISuccess (result)) {
            respBean.setFeedbackInfo (result.getFeedbackInfo ());
            respBean.setReplyInfoList (result.getReplyInfoList ());
        }
        return respBean;
    }

    /**
     *@Description: 校验参数 
     *@Author: 李焱生
     *@Since: 2015年5月9日上午11:38:53
     *@param params
     */
    private void validateQueryUserFeedbackInfoByFeedBackIdParams(UserFeedbackQueryByIdReqModel params){
        String feedbackId = StringUtil.trimNull (params.getFeedbackId ());
        if (StringUtil.isEmpty (feedbackId)) { throw new BusinessException (Errorcode.DEFAULT_ERROR_CODE,"feedbackId参数为空","feedbackId参数为空"); }
    }

}
