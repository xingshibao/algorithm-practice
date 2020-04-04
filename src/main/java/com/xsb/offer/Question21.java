package com.xsb.offer;

import java.util.Arrays;

/**
 * @author shibao.xing
 * @since 2020-04-04 15:31
 *
 * 题目：调整数组顺序使奇数位于偶数前面
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class Question21 {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int even = 0;
        int odd = nums.length - 1;
        while (true) {
            while (even < odd && nums[even] % 2 == 1) {
                even++;
            }
            while (even < odd && nums[odd] % 2 == 0) {
                odd--;
            }
            if (even < odd) {
                int tmp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = tmp;
                odd--;
                even++;
            } else {
                break;
            }

        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 2, 2, 1, 5, 7, 23, 4, 8, 86};
        Question21 question21 = new Question21();
        int[] exchange = question21.exchange(a);
        System.out.println(Arrays.toString(exchange));
    }
}
