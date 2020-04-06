package com.xsb.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shibao.xing
 * @since 2020-04-06 13:29
 *
 * 题目：把数组排成最小的数
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class Question45 {

    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        List<String> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        return String.join("", list);
    }

    public static void main(String[] args) {
        Question45 question45 = new Question45();
        int[] num = new int[]{3, 30, 34, 5, 9};
        String s = question45.minNumber(num);
        System.out.println(s);
    }
}
