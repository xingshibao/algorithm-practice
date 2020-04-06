package com.xsb.offer;

import java.util.Arrays;

/**
 * @author shibao.xing
 * @since 2020-04-06 10:45
 *
 * 题目：打印从1到最大的n位数
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class Question17 {

    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }

        double pow = Math.pow(10, n);
        int i = new Double(pow).intValue();
        int[] result = new int[i - 1];
        for (int j = 0; j < i - 1; j++) {
            result[j] = j + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Question17 question17 = new Question17();
        int[] ints = question17.printNumbers(2);
        System.out.println(Arrays.toString(ints));
    }
}
