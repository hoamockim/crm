package com.tipee.crm.util;

import java.util.Date;

public final class StringUtil {
    public static String random(int length) {
        final String letters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String result = "";
        for (int i = 0; i < length; i ++){
            final double rd = Math.floor(Math.random() * letters.length()) + 1;
            result += letters.charAt((int)rd);
        }
        return result;
    }
    public static Long convertDateToSeconds(Date date){
        return date.getTime()/1000;
    }
}
