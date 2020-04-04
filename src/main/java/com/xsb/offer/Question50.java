package com.xsb.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shibao.xing
 * @since 2020-04-04 19:41
 *
 * 题目：第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class Question50 {

    public char firstUniqChar(String s) {
        // 字符类可以做map的key
        // 这个地方用Boolean做值也很巧妙，比用Integer计数做值要节省空间
        Map<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, !map.containsKey(aChar));
        }
        for (char aChar : chars) {
            if (map.get(aChar)) {
                return aChar;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Question50 question50 = new Question50();
        char c = question50.firstUniqChar("abaccdeff");
        c = question50.firstUniqChar("");
        System.out.println(c);
    }
}
