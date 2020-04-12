package com.xsb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shibao.xing
 * @since 2020-04-12 08:46
 *
 * 题目：子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class Question78 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }

        subset(nums, 0, nums.length - 1, new LinkedList<>());
        return result;
    }

    private void subset(int[] arr, int s, int e, LinkedList<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int i = s; i <= e; i++) {
            list.add(arr[i]);
            subset(arr, i + 1, e, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Question78 question78 = new Question78();
        int[] arr = new int[]{1, 2, 3};
        List<List<Integer>> subsets = question78.subsets(arr);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
