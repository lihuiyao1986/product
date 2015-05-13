package com.hundsun.fund.product.commons.utils;

import java.security.MessageDigest;

/**
 *@Description:MD5工具类
 *@Author:李焱生
 *@Since:2014年10月31日下午2:58:39  
 */
public class MD5 {

    /**十六进制下数字到字符的映射数组  */
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    /**  对字符串进行MD5加密     */
    public static String encodeByMD5(String originString){
        if (originString != null) {
            try {
                // 创建具有指定算法名称的信息摘要
                MessageDigest md = MessageDigest.getInstance ("MD5");
                // 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md.digest (originString.getBytes ());
                // 将得到的字节数组变成字符串返回
                String resultString = byteArrayToHexString (results);
                return resultString.toUpperCase ();
            } catch (Exception ex) {
                ex.printStackTrace ();
            }
        }
        return null;
    }

    public static String encodeByMD5ForLowercase(String originString){
        String resultString = null;
        try {
            resultString = new String (originString);
            MessageDigest md = MessageDigest.getInstance ("MD5");
            resultString.trim ();
            resultString = byteArrayToHexString (md.digest (resultString.getBytes ("UTF-8")));
        } catch (Exception ex) {}

        return resultString;
    }

    /**  
     * 转换字节数组为十六进制字符串 
     * @param     字节数组 
     * @return    十六进制字符串 
     */
    private static String byteArrayToHexString(byte[] b){
        StringBuffer resultSb = new StringBuffer ();
        for ( int i = 0 ; i < b.length ; i++ ) {
            resultSb.append (byteToHexString (b[i]));
        }
        return resultSb.toString ();
    }

    /** 将一个字节转化成十六进制形式的字符串     */
    private static String byteToHexString(byte b){
        int n = b;
        if (n < 0) n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
