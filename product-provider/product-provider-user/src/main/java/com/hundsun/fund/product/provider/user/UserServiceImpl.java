/**
 * @Title: UserServiceImpl.java
 * @Package com.hundsun.fund.product.provider.user
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月27日 下午4:49:04
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.provider.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
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
import com.hundsun.fund.product.api.user.service.IUserService;
import com.hundsun.fund.product.commons.exception.APIException;
import com.hundsun.fund.product.commons.exception.BusinessException;
import com.hundsun.fund.product.commons.utils.Constant;
import com.hundsun.fund.product.commons.utils.Errorcode;
import com.hundsun.fund.product.commons.utils.MD5;
import com.hundsun.fund.product.commons.utils.StringUtil;
import com.hundsun.fund.product.commons.utils.UuidUtils;
import com.hundsun.fund.product.dao.mapper.UserMapper;
import com.hundsun.fund.product.dao.model.UserDeviceInfoDaoModel;
import com.hundsun.fund.product.dao.model.UserFeedBackInfoDaoModel;
import com.hundsun.fund.product.dao.model.UserFeenbackReplyDaoModel;
import com.hundsun.fund.product.dao.model.UserHobbyDaoModel;
import com.hundsun.fund.product.dao.model.UserInfoDaoModel;
import com.hundsun.fund.product.dao.model.UserLoginInfoDaoModel;
import com.hundsun.fund.product.dao.model.UserPhoneRecordDaoModel;
import com.hundsun.fund.product.dao.service.UserDao;
import com.hundsun.fund.provider.redis.client.RedisShardingClient;

/**
 *@Description:用户信息service
 *@Author:李焱生
 *@Since:2015年4月27日下午4:49:04  
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper          userMapper;

    @Autowired
    private UserDao             userDao;

    @Autowired
    private RedisShardingClient redisClient;

    /**
     * 
     *@Description: 根据uuid查询用户的信息 
     *@Author: 李焱生
     *@Since: 2015年5月10日下午2:44:47
     *@param params
     *@return
     */
    public UserInfoQueryByUuidAPIRespModel queryUserInfoByUuid(UserInfoQueryByUuidAPIReqModel params){
        String uuid = StringUtil.trimNull (params.getUuid ());
        UserInfoDaoModel userInfo = queryUserInfoByUUID (uuid);
        if (userInfo == null) { throw new APIException (Errorcode.USER_NOT_EXISTS,"用户账号不存在"); }
        UserInfoQueryByUuidAPIRespModel respBean = new UserInfoQueryByUuidAPIRespModel ();
        respBean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        respBean.setMessage ("查询成功");
        respBean.setUserInfo (userInfo);
        return respBean;
    }

    /**
     *@Description: 保存用户拨打电话的记录
     *@Author: 李焱生
     *@Since: 2015年5月11日下午7:53:25
     *@param params
     *@return
     */
    @Override
    public UserCallRecordSaveAPIRespParam saveUserCallRecord(UserCallRecordSaveAPIReqParam params){
        if (StringUtil.isEmpty (params.getPlannerId ()) || StringUtil.isEmpty (params.getUserId ())) { throw new APIException (
                Errorcode.USERID_OR_PLANNERID_IS_NULL,"用户id或理财师ID为空"); }
        UserPhoneRecordDaoModel model = new UserPhoneRecordDaoModel ();
        model.setCreateTime (new Date ());
        model.setPlannerId (StringUtil.trimNull (params.getPlannerId ()));
        model.setUserId (StringUtil.trimNull (params.getUserId ()));
        userMapper.saveUserCallRecord (model);
        UserCallRecordSaveAPIRespParam respBean = new UserCallRecordSaveAPIRespParam ();
        respBean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        respBean.setMessage ("调用接口成功");
        return respBean;
    }

    /**
     * 
     *@Description: 编辑用户信息 
     *@Author: 李焱生
     *@Since: 2015年5月10日下午3:14:31
     *@param params
     *@return
     */
    public UserInfoEditAPIRespModel editUserInfo(UserInfoEditAPIReqModel params){
        String uuid = StringUtil.trimNull (params.getUserInfo ().getUuid ());
        if (StringUtil.isEmpty (uuid)) { throw new APIException (Errorcode.UUID_IS_NULL,"uuid为空"); }
        UserInfoDaoModel userInfo = queryUserInfoByUUID (uuid);
        if (userInfo != null) {
            // 数据库存在，修改
            modifyUserInfoByUUID (params.getUserInfo ());
        } else {
            // 数据库不存在，新增
            saveUserInfo (params.getUserInfo ());
        }
        userInfo = userMapper.queryUserInfoByUUID (uuid);
        updateUserInfoInRedisByUUID (uuid, userInfo);
        UserInfoEditAPIRespModel respBean = new UserInfoEditAPIRespModel ();
        respBean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        respBean.setMessage ("修改成功");
        respBean.setUserInfo (userInfo);
        return respBean;
    }

    /**
     *@Description: 保存用户的信息
     *@Author: 李焱生
     *@Since: 2015年5月10日下午3:25:55
     *@param userInfo
     */
    private void saveUserInfo(UserInfoDaoModel userInfo){
        userMapper.saveUserInfo (userInfo);
    }

    /**
     *@Description: 根据uuid修改用户信息
     *@Author: 李焱生
     *@Since: 2015年5月10日下午3:25:38
     *@param uuid
     *@param userInfo
     */
    private void modifyUserInfoByUUID(UserInfoDaoModel userInfo){
        userMapper.modifyUserInfoByUUID (userInfo);
    }

    /**
     * 
     *@Description: 根据uuid查询用户信息 
     *@Author: 李焱生
     *@Since: 2015年5月10日下午3:10:51
     *@param uuid
     *@return
     */
    private UserInfoDaoModel queryUserInfoByUUID(String uuid){
        if (StringUtil.isEmpty (uuid)) { throw new APIException (Errorcode.UUID_IS_NULL,"uuid为空"); }
        UserInfoDaoModel userInfo = redisClient.get (uuid, UserInfoDaoModel.class);
        if (userInfo == null) {
            userInfo = userMapper.queryUserInfoByUUID (uuid);
            updateUserInfoInRedisByUUID (uuid, userInfo);
        }
        return userInfo;
    }

    /**
     * 
     *@Description: 根据uuid更新redis中的用户信息
     *@Author: 李焱生
     *@Since: 2015年5月12日下午11:11:12
     *@param uuid
     *@param userInfo
     */
    private void updateUserInfoInRedisByUUID(String uuid,UserInfoDaoModel userInfo){
        if (userInfo != null) {
            redisClient.setex (uuid, 1800, userInfo);
        }
    }

    /**
     *@Description: 用户登录 
     *@Author: 李焱生
     *@Since: 2015年5月6日上午9:34:14
     *@param params
     *@return
     */
    @Override
    public UserLoginAPIRespParam login(UserLoginAPIReqParam params){

        // 1.校验参数
        validateLoginParams (params);

        // 2.调用DAO层查询用户的信息
        UserInfoDaoModel userInfo = userMapper.login (StringUtil.trimNull (params.getAccount ()), StringUtil.trimNull (params.getPwd ()));
        if (userInfo == null) { throw new APIException (Errorcode.ACCOUNT_NOT_EXISTS_OR_WRONG_PWD,"账号不存在或密码错误","账号不存在或密码错误"); }

        // 3.保存或更新用户的设备信息
        saveOrUpdateUserDeviceInfo (userInfo, params);

        // 4.更新登录次数
        saveOrUpdateUserLoginInfo (userInfo);

        // 5.更新redis信息
        String token = updateUserInfoInRedis (userInfo);

        // 6.返回结果
        UserLoginAPIRespParam result = new UserLoginAPIRespParam ();
        result.setUserInfo (userInfo);
        result.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        result.setMessage ("用户登录成功");
        result.setToken (token);
        return result;
    }

    /**
     *@Description: 更新redis中的用户信息 
     *@Author: 李焱生
     *@Since: 2015年5月6日下午11:22:09
     *@param userInfo
     */
    private String updateUserInfoInRedis(UserInfoDaoModel userInfo){
        String token = generateUserToken (userInfo);
        redisClient.setex (token, 1800, userInfo);
        return token;
    }

    /**
     * 
     *@Description: 生成存放在redis中的token 
     *@Author: 李焱生
     *@Since: 2015年5月6日下午11:35:07
     *@param userInfo
     *@return
     */
    private String generateUserToken(UserInfoDaoModel userInfo){
        return MD5.encodeByMD5 (UuidUtils.getUuid () + MD5.encodeByMD5 (userInfo.getId () + userInfo.getAccount ()));
    }

    /**
     *@Description: 保存或更新用户登录信息 
     *@Author: 李焱生
     *@Since: 2015年5月6日下午8:40:49
     *@param userInfo
     */
    private void saveOrUpdateUserLoginInfo(UserInfoDaoModel userInfo){
        UserLoginInfoDaoModel loginInfo = userMapper.queryUserLoginInfoByUserId (StringUtil.trimNull (userInfo.getId ()));
        if (loginInfo != null) {
            loginInfo.setLastLoginTime (loginInfo.getLoginTime ());
            loginInfo.setLoginTime (new Date ());
            loginInfo.setLoginNums (loginInfo.getLoginNums () + 1);
            userMapper.updateUserLoginInfo (loginInfo);
        } else {
            loginInfo = new UserLoginInfoDaoModel ();
            loginInfo.setLastLoginTime (new Date ());
            loginInfo.setLoginNums (1);
            loginInfo.setLoginTime (new Date ());
            loginInfo.setUserId (userInfo.getId ());
            userMapper.saveUserLoginInfo (loginInfo);
        }
    }

    /**
     *@Description: 保存或更新用户的设备信息 
     *@Author: 李焱生
     *@Since: 2015年5月6日下午3:28:42
     *@param userInfo
     *@param params
     */
    private void saveOrUpdateUserDeviceInfo(UserInfoDaoModel userInfo,UserLoginAPIReqParam params){
        UserDeviceInfoDaoModel deviceInfo = getDeviceInfoFromUserAgent (params.getUseragent ());
        if (deviceInfo != null) {
            deviceInfo.setUserId (StringUtil.trimNull (userInfo.getId ()));
            UserDeviceInfoDaoModel prevDeviceInfo = userMapper.queryDeviceInfoByUserId (StringUtil.trimNull (userInfo.getId ()));
            if (prevDeviceInfo != null) {
                updateUserDeviceInfo (deviceInfo);
            } else {
                saveUserDeviceInfo (deviceInfo);
            }
        }
    }

    /**
     *@Description: 保存用户的设备信息 
     *@Author: 李焱生
     *@Since: 2015年5月6日下午4:11:47
     *@param deviceInfo
     */
    private void saveUserDeviceInfo(UserDeviceInfoDaoModel deviceInfo){
        userMapper.saveUserDeviceInfo (deviceInfo);
    }

    /**
     *@Description: 更新用户的设备信息
     *@Author: 李焱生
     *@Since: 2015年5月6日下午4:11:42
     *@param deviceInfo
     */
    private void updateUserDeviceInfo(UserDeviceInfoDaoModel deviceInfo){
        userMapper.updateUserDeviceInfo (deviceInfo);
    }

    /**
     *@Description: 获取用户的设备信息
     *@Author: 李焱生
     *@Since: 2015年5月6日下午3:27:18
     *@param useragent
     *@return
     */
    private UserDeviceInfoDaoModel getDeviceInfoFromUserAgent(String useragent){
        if (StringUtil.isNotEmpty (useragent)) {
            String[] items = useragent.split ("_");
            UserDeviceInfoDaoModel bean = new UserDeviceInfoDaoModel ();
            bean.setSysname (StringUtil.trimNull (items[0]));
            bean.setSysversion (StringUtil.trimNull (items[1]));
            bean.setAppversion (StringUtil.trimNull (items[2]));
            bean.setAppversionname (StringUtil.trimNull (items[3]));
            bean.setScreenHeight (StringUtil.trimNull (items[4]));
            bean.setScreenWidth (StringUtil.trimNull (items[5]));
            bean.setDensity (StringUtil.trimNull (items[6]));
            bean.setDeviceInfo (StringUtil.trimNull (items[7]));
            bean.setUuid (StringUtil.trimNull (items[8]));
            bean.setNettype (StringUtil.trimNull (items[9]));
            return bean;
        }
        return null;
    }

    /**
     *@Description: 验证登录的请求参数 
     *@Author: 李焱生
     *@Since: 2015年5月6日上午9:38:15
     *@param params
     */
    private void validateLoginParams(UserLoginAPIReqParam params){
        String account = StringUtil.trimNull (params.getAccount ());
        String pwd = StringUtil.trimNull (params.getPwd ());
        if (StringUtil.isEmpty (account) || StringUtil.isEmpty (pwd)) { throw new BusinessException (Errorcode.LOGIN_PWD_OR_ACCOUNT_IS_NULL,"账号或密码为空"); }
    }

    /**
     *@Description: 根据token从redis中获取用户信息
     *@Author: 李焱生
     *@Since: 2015年5月7日上午8:45:38
     *@param token
     *@return
     */
    @Override
    public UserInfoQueryInRedisAPIRespParam getUserInfoFromRedisByToken(UserInfoQueryInRedisAPIReqParam params){
        UserInfoDaoModel userInfo = redisClient.get (StringUtil.trimNull (params.getToken ()), UserInfoDaoModel.class);
        UserInfoQueryInRedisAPIRespParam result = new UserInfoQueryInRedisAPIRespParam ();
        result.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        result.setMessage ("从redis中查询用户的信息成功");
        result.setUserInfo (userInfo);
        return result;
    }

    /**
     *@Description: 根据用户的id查询用户的爱好信息
     *@Author: 李焱生
     *@Since: 2015年5月7日下午4:51:34
     *@param hobbyParams
     *@return
     */
    @Override
    public UserHobbyQueryAPIRespParam queryUserHobbyByUserId(UserHobbyQueryAPIReqParam hobbyParams){

        // 1.校验参数
        validateHobbyQueryParam (hobbyParams);

        // 2.查询用户的爱好信息
        UserHobbyDaoModel hobby = userMapper.queryUserHobbyByUserId (StringUtil.trimNull (hobbyParams.getUserId ()));

        // 3.返回结果
        UserHobbyQueryAPIRespParam resultBean = new UserHobbyQueryAPIRespParam ();
        resultBean.setHobby (hobby);
        return resultBean;
    }

    /**
     *@Description: 校验查询用户爱好的参数 
     *@Author: 李焱生
     *@Since: 2015年5月7日下午4:59:39
     *@param hobbyParams
     */
    private void validateHobbyQueryParam(UserHobbyQueryAPIReqParam hobbyParams){
        String userId = hobbyParams.getUserId ();
        if (StringUtil.isEmpty (userId)) { throw new APIException (Errorcode.QUERRY_HOBBY_USERID_IS_NULL,"查询用户爱好，用户id为空","查询用户爱好，用户id为空"); }
    }

    /**
     *@Description: 编辑用户的爱好信息
     *@Author: 李焱生
     *@Since: 2015年5月7日下午11:22:17
     *@param reqParam
     *@return
     */
    @Override
    public UserHobbyEditAPIRespParam editUserHobbyInfo(UserHobbyEditAPIReqParam reqParam){
        String hobbyId = StringUtil.trimNull (reqParam.getHobbyId ());
        String userId = StringUtil.trimNull (reqParam.getUserId ());
        UserHobbyDaoModel model = new UserHobbyDaoModel ();
        model.setId (hobbyId);
        model.setUserId (userId);
        model.setAssest (StringUtil.trimNull (reqParam.getAssest ()));
        model.setLimit (StringUtil.trimNull (reqParam.getLimit ()));
        model.setMemo (StringUtil.trimNull (reqParam.getMemo ()));
        model.setRiskAbility (StringUtil.trimNull (reqParam.getRiskAbility ()));
        model.setYearIncomeRate (StringUtil.trimNull (reqParam.getYearIncomeRate ()));
        if (StringUtil.isNotEmpty (userId) && StringUtil.isNotEmpty (hobbyId)) {
            userMapper.updateUserHobbyInfo (model);
        } else if (StringUtil.isNotEmpty (userId)) {
            UserHobbyDaoModel tempModel = userMapper.queryUserHobbyByUserId (userId);
            if (tempModel != null) {
                model.setId (tempModel.getId ());
                userMapper.updateUserHobbyInfo (model);
            } else {
                userMapper.saveUserHobbyInfo (model);
            }
        } else {
            throw new APIException (Errorcode.USERINFO_NOT_EXISTS,"用户信息不存在");
        }
        UserHobbyEditAPIRespParam resultBean = new UserHobbyEditAPIRespParam ();
        resultBean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        resultBean.setMessage ("编辑用户的爱好信息成功");
        return resultBean;
    }

    /**
     *@Description: 保存用户的反馈信息 
     *@Author: 李焱生
     *@Since: 2015年5月8日下午1:30:43
     *@param reqParam
     *@return
     */
    @Override
    public UserFeedbackSaveRespAPIParam saveUserFeedbackInfo(UserFeedbackSaveReqAPIParam reqParam){

        // 1.校验参数
        validateSaveUserFeedbackInfoParam (reqParam);

        // 2.保存反馈信息
        UserFeedBackInfoDaoModel bean = new UserFeedBackInfoDaoModel ();
        bean.setEmail (StringUtil.trimNull (reqParam.getEmail ()));
        bean.setFeedbackInfo (StringUtil.trimNull (reqParam.getFeedbackInfo ()));
        bean.setFeedbackTime (reqParam.getFeedbackTime ());
        bean.setMemo (StringUtil.trimNull (reqParam.getMemo ()));
        bean.setMobile (StringUtil.trimNull (reqParam.getMobile ()));
        bean.setUserId (StringUtil.trimNull (reqParam.getUserId ()));
        userMapper.saveUserFeedbackInfo (bean);

        // 3.返回信息
        UserFeedbackSaveRespAPIParam result = new UserFeedbackSaveRespAPIParam ();
        result.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        result.setMessage ("保存用户的反馈信息成功");
        return result;
    }

    /**
     *@Description: 校验参数 
     *@Author: 李焱生
     *@Since: 2015年5月8日下午1:31:47
     *@param reqParam
     */
    private void validateSaveUserFeedbackInfoParam(UserFeedbackSaveReqAPIParam reqParam){
        String feedbackInfo = reqParam.getFeedbackInfo ();
        if (StringUtil.isEmpty (feedbackInfo)) { throw new APIException (Errorcode.FEED_BACK_CONTENT_IS_NULL,"反馈信息为空","反馈信息为空"); }
    }

    /**
     * 
     *@Description: 根据用户id查询反馈信息
     *@Author: 李焱生
     *@Since: 2015年5月8日下午11:00:38
     *@param params
     *@return
     */
    public UserFeedbackQueryRespAPIParam queryFeedbackInfoByUserId(UserFeedbackQueryReqAPIParam params){
        String isPage = StringUtil.trimNull (params.getIsPage (), Constant.IS_PAGING_NO);
        String userId = StringUtil.trimNull (params.getUserId ());
        String feedbackId = StringUtil.trimNull (params.getFeedbackId ());
        List<UserFeedBackInfoDaoModel> resultList = null;
        PageInfo<UserFeedBackInfoDaoModel> pageList = null;
        if (Constant.IS_PAGING_YES.equals (isPage)) {
            pageList = userDao.queryUserFeedbackInfoListByUserId (userId, feedbackId, params.getPageNo (), params.getPageSize ());
        } else {
            resultList = userMapper.queryUserFeedbackInfoListByUserId (userId, feedbackId);
        }
        UserFeedbackQueryRespAPIParam resultBean = new UserFeedbackQueryRespAPIParam ();
        resultBean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        resultBean.setMessage ("查询用户的反馈信息成功");
        resultBean.setFeedbackList (resultList);
        resultBean.setPageList (pageList);
        resultBean.setIsPage (isPage);
        return resultBean;
    }

    /**
     *@Description: 根据反馈信息id查询用户的反馈信息 
     *@Author: 李焱生
     *@Since: 2015年5月9日下午12:32:00
     *@param reqParam
     *@return
     */
    @Override
    public UserFeedbackQueryByIdRespAPIModel queryUserFeedbackInfoByFeedBackId(UserFeedbackQueryByIdReqAPIModel reqParam){

        String feedbackId = StringUtil.trimNull (reqParam.getFeedbackId ());
        String userId = StringUtil.trimNull (reqParam.getUserId ());
        if (StringUtil.isEmpty (userId) || StringUtil.isEmpty (feedbackId)) { throw new APIException (Errorcode.DEFAULT_ERROR_CODE,"用户id或feedbackid参数为空"); }
        String queryReplyFlag = StringUtil.trimNull (reqParam.getQueryReplyFlag (), UserFeedbackQueryByIdReqAPIModel.NOT_QUERY_REPLY_FLAG);
        List<UserFeedBackInfoDaoModel> resultList = userMapper.queryUserFeedbackInfoListByUserId (userId, feedbackId);
        UserFeedbackQueryByIdRespAPIModel respBean = new UserFeedbackQueryByIdRespAPIModel ();
        respBean.setFeedbackId (feedbackId);
        respBean.setQueryReplyFlag (queryReplyFlag);
        if (resultList != null && !resultList.isEmpty ()) {
            respBean.setFeedbackInfo (resultList.get (0));
            if (UserFeedbackQueryByIdReqAPIModel.QUERY_REPLY_FLAG.equals (queryReplyFlag)) {
                List<UserFeenbackReplyDaoModel> replyInfoList = userMapper.queryUserFeedbackReplyInfoByFeedbackId (respBean.getFeedbackId ());
                respBean.setReplyInfoList (replyInfoList);
            }
        }
        respBean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        respBean.setMessage ("调用接口成功");
        return respBean;
    }
}
