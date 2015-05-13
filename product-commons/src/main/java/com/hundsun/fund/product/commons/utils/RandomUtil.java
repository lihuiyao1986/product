package com.hundsun.fund.product.commons.utils;

import java.util.Random;

public class RandomUtil {

    /**
     * 随机生成一个六位数
     * @author wcj
     * @param digit
     * @return 
     * @since 2015-01-13
     */
    public static String getRandom(int digit){
        Random ran = new Random ();
        int randomNum = 0;
        String randomStr = "";
        randomNum = ran.nextInt (999999);
        randomStr = String.valueOf (randomNum);
        /**
         * 如果生成的数小于100000，循环让此数大于100000
         */
        if (randomNum < 100000) {
            String str = "";
            for ( int i = 0 ; i < digit - randomStr.length () ; i++ ) {
                System.out.println (i++);
                str += "0";
            }
            randomStr = str + randomStr;
        }
        return randomStr;
    }
}
