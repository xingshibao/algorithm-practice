package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-05 13:06
 *
 * 题目：在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class Question5301 {

    public int search(int[] nums, int target) {
        int p = find(nums, target);
        if (p == -1) {
            return 0;
        }
        int result = 1;
        for (int i = p - 1; i >= 0; i--) {
            if (nums[i] == target) {
                result++;
            } else {
                break;
            }
        }

        for (int i = p + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    private int find(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int m = (s + e) / 2;
        while (s <= e) {
            if (nums[m] > target) {
                e = m - 1;
            } else if (nums[m] < target) {
                s = m + 1;
            } else {
                return m;
            }
            m = (s + e) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        Question5301 question5301 = new Question5301();
        int[] nums = new int[]{1, 2, 3, 3};
        int i = question5301.search(nums, 3);
        System.out.println(i);
    }
}
