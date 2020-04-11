package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-11 20:43
 *
 * 题目：1～n整数中1出现的次数
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 */
public class Question43 {

    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int)Math.pow(10, s.length() - 1);
        int last = n % pow;
        if (high == 1) {
            return last + 1 + countDigitOne(pow - 1) + countDigitOne(last);
        } else {
            return pow + countDigitOne(last) + high * countDigitOne(pow - 1);
        }
    }

    public static void main(String[] args) {
        Question43 question43 = new Question43();
        int i = question43.countDigitOne(99);
        System.out.println(i);
    }
}
