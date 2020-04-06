package com.xsb.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shibao.xing
 * @since 2020-04-06 11:55
 *
 * 题目：和为s的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 */
public class Question5702 {

    /**
     * 暴力解法
     */
    public List<List<Integer>> findContinuousSequence1(int target) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 1;
        while (true) {
            int i = start;
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            while (true) {
                sum += i;
                list.add(i);
                if (sum > target) {
                    break;
                } else if (sum == target) {
                    result.add(list);
                    break;
                }
                i++;
            }
            start++;
            if (start + (start + 1) > target) {
                break;
            }
        }
        return result;
    }

    /**
     * 滑动窗口解法
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        int i = 1;
        int j = 1;
        int sum = 0;

        while (i <= target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                result.add(arr);
                sum -= i;
                i++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Question5702 question5702 = new Question5702();
        int[][] continuousSequence = question5702.findContinuousSequence(15);
        for (int[] ints : continuousSequence) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
