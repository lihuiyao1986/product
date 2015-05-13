/**
 * @Title: Errorcode.java
 * @Package com.hundsun.fund.product.commons.utils
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月5日 下午11:32:21
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.commons.utils;

/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年5月5日下午11:32:21  
 */

public class Errorcode {

    /***
     * 默认的错误码
     */
    public static final String DEFAULT_ERROR_CODE              = "9999";

    /**
     * 默认成功码
     */
    public static final String DEFAULT_SUCCESS_CODE            = "0";

    /**
     * 非法请求
     */
    public static final String ILLEGAL_REQ_CODE                = "1000";

    /**
     * 登录的密码或账号为空
     */
    public static final String LOGIN_PWD_OR_ACCOUNT_IS_NULL    = "1001";

    /**
     * 账号不存在或密码错误
     */
    public static final String ACCOUNT_NOT_EXISTS_OR_WRONG_PWD = "1002";

    /**
     * 会话失效
     */
    public static final String SESSION_EXPIRE                  = "1003";

    /**
     * 查询爱好时用户id为空
     */
    public static final String QUERRY_HOBBY_USERID_IS_NULL     = "1004";

    /**
     * 账户不存在
     */
    public static final String USER_NOT_EXISTS                 = "1005";

    /**
     * 产品不存在
     */
    public static final String PRODUCT_NOT_EXISTS              = "1006";

    /**
     * 产品id为空
     */
    public static final String PRODUCT_ID_IS_NULL              = "1007";

    /**
     * 查询类型为未知
     */
    public static final String PRODUCT_QUERY_TYPE_UNKNOW       = "1008";

    /**
     * 产品ID或用户ID为空
     */
    public static final String PRODUCT_ID_OR_USERID_IS_NULL    = "1009";

    /**
     * uuid为空
     */
    public static final String UUID_IS_NULL                    = "1010";

    /**
     * 用户信息不存在
     */
    public static final String USERINFO_NOT_EXISTS             = "1011";

    /**
     * 反馈信息为空
     */
    public static final String FEED_BACK_CONTENT_IS_NULL       = "1012";

    /**
     * 用户id或理财师ID为空
     */
    public static final String USERID_OR_PLANNERID_IS_NULL     = "1003";
}
