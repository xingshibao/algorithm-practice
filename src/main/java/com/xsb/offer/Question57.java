package com.xsb.offer;

import java.util.Arrays;

/**
 * @author shibao.xing
 * @since 2020-04-05 12:56
 *
 * 题目：和为s的两个数字
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
public class Question57 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[0];
        }

        int s = 0;
        int e = nums.length - 1;
        int tmp = nums[s] + nums[e];
        while (tmp != target && s < e) {
            if (tmp > target) {
                e--;
            } else {
                s++;
            }
            tmp = nums[s] + nums[e];
        }

        int[] result = new int[2];
        result[0] = nums[s];
        result[1] = nums[e];
        return result;
    }

    public static void main(String[] args) {
        Question57 question57 = new Question57();
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = question57.twoSum(nums, 90);
        System.out.printf(Arrays.toString(ints));
    }
}
