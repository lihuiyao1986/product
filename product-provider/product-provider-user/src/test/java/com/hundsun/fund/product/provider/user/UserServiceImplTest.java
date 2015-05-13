package com.hundsun.fund.product.provider.user;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hundsun.fund.product.api.user.model.UserCallRecordSaveAPIReqParam;
import com.hundsun.fund.product.api.user.model.UserFeedbackQueryByIdReqAPIModel;
import com.hundsun.fund.product.api.user.model.UserFeedbackQueryByIdRespAPIModel;
import com.hundsun.fund.product.api.user.model.UserFeedbackQueryReqAPIParam;
import com.hundsun.fund.product.api.user.model.UserFeedbackQueryRespAPIParam;
import com.hundsun.fund.product.api.user.model.UserFeedbackSaveReqAPIParam;
import com.hundsun.fund.product.api.user.model.UserLoginAPIReqParam;
import com.hundsun.fund.product.api.user.model.UserLoginAPIRespParam;
import com.hundsun.fund.product.api.user.service.IUserService;
import com.hundsun.fund.product.commons.utils.APPUtils;
import com.hundsun.fund.product.commons.utils.Constant;
import com.hundsun.fund.product.dao.model.UserFeedBackInfoDaoModel;
import com.hundsun.fund.product.dao.model.UserFeenbackReplyDaoModel;

/**
 *@Description:dal单元测试基类
 *@Author:李焱生
 *@Since:2015年1月13日 上午10:52:26
 */
public class UserServiceImplTest extends BaseTest {

    @Autowired
    private IUserService userService;

    /**
     * 
     *@Description: 测试用户登录
     *@Author: 李焱生
     *@Since: 2015年5月8日下午2:32:20
     */
    // @Test
    public void testUserLogin(){
        UserLoginAPIReqParam params = new UserLoginAPIReqParam ();
        params.setAccount ("13606603646");
        params.setPwd ("E10ADC3949BA59ABBE56E057F20F883E");
        params.setUseragent ("IOS_4.0_1.0.0_V1.2.8_320_480_2.0_iphone4S_dessdddd_wify");
        UserLoginAPIRespParam respBean = userService.login (params);
        logger.debug (respBean.toString ());
    }

    /***
     * 
     *@Description: 保存用户的反馈信息
     *@Author: 李焱生
     *@Since: 2015年5月8日下午2:32:59
     */
    // @Test
    public void testSaveUserFeedBackInfo(){
        UserFeedbackSaveReqAPIParam params = new UserFeedbackSaveReqAPIParam ();
        params.setEmail ("lihuiyao1986@163.com");
        params.setFeedbackTime (new Date ());
        params.setMemo ("");
        params.setMobile ("13455544455");
        params.setUserId ("1");
        params.setFeedbackInfo ("2013年3月1日 - MyBatis 通过包含的jdbcType类型,tianjianying_15的网易博客,愿所有人每天都");
        userService.saveUserFeedbackInfo (params);
    }

    /**
     * 
     *@Description: 保存用户的反馈信息
     *@Author: 李焱生
     *@Since: 2015年5月8日下午4:24:53
     */
    // @Test
    public void testSaveUserFeedbackInfo(){
        UserFeedbackSaveReqAPIParam reqParam = new UserFeedbackSaveReqAPIParam ();
        reqParam.setEmail ("lihys@163.com");
        reqParam.setMobile ("13555555555");
        reqParam.setUserId ("1");
        reqParam.setFeedbackTime (new Date ());
        reqParam.setFeedbackInfo ("2014年3月5日 - 百度提供天气预报查询接口API,可以根据经纬度/城市名查询天气情况,我们可以在微信公众平台开发中调用这一接口。 接口说明 根据经纬度/城市名查询天气的结果 接口示例.");
        userService.saveUserFeedbackInfo (reqParam);
    }

    /**
     * 
     *@Description: 查询用户的反馈信息 
     *@Author: 李焱生
     *@Since: 2015年5月8日下午11:14:06
     */
    //@Test
    public void testQueryFeedbackInfoByUserId(){
        UserFeedbackQueryReqAPIParam params = new UserFeedbackQueryReqAPIParam ();
        params.setIsPage (Constant.IS_PAGING_YES);
        params.setPageNo (2);
        params.setPageSize (3);
        params.setUserId ("1");
        UserFeedbackQueryRespAPIParam result = userService.queryFeedbackInfoByUserId (params);
        if (result != null) {
            logger.debug (result.toString ());
        }
    }
    
    /**
     * 
     *@Description: 根据feedbackid查询用户的反馈和回复信息 
     *@Author: 李焱生
     *@Since: 2015年5月9日下午2:17:58
     */
    //@Test
    public void testQueryUserFeedbackInfoByFeedBackId()
    {
        UserFeedbackQueryByIdReqAPIModel reqParam = new UserFeedbackQueryByIdReqAPIModel();
        reqParam.setFeedbackId ("2");
        reqParam.setQueryReplyFlag (UserFeedbackQueryByIdReqAPIModel.QUERY_REPLY_FLAG);
        reqParam.setUserId ("1");
        UserFeedbackQueryByIdRespAPIModel resp = userService.queryUserFeedbackInfoByFeedBackId (reqParam);
        if(APPUtils.isAPISuccess (resp))
        {
            UserFeedBackInfoDaoModel feedbackInfo = resp.getFeedbackInfo ();
            if(feedbackInfo!=null)
            {
                logger.debug ("email:" + feedbackInfo.getEmail ());
                logger.debug ("feedbackInfo:" + feedbackInfo.getFeedbackInfo ());
                logger.debug ("id:" + feedbackInfo.getId ());
                logger.debug ("email:" + feedbackInfo.getEmail ());
                logger.debug ("memo:" + feedbackInfo.getMemo ());
                logger.debug ("mobile:" + feedbackInfo.getMobile ());
                logger.debug ("userid:" + feedbackInfo.getUserId ());
                logger.debug ("feedbackTime:" + feedbackInfo.getFeedbackTime ());
            }
            List<UserFeenbackReplyDaoModel> list =  resp.getReplyInfoList ();
            for ( UserFeenbackReplyDaoModel userFeenbackReplyDaoModel : list ) {
                logger.debug ("-----------begin----------------");
                logger.debug ("content:" + userFeenbackReplyDaoModel.getContent ());
                logger.debug ("feedbackId:" + userFeenbackReplyDaoModel.getFeedbackId ());
                logger.debug ("id:" + userFeenbackReplyDaoModel.getId ());
                logger.debug ("memo:" + userFeenbackReplyDaoModel.getMemo ());
                logger.debug ("replyAuthor:" + userFeenbackReplyDaoModel.getReplyAuthor());
                logger.debug ("replyTime:" + userFeenbackReplyDaoModel.getReplyTime());
                logger.debug ("-----------end-----------------");
            }
        }
    }
    
    /**
     * 
     *@Description: 保存用户的电话记录
     *@Author: 李焱生
     *@Since: 2015年5月12日下午11:22:35
     */
    @Test
    public void testSaveUserPhoneRecord(){
        UserCallRecordSaveAPIReqParam params = new UserCallRecordSaveAPIReqParam();
        params.setPlannerId ("1");
        params.setUserId ("1");
        userService.saveUserCallRecord (params);
    }
}
