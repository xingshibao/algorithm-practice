package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-04 18:40
 *
 * 题目：0～n-1中缺失的数字
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 * 二分查找的变体
 */
public class Question53 {

    public int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Question53 question53 = new Question53();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int i = question53.missingNumber(nums);
        System.out.println(i);
    }
}
