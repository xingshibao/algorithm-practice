package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-05 13:23
 * 题目：左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class Question5802 {

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 1) {
            return s;
        }
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        Question5802 question5802 = new Question5802();
        String abcdefg = question5802.reverseLeftWords("abcdefg", 6);
        System.out.println(abcdefg);
    }
}
