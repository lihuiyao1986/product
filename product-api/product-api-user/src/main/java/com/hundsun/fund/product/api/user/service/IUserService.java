/**
 * @Title: IUserService.java
 * @Package com.hundsun.fund.product.api.user
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月27日 下午4:46:57
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.api.user.service;

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
import com.hundsun.fund.product.api.user.model.UserInfoQueryInRedisAPIReqParam;
import com.hundsun.fund.product.api.user.model.UserInfoQueryInRedisAPIRespParam;
import com.hundsun.fund.product.api.user.model.UserLoginAPIReqParam;
import com.hundsun.fund.product.api.user.model.UserLoginAPIRespParam;

/**
 *@Description:用户service
 *@Author:李焱生
 *@Since:2015年4月27日下午4:46:57  
 */
public interface IUserService {

    /**
     * 
     *@Description: 编辑用户信息 
     *@Author: 李焱生
     *@Since: 2015年5月10日下午3:14:31
     *@param params
     *@return
     */
    public UserInfoEditAPIRespModel editUserInfo(UserInfoEditAPIReqModel params);

    /**
     * 
     *@Description: 根据uuid查询用户的信息
     *@Author: 李焱生
     *@Since: 2015年5月10日下午2:44:47
     *@param params
     *@return
     */
    public UserInfoQueryByUuidAPIRespModel queryUserInfoByUuid(UserInfoQueryByUuidAPIReqModel params);

    /**
     * 
     *@Description: 用户登录接口
     *@Author: 李焱生
     *@Since: 2015年5月6日上午9:33:32
     *@param params
     *@return
     */
    public UserLoginAPIRespParam login(UserLoginAPIReqParam params);

    /**
     *@Description: 根据token从redis中获取用户信息 
     *@Author: 李焱生
     *@Since: 2015年5月7日上午8:45:07
     *@param token
     *@return
     */
    public UserInfoQueryInRedisAPIRespParam getUserInfoFromRedisByToken(UserInfoQueryInRedisAPIReqParam params);

    /**
     *@Description: 根据用户的id查询用户的爱好信息 
     *@Author: 李焱生
     *@Since: 2015年5月7日下午4:50:52
     *@param hobbyParams
     *@return
     */
    public UserHobbyQueryAPIRespParam queryUserHobbyByUserId(UserHobbyQueryAPIReqParam hobbyParams);

    /**
     *@Description: 编辑用户的爱好信息
     *@Author: 李焱生
     *@Since: 2015年5月7日下午11:17:14
     *@param reqParam
     *@return
     */
    public UserHobbyEditAPIRespParam editUserHobbyInfo(UserHobbyEditAPIReqParam reqParam);

    /**
     *@Description: 保存用户的反馈信息
     *@Author: 李焱生
     *@Since: 2015年5月8日下午1:23:03
     *@param reqParam
     *@return
     */
    public UserFeedbackSaveRespAPIParam saveUserFeedbackInfo(UserFeedbackSaveReqAPIParam reqParam);

    /**
     * 
     *@Description: 根据用户id查询用户的反馈信息 
     *@Author: 李焱生
     *@Since: 2015年5月8日下午11:12:20
     *@param params
     *@return
     */
    public UserFeedbackQueryRespAPIParam queryFeedbackInfoByUserId(UserFeedbackQueryReqAPIParam params);

    /**
     *@Description: 根据反馈信息id查询用户的反馈信息 
     *@Author: 李焱生
     *@Since: 2015年5月9日上午11:40:28
     *@param reqParam
     *@return
     */
    public UserFeedbackQueryByIdRespAPIModel queryUserFeedbackInfoByFeedBackId(UserFeedbackQueryByIdReqAPIModel reqParam);
    
    
    /**
     * 
     *@Description: 保存用户的电话记录
     *@Author: 李焱生
     *@Since: 2015年5月11日下午7:53:00
     *@param params
     *@return
     */
    public UserCallRecordSaveAPIRespParam saveUserCallRecord(UserCallRecordSaveAPIReqParam params);
}
