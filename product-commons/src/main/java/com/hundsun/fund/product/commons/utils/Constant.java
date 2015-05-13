/**
 * @Title: Constant.java
 * @Package com.hundsun.fund.product.commons.utils
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月29日 下午8:00:34
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.commons.utils;

/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年4月29日下午8:00:34  
 */
public class Constant {

    /**
     * http合法性验证秘钥
     */
    public static final String SECRETKEY              = "0123456789";

    /*********************http 请求头参数 Start**********************/
    /**
     * http请求 User-Agent
     */
    public static final String REQUEST_USERAGENT      = "useragent";
    /**
     * 随机数
     */
    public static final String REQUEST_RANDOMONCE     = "random";
    /**
     * 版本号
     */
    public static final String REQUEST_VERSION        = "version";
    /**
     * 时间戳
     */
    public static final String REQUEST_TIMESTAMP      = "timestamp";
    /**
     * 令牌
     */
    public static final String REQUEST_TOKEN          = "token";
    /**
     * 客户端唯一标识(手机串号)
     */
    public static final String REQUEST_UUID           = "uuid";
    /**
     * 请求URL
     */
    public static final String REQUEST_URL            = "url";
    /**
     * 密文
     */
    public static final String REQUEST_SIGNATURE      = "signature";
    /**
     * 用户代理
     */
    public static final String REQUEST_USER_AGENT     = "useragent";
    /**
     * 来源
     */
    public static final String REQUEST_SOURCE         = "source";

    /**  request中的userInfo的key  **/
    public static final String USER_INFO_KEY_IN_REDIS = "userInfoInRedis";

    /** 分页 **/
    public static final String IS_PAGING_YES          = "1";

    /** 不分页 **/
    public static final String IS_PAGING_NO           = "0";

    /** 默认页码 **/
    public static final int    DEFAULT_PAGENO         = 1;

    /** 默认每页现实的页码数 **/
    public static final int    DEFAULT_PAGESIZE       = 10;

}
