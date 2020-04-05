package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-05 12:41
 *
 * 题目：数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class Question3 {

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] result = new int[nums.length];
        for (int num : nums) {
            result[num] += 1;
            if (result[num] > 1) {
                return num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        Question3 question3 = new Question3();
        int repeatNumber = question3.findRepeatNumber(arr);
        System.out.println(repeatNumber);
    }
}
