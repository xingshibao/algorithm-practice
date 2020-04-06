package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-06 09:47
 *
 * 题目：数组中出现次数超过一半的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */
public class Question39 {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int s = 0;
        int e = nums.length - 1;
        int target = nums.length / 2;
        int partition = partition(nums, s, e);
        while (partition != target) {
            if (partition > target) {
                e = partition - 1;
                partition = partition(nums, s, e);
            } else {
                s = partition + 1;
                partition = partition(nums, s, e);
            }
        }
        return nums[target];
    }

    private int partition(int[] nums, int s, int e) {
        int pivot = nums[e];
        int i = s;
        for (int j = s; j < e; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, e);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
//        int[] num = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] num = new int[]{4};
        Question39 question39 = new Question39();
        int i = question39.majorityElement(num);
        System.out.println(i);
    }
}
