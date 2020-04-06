package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-06 12:32
 *
 * 题目：把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class Question46 {

    char[] alphabet = new char[]{
            'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y',
            'z'
    };

    public int translateNum(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        return ways(chars, 0);
    }

    private int ways(char[] chars, int i) {
        if (i > chars.length) {
            return 0;
        }
        if (i == chars.length || i == chars.length - 1) {
            return 1;
        }

        int a = ways(chars, i + 1);
        int b = 0;
        if (i < chars.length - 1 && ((chars[i] < '2' && chars[i] > '0') || (chars[i] == '2' && chars[i + 1] < '6'))) {
            b = ways(chars, i + 2);
        }
        return a + b;
    }

    public static void main(String[] args) {
        Question46 question46 = new Question46();
        int i = question46.translateNum(506);
        System.out.println(i);
    }
}
