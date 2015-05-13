/**
 * @Title: StringUtils.java
 * @Package com.hundsun.fund.product.commons
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月29日 下午3:59:51
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.commons.utils;

/**
 *@Description:
 *@Author:李焱生
 *@Since:2015年4月29日下午3:59:51  
 */
public class StringUtil {

    /**
     *@Description:判断对应的字符串是否为空 
     *@Author: 李焱生
     *@Since: 2015年4月29日下午5:23:58
     *@param str
     *@return
     */
    public static boolean isEmpty(String str){
        if (str == null) { return true; }
        return str.trim ().length () <= 0;
    }

    /**
     * 
     *@Description: 判断对应的字符串是否不为空 
     *@Author: 李焱生
     *@Since: 2015年4月29日下午5:25:44
     *@param str
     *@return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty (str);
    }

    /**
     * 
     *@Description:  trimNull
     *@Author: 李焱生
     *@Since: 2015年4月29日下午5:29:10
     *@param str
     *@return
     */
    public static String trimNull(String str){
        if (isNotEmpty (str)) {
            return str.trim ();
        } else {
            return "";
        }
    }

    /**
     * 
     *@Description: trimNull
     *@Author: 李焱生
     *@Since: 2015年4月29日下午5:31:35
     *@param str
     *@param defaultStr
     *@return
     */
    public static String trimNull(String str,String defaultStr){
        if (isNotEmpty (str)) {
            return str.trim ();
        } else {
            return defaultStr;
        }
    }
}
