package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-05 12:31
 *
 * 题目：替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class Question5 {

    public String replaceSpace(String s) {
        if (s == null) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar != ' ') {
                sb.append(aChar);
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        Question5 question5 = new Question5();
        String s1 = question5.replaceSpace(s);
        System.out.println(s1);
    }
}
