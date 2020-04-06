package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-06 10:03
 */
public class Question67 {

    public int strToInt(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        StringBuilder finalStr = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                if (chars[i] == '-' || chars[i] == '+' || (chars[i] >= '0' && chars[i] <= '9')) {
                    finalStr.append(chars[i]);
                } else {
                    break;
                }
            } else {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    finalStr.append(chars[i]);
                } else {
                    break;
                }
            }
        }
        str = finalStr.toString();
        str = sub(str);
        if (str.length() == 0) {
            return 0;
        }
        if (str.length() == 1 && (str.equals("-") || str.equals("+"))) {
            return 0;
        }

        char firstChar = str.charAt(0);
        int sign = 1;
        if (firstChar == '-') {
            sign = -1;
            str = str.substring(1, str.length());
        } else if (firstChar == '+') {
            sign = 1;
            str = str.substring(1, str.length());
        }
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            int n = (str.charAt(i) - '0') * sign;
            int tmp = res * 10 + n;
            if ((tmp - n) / 10 != res) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            res = tmp;
        }
        return res;
    }

    private String sub(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        String op = "";
        if (str.startsWith("-")) {
            op = "-";
            str = str.substring(1, str.length());
        }
        if (str.startsWith("+")) {
            op = "+";
            str = str.substring(1, str.length());
        }

        char[] chars = str.toCharArray();
        int pos = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                pos++;
            } else {
                break;
            }
        }
        return op + str.substring(pos, str.length());
    }
}
