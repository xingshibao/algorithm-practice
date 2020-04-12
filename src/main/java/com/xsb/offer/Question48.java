package com.xsb.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shibao.xing
 * @since 2020-04-12 12:32
 *
 * 题目：最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class Question48 {

    public int lengthOfLongestSubstring(String s) {
        int maxLenth = 0;
        int i = 0;
        int j = 0;

        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLenth = Math.max(maxLenth, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLenth;
    }

    public static void main(String[] args) {
        Question48 question48 = new Question48();
        int n = question48.lengthOfLongestSubstring("abcabcbb");
        n = question48.lengthOfLongestSubstring("a");
        System.out.println(n);
    }
}
