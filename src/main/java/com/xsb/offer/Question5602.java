package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-06 09:29
 *
 * 题目：数组中数字出现的次数 II
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 */
public class Question5602 {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 4) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int count = 0;
            for (int num : nums) {
                if ((num & mask) == mask) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                res |= mask;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question5602 question5602 = new Question5602();
        int[] nums = new int[]{3, 4, 3, 3};
        int i = question5602.singleNumber(nums);
        System.out.println(i);
    }
}
