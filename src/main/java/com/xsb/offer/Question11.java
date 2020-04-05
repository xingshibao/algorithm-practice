package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-05 12:47
 *
 * 题目：旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class Question11 {

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > numbers[i + 1]) {
                return Math.min(numbers[i + 1], min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Question11 question11 = new Question11();
        int[] arr = new int[]{3,4,5,1,2};
        int[] arr1 = new int[]{1, 2, 3};
        int i = question11.minArray(arr1);
        System.out.println(i);
    }
}
