package com.xsb.offer;

import java.util.Arrays;

/**
 * @author shibao.xing
 * @since 2020-04-06 09:16
 *
 * 题目：I. 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class Question5601 {

    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return new int[0];
        }
        int partition = 0;
        for (int num : nums) {
            partition ^= num;
        }
        int finalPartition = 1;
        for (int i = 0; i < 31; i++) {
            if ((partition & finalPartition) == finalPartition) {
                break;
            } else {
                finalPartition <<= 1;
            }
        }

        System.out.println(finalPartition);

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & finalPartition) == finalPartition) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        Question5601 question5601 = new Question5601();
        int[] num = new int[]{1, 2, 5, 2};
        int[] ints = question5601.singleNumbers(num);
        System.out.println(Arrays.toString(ints));
    }
}
