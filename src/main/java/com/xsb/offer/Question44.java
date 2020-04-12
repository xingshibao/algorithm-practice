package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-12 09:27
 *
 * 题目：数字序列中某一位的数字
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 */
public class Question44 {

    public int findNthDigit(int n) {
        long base = 9;
        int digits = 1;
        while (n - base * digits > 0) {
            n -= base * digits;
            base *= 10;
            digits++;
        }

        long num = 1;
        for (int i = 1; i < digits; i++) {
            num *= 10;
        }

        num += (n - digits) / digits;
        int y = n % digits;
        if (y != 0) {
            num++;
        }
        if (y == 0) {
            y = digits - 1;
        } else {
            y = y - 1;
        }
        return String.valueOf(num).toCharArray()[y] - '0';
    }

    public static void main(String[] args) {
        Question44 question44 = new Question44();
        int nthDigit = question44.findNthDigit(2147483647);
        System.out.println(nthDigit);
    }
}
