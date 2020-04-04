package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-04 12:01
 *
 * 题目：青蛙跳台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class Question10 {

    public static void main(String[] args) {
        Question10 question10 = new Question10();
        int i = question10.numWays(0);
        System.out.println(i);
    }

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] a = new int[n + 1];
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= n; i++) {
            a[i] = (a[i - 1] + a[i - 2]) % 1000000007;
        }
        return a[n];
    }
}
