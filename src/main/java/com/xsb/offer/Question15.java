package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-05 13:59
 *
 * 题目：二进制中1的个数
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class Question15 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            int tmp = n & 1;
            if (tmp == 1) {
                result++;
            }
            n = n >>> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Question15 question15 = new Question15();
        int i = question15.hammingWeight(4);
        System.out.println(i);
    }
}
