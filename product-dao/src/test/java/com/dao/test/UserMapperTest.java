/**
 * @Title: UserMapperTest.java
 * @Package com.hundsun.fund.product.dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月29日 下午1:53:10
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.dao.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hundsun.fund.product.dao.mapper.UserMapper;
import com.hundsun.fund.product.dao.model.UserDeviceInfoDaoModel;
import com.hundsun.fund.product.dao.model.UserFeedBackInfoDaoModel;
import com.hundsun.fund.product.dao.model.UserFeenbackReplyDaoModel;
import com.hundsun.fund.product.dao.model.UserHobbyDaoModel;
import com.hundsun.fund.product.dao.model.UserInfoDaoModel;
import com.hundsun.fund.product.dao.model.UserLoginInfoDaoModel;
import com.hundsun.fund.product.dao.model.UserPhoneRecordDaoModel;

/**
 *@Description:测试类
 *@Author:李焱生
 *@Since:2015年4月29日下午1:53:10  
 */
public class UserMapperTest extends BaseTest{


    @Autowired
    private UserMapper userMapper;

    /**
     * 
     *@Description: 用户登录
     *@Author: 李焱生
     *@Since: 2015年5月6日下午3:56:55
     */
    //@Test
    public void testUserLogin(){
        UserInfoDaoModel userInfo = userMapper.login ("13606603642", "E10ADC3949BA59ABBE56E057F20F883E");
        if (userInfo != null) {
            logger.debug (userInfo.toString ());
        }
    }
    
    /**
     * 
     *@Description: 根据用户uuid查询用户的信息
     *@Author: 李焱生
     *@Since: 2015年5月10日下午3:46:50
     */
    //@Test
    public void testQueryUserInfoByUUID()
    {
        UserInfoDaoModel userInfo = userMapper.queryUserInfoByUUID ("E10ADC3949BA59ABBE56E057F20F");
        logger.debug ("email="+userInfo.getEmail ());
        logger.debug ("address="+userInfo.getAddress ());
    }
    
    /**
     * 
     *@Description: 保存用户信息
     *@Author: 李焱生
     *@Since: 2015年5月10日下午3:47:43
     */
    //@Test
    public void testSaveUserInfo()
    {
        UserInfoDaoModel model = new UserInfoDaoModel ();
        model.setEmail ("lihuiyao1987@153.com");
        model.setAccount ("13677777777");
        model.setIcon ("");
        model.setMobile ("13677777777");
        model.setName ("王密码");
        model.setPwd ("YT0ADC3949BA59ABBE56E057F20F");
        model.setQq ("2544444444");
        model.setUuid ("YT0ADC3949BA59ABBE56E057F20F");
        model.setAddress ("浙江省杭州市西湖区");
        model.setWebchat ("hhhhhh");
        userMapper.saveUserInfo (model);
    }
    
    /**
     * 
     *@Description: 根据uuid修改用户信息
     *@Author: 李焱生
     *@Since: 2015年5月10日下午3:51:58
     */
    //@Test
    public void testModifyUserInfoByUUID()
    {
        UserInfoDaoModel model = new UserInfoDaoModel ();
        model.setEmail ("lihuiyao1987@153.com");
        model.setAccount ("13877777777");
        model.setMobile ("13877777777");
        model.setName ("王明明");
        model.setPwd ("TTT0ADC3949BA59ABBE56E057F20F");
        model.setQq ("2544444444");
        model.setUuid ("YT0ADC3949BA59ABBE56E057F20F");
        model.setAddress ("浙江省杭州市西湖区古墩路334号");
        userMapper.modifyUserInfoByUUID (model);
    }

    /**
     * 
     *@Description: 根据用户id查询设备信息
     *@Author: 李焱生
     *@Since: 2015年5月6日下午3:56:36
     */
    //@Test
    public void testQueryDeviceInfoByUserId(){
        UserDeviceInfoDaoModel deviceInfo = userMapper.queryDeviceInfoByUserId ("1");
        if (deviceInfo != null) {
            logger.debug (deviceInfo.toString ());
        }
    }
    
    /**
     * 
     *@Description: 保存用户的设备信息 
     *@Author: 李焱生
     *@Since: 2015年5月6日下午4:24:45
     */
    //@Test
    public void testSaveUserDeviceInfo()
    {
        UserDeviceInfoDaoModel deviceInfo = new UserDeviceInfoDaoModel ();
        deviceInfo.setDensity ("09");
        deviceInfo.setDeviceInfo ("dddd");
        deviceInfo.setAppversion ("1.0.0");
        deviceInfo.setAppversionname ("v1.0.9");
        deviceInfo.setSysname ("android");
        deviceInfo.setNettype ("4G");
        deviceInfo.setScreenHeight ("878");
        deviceInfo.setScreenWidth ("988");
        deviceInfo.setSysversion ("5s");
        deviceInfo.setUserId ("1");
        deviceInfo.setUuid ("hhhhhhhh");
        userMapper.saveUserDeviceInfo (deviceInfo);
    }
    
    /**
     *@Description: 更新用户的设备信息
     *@Author: 李焱生
     *@Since: 2015年5月6日下午5:21:08
     */
    //@Test
    public void testUpdateUserDeviceInfo(){
        UserDeviceInfoDaoModel deviceInfo = new UserDeviceInfoDaoModel ();
        deviceInfo.setDensity ("20");
        deviceInfo.setDeviceInfo ("ios");
        deviceInfo.setNettype ("4G1");
        deviceInfo.setScreenHeight ("786");
        deviceInfo.setScreenWidth ("1233");
        deviceInfo.setSysversion ("4s");
        deviceInfo.setUserId ("1");
        deviceInfo.setId ("2");
        deviceInfo.setUuid ("hhhhhhhh");
        userMapper.updateUserDeviceInfo (deviceInfo);
    }
    
    /**
     * 
     *@Description:根据用户id查询用户的登录信息 
     *@Author: 李焱生
     *@Since: 2015年5月6日下午9:24:31
     */
    //@Test
    public void testQueryUserLoginInfoByUserId()
    {
        UserLoginInfoDaoModel loginInfo = userMapper.queryUserLoginInfoByUserId ("1");
        if(loginInfo!=null)
        {
            logger.debug (loginInfo.toString ());
        }
    }
    
    /**
     * 
     *@Description: 保存用户的登录信息
     *@Author: 李焱生
     *@Since: 2015年5月6日下午10:10:16
     */
    //@Test
    public void testSaveUserLoginInfo()
    {
        UserLoginInfoDaoModel loginInfo = new UserLoginInfoDaoModel();
        loginInfo.setLastLoginTime (new Date ());
        loginInfo.setLoginNums (1);
        loginInfo.setLoginTime (new Date ());
        loginInfo.setUserId ("1");
        userMapper.saveUserLoginInfo (loginInfo);
    }
    
    /**
     * 
     *@Description: 更新用户的登录信息
     *@Author: 李焱生
     *@Since: 2015年5月6日下午10:59:02
     */
    //@Test
    public void testUpdateUserLoginInfo()
    {
        UserLoginInfoDaoModel loginInfo = new UserLoginInfoDaoModel();
        loginInfo.setLastLoginTime (new Date ());
        loginInfo.setLoginNums (3);
        loginInfo.setLoginTime (new Date ());
        loginInfo.setUserId ("1");
        loginInfo.setId ("2");
        userMapper.updateUserLoginInfo (loginInfo);
    }
    
    /**
     * 
     *@Description:保存用户的爱好信息 
     *@Author: 李焱生
     *@Since: 2015年5月7日下午9:32:01
     */
    //@Test
    public void testSaveUserHobbyInfo()
    {
        UserHobbyDaoModel model = new UserHobbyDaoModel ();
        model.setAssest ("1233.67");
        model.setLimit ("91");
        model.setRiskAbility ("00");
        model.setUserId ("1");
        model.setYearIncomeRate ("0.123");
        userMapper.saveUserHobbyInfo (model);
    }
    
    /**
     * 
     *@Description: 根据用户的ID查询用户的爱好信息 
     *@Author: 李焱生
     *@Since: 2015年5月7日下午9:54:12
     */
    //@Test
    public void testQueryUserHobbyByUserId()
    {
        UserHobbyDaoModel model = userMapper.queryUserHobbyByUserId ("2");
        if(model!=null)
        {
            logger.debug ("用户的爱好为:" + model.toString ());
        }
        else
        {
            logger.debug ("暂无用户的爱好"); 
        }
    }
    
    /**
     * 
     *@Description:更新用户的爱好信息
     *@Author: 李焱生
     *@Since: 2015年5月7日下午9:57:07
     */
    //@Test
    public void testUpdateUserHobbyInfo()
    {
        UserHobbyDaoModel model = new UserHobbyDaoModel ();
        //model.setAssest ("2333.67");
        model.setLimit ("109");
        model.setRiskAbility ("01");
        model.setUserId ("1");
        model.setYearIncomeRate ("0.444");
        model.setId ("5");
        userMapper.updateUserHobbyInfo (model);
    }
    
    /**
     * 
     *@Description: 保存用户的反馈信息
     *@Author: 李焱生
     *@Since: 2015年5月8日下午2:28:08
     */
    //@Test
    public void testSaveUserFeedbackInfo()
    {
        UserFeedBackInfoDaoModel model = new UserFeedBackInfoDaoModel();
        model.setEmail ("liyansheng@163.com");
        model.setFeedbackInfo ("sjdhfjkdshfjksdhfjjjjjjjkhkkkkkjjjjjjjjjjjjjjjjjjjjjjjdsfdsfsdfsdfdsfdsfsdfsdfsdf");
        model.setFeedbackTime (new Date ());
        model.setMemo ("");
        model.setMobile ("13606603642");
        model.setUserId ("1");
        userMapper.saveUserFeedbackInfo (model);
    }
    
    /**
     * 
     *@Description: 根据用户id查询用户反馈信息
     *@Author: 李焱生
     *@Since: 2015年5月8日下午9:21:06
     */
    //@Test
    public void testQueryUserFeedbackInfoListByUserId()
    {
        List<UserFeedBackInfoDaoModel> list = userMapper.queryUserFeedbackInfoListByUserId ("1","7");
        logger.debug ("用户反馈信息列表为：" + list);
    }
    
    /**
     *@Description: 根据反馈信息id查询用户的反馈回复信息 
     *@Author: 李焱生
     *@Since: 2015年5月9日下午1:05:52
     */
    //@Test
    public void testQueryUserFeedbackReplyInfoListByFeedbackId()
    {
        List<UserFeenbackReplyDaoModel> resultList =  userMapper.queryUserFeedbackReplyInfoByFeedbackId ("2");
        for ( UserFeenbackReplyDaoModel userFeenbackReplyDaoModel : resultList ) {
            logger.debug ("content:" + userFeenbackReplyDaoModel.getContent ());
            logger.debug ("replytime:" + userFeenbackReplyDaoModel.getReplyTime ().toString ());
            logger.debug ("replyAuthor:" + userFeenbackReplyDaoModel.getReplyAuthor ());
            logger.debug ("memo:" + userFeenbackReplyDaoModel.getMemo ());
        }
    }
    
    /**
     * 
     *@Description: 保存用户的反馈信息 
     *@Author: 李焱生
     *@Since: 2015年5月9日下午2:06:04
     */
    //@Test
    public void testSaveUserFeedbackReplyInfo()
    {
        UserFeenbackReplyDaoModel model = new UserFeenbackReplyDaoModel ();
        model.setContent ("你错了，你知道吗。。。。。。。");
        model.setReplyAuthor ("李明明");
        model.setReplyTime (new Date ());
        model.setFeedbackId ("2");
        userMapper.saveUserFeedbackReplyInfo (model);
    }
    
    
    /**
     * 
     *@Description: 保存用户的电话记录信息 
     *@Author: 李焱生
     *@Since: 2015年5月11日下午8:19:26
     */
    @Test
    public void testSaveUserCallRecord()
    {
        UserPhoneRecordDaoModel params = new UserPhoneRecordDaoModel ();
        params.setCreateTime (new Date());
        params.setPlannerId ("1");
        params.setUserId ("2");
        userMapper.saveUserCallRecord (params);
    }

}
