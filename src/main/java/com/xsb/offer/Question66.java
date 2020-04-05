package com.xsb.offer;

import java.util.Arrays;

/**
 * @author shibao.xing
 * @since 2020-04-05 10:23
 *
 * 题目：构建乘积数组
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 */
public class Question66 {

    /**
     * 双百的方法，巧妙
     */
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int[] result = new int[a.length];
        int left = 1;
        for (int i = 0; i < a.length; i++) {
            result[i] = left;
            left *= a[i];
        }

        int right = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= a[i];
        }

        return result;
    }

    /**
     * 超时
     */
    public int[] constructArr1(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        if (a.length == 1) {
            return new int[]{a[0]};
        }

        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int result = 1;
            for (int j = 0; j < a.length; j++) {
                if (i == j) {
                    continue;
                }
                result = result * a[j];
            }
            b[i] = result;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
//        int[] a = new int[]{10};
        Question66 question66 = new Question66();
        int[] ints = question66.constructArr(a);
        System.out.println(Arrays.toString(ints));
    }
}
