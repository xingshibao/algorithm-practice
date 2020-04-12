package com.xsb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shibao.xing
 * @since 2020-04-11 22:01
 *
 * 题目：组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Question77 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        combine2(arr, 0, arr.length - 1, k, new LinkedList<>());
        return result;
    }

    /**
     * 获取数组所有可能的组合
     */
    private List<List<Integer>> combine(int[] arr, int s, int e) {
        List<List<Integer>> result = new ArrayList<>();
        if (s == e) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[s]);
            result.add(list);
            return result;
        }

        List<List<Integer>> combine = combine(arr, s + 1, e);
        if (!combine.isEmpty()) {
            for (List<Integer> integers : combine) {
                result.add(new ArrayList<>(integers));
            }
            for (List<Integer> integers : combine) {
                List<Integer> l = new ArrayList<>();
                l.add(arr[s]);
                l.addAll(integers);
                result.add(l);
            }
        }
        List<Integer> l = new ArrayList<>();
        l.add(arr[s]);
        result.add(l);
        return result;
    }

    /**
     * 回溯思想，[用过的数据需要在递归结束后删除，这个删除的时机其实不太好找]
     */
    private void combine2(int[] arr, int s, int e, int k, LinkedList<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
        }

        for (int i = s; i <= e; i++) {
            list.add(arr[i]);
            combine2(arr, i + 1, e, k, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Question77 question77 = new Question77();
        List<List<Integer>> combine = question77.combine(20, 16);
        for (List<Integer> integers : combine) {
            System.out.println(integers);
        }
        System.out.println(combine.size());
    }
}
