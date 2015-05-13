/**
 * @Title: UserDAO.java
 * @Package com.hundsun.fund.product.dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月28日 下午11:02:58
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hundsun.fund.product.dao.model.UserDeviceInfoDaoModel;
import com.hundsun.fund.product.dao.model.UserFeedBackInfoDaoModel;
import com.hundsun.fund.product.dao.model.UserFeenbackReplyDaoModel;
import com.hundsun.fund.product.dao.model.UserHobbyDaoModel;
import com.hundsun.fund.product.dao.model.UserInfoDaoModel;
import com.hundsun.fund.product.dao.model.UserLoginInfoDaoModel;
import com.hundsun.fund.product.dao.model.UserPhoneRecordDaoModel;

/**
 *@Description:用户DAO
 *@Author:李焱生
 *@Since:2015年4月28日下午11:02:58  
 */
public interface UserMapper extends BaseMapper {

    /**
     *@Description: 用户登录 
     *@Author: 李焱生
     *@Since: 2015年5月6日下午1:50:07
     *@param account
     *@param pwd
     *@return
     */
    public UserInfoDaoModel login(@Param("account") String account,@Param("pwd") String pwd);
    
    /**
     * 
     *@Description: 根据uuid查询用户的信息 
     *@Author: 李焱生
     *@Since: 2015年5月10日下午2:34:07
     *@param uuid
     *@return
     */
    public UserInfoDaoModel queryUserInfoByUUID(@Param("uuid") String uuid);

    /**
     *@Description: 根据用户id查询用户的设备信息 
     *@Author: 李焱生
     *@Since: 2015年5月6日下午3:32:43
     *@param userId
     *@return
     */
    public UserDeviceInfoDaoModel queryDeviceInfoByUserId(@Param("userId") String userId);

    /**
     *@Description: 保存用户的设备信息
     *@Author: 李焱生
     *@Since: 2015年5月6日下午4:15:19
     *@param deviceInfo
     */
    public void saveUserDeviceInfo(UserDeviceInfoDaoModel deviceInfo);

    /**
     *@Description: 更新用户的设备信息
     *@Author: 李焱生
     *@Since: 2015年5月6日下午4:15:40
     *@param deviceInfo
     */
    public void updateUserDeviceInfo(UserDeviceInfoDaoModel deviceInfo);

    /**
     *@Description: 根据用户id查询用户的登录信息
     *@Author: 李焱生
     *@Since: 2015年5月6日下午8:50:19
     *@param userId
     *@return
     */
    public UserLoginInfoDaoModel queryUserLoginInfoByUserId(@Param("userId") String userId);

    /**
     *@Description: 更新用户的登录信息 
     *@Author: 李焱生
     *@Since: 2015年5月6日下午8:50:59
     *@param loginInfo
     */
    public void updateUserLoginInfo(UserLoginInfoDaoModel loginInfo);

    /**
     *@Description: 保存用户的登录信息 
     *@Author: 李焱生
     *@Since: 2015年5月6日下午8:51:18
     *@param loginInfo
     */
    public void saveUserLoginInfo(UserLoginInfoDaoModel loginInfo);

    /**
     *@Description: 根据用户ID查询用户的爱好信息
     *@Author: 李焱生
     *@Since: 2015年5月7日下午5:06:23
     *@param userId
     *@return
     */
    public UserHobbyDaoModel queryUserHobbyByUserId(@Param("userId") String userId);

    /**
     *
     *@Description:  保存用户的爱好信息
     *@Author: 李焱生
     *@Since: 2015年5月7日下午9:23:24
     *@param params
     */
    public void saveUserHobbyInfo(UserHobbyDaoModel params);

    /**
     * 
     *@Description: 更新用户的爱好信息
     *@Author: 李焱生
     *@Since: 2015年5月7日下午9:24:05
     *@param params
     */
    public void updateUserHobbyInfo(UserHobbyDaoModel params);

    /**
     *@Description: 保存用户的反馈信息
     *@Author: 李焱生
     *@Since: 2015年5月8日下午2:02:32
     *@param bean
     */
    public void saveUserFeedbackInfo(UserFeedBackInfoDaoModel params);

    /**
     * 
     *@Description: 根据用户ID查询用户的反馈信息
     *@Author: 李焱生
     *@Since: 2015年5月8日下午8:57:43
     *@param userId
     *@return
     */
    public List<UserFeedBackInfoDaoModel> queryUserFeedbackInfoListByUserId(@Param("userId") String userId,@Param("feedbackId") String feedbackId);

    /**
     *@Description: 根据用反馈信息ID查询回复信息
     *@Author: 李焱生
     *@Since: 2015年5月9日下午12:48:06
     *@param feedbackId
     *@return
     */
    public List<UserFeenbackReplyDaoModel> queryUserFeedbackReplyInfoByFeedbackId(@Param("feedbackId")String feedbackId);
    
    /**
     * 
     *@Description: 保存用户反馈信息的回复信息 
     *@Author: 李焱生
     *@Since: 2015年5月9日下午1:12:20
     *@param params
     */
    public void saveUserFeedbackReplyInfo(UserFeenbackReplyDaoModel params);

    /**
     *@Description: 保存用户信息
     *@Author: 李焱生
     *@Since: 2015年5月10日下午3:27:41
     *@param userInfo
     */
    public void saveUserInfo(UserInfoDaoModel userInfo);

    /**
     *@Description: 根据uuid修改用户信息
     *@Author: 李焱生
     *@Since: 2015年5月10日下午3:27:53
     *@param userInfo
     */
    public void modifyUserInfoByUUID(UserInfoDaoModel userInfo);

    /**
     *@Description: 保存用户的拨打电话的记录 
     *@Author: 李焱生
     *@Since: 2015年5月11日下午7:58:23
     *@param model
     */
    public void saveUserCallRecord(UserPhoneRecordDaoModel params);

}
