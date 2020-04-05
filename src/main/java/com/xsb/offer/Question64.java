package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-05 21:07
 *
 * 题目：求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 *
 * 看了下，感觉这题真没劲
 */
public class Question64 {

    public int sumNums(int n) {
        if (n % 2 == 0) {
            return (n / 2) * (n + 1);
        } else {
            return (n / 2) * (n + 1) + (n / 2 + 1);
        }
    }

    public static void main(String[] args) {
        Question64 question64 = new Question64();
        int i = question64.sumNums(5);
        System.out.println(i);
    }
}
