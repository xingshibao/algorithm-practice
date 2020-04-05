package com.xsb.offer;

import java.util.Arrays;

/**
 * @author shibao.xing
 * @since 2020-04-05 21:14
 *
 * 题目：滑动窗口的最大值
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/submissions/
 */
public class Question5901 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        if (k == 0) {
            return new int[0];
        }
        int length = nums.length;
        int[] result = new int[length - k + 1];

        for (int i = 0; i < length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        Question5901 question5901 = new Question5901();
        int[] num = new int[]{1,3,-1,-3,5,3,6,7};
        int[] ints = question5901.maxSlidingWindow(num, 3);
        System.out.println(Arrays.toString(ints));
    }
}
