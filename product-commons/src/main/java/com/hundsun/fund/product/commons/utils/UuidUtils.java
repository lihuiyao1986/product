package com.hundsun.fund.product.commons.utils;

import java.util.UUID;

public class UuidUtils {

    /**
     * 获取32为uuid
     *
     */
    public static String getUuid(){
        String s = UUID.randomUUID ().toString ();
        String upperCase = s.substring (0, 8) + s.substring (9, 13) + s.substring (14, 18) + s.substring (19, 23) + s.substring (24);
        return upperCase.toUpperCase ();
    }

    /**
     * 获取8位uuid（重复概率有，极低）
     *
     */
    public static String generateShortUuid(){
        String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

        StringBuffer shortBuffer = new StringBuffer ();
        String uuid = UUID.randomUUID ().toString ().replace ("-", "");
        for ( int i = 0 ; i < 8 ; i++ ) {
            String str = uuid.substring (i * 4, i * 4 + 4);
            int x = Integer.parseInt (str, 16);
            shortBuffer.append (chars[x % 0x3E]);
        }
        return shortBuffer.toString ();
    }

}
