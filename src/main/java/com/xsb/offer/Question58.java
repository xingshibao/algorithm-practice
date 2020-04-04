package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-04 17:42
 *
 * 题目：翻转单词顺序
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
public class Question58 {

    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        s = s.trim();
        if (s.length() <= 1) {
            return s;
        }

        s = reverseString(s);
        StringBuilder sb = new StringBuilder();
        String[] split = s.trim().split(" +");
        for (int i = 0; i < split.length; i++) {
            sb.append(reverseString(split[i]));
            if (i != split.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end]= tmp;
            start++;
            end--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Question58 question58 = new Question58();
        String s = question58.reverseWords(" ");
        System.out.println(s);
        System.out.println(s.length());
    }
}
