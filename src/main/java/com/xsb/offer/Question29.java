package com.xsb.offer;

import java.util.Arrays;

/**
 * @author shibao.xing
 * @since 2020-04-04 10:55
 *
 * 题目：面试题29. 顺时针打印矩阵
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class Question29 {

    public static void main(String[] args) {
//        int[][] a = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
//        int[][] a = new int[][]{{1,2,3}};
//        int[][] a = new int[][]{{1}, {2}, {3}};
        int[][] a = new int[][]{{}};
        Question29 question29 = new Question29();
        int[] r = question29.spiralOrder(a);
        System.out.println(Arrays.toString(r));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int line = matrix.length;
        int column = matrix[0].length;
        int count = line * column;

        int right = column - 1;
        int left = 0;
        int up = 1;
        int down = line - 1;

        int[] result = new int[count];
        int i = 0;
        int j = 0;
        // 右1，下2，左3，上4
        int direction = 1;
        for (int k = 0; k < count; k++) {
            result[k] = matrix[i][j];
            if (direction == 1) {
                if (j < right) {
                    j++;
                } else {
                    right--;
                    direction = 2;
                }
            }
            if (direction == 2) {
                if (i < down) {
                    i++;
                } else {
                    down--;
                    direction = 3;
                }
            }
            if (direction == 3) {
                if (j > left) {
                    j--;
                } else {
                    left++;
                    direction = 4;
                }
            }
            if (direction == 4) {
                if (i > up) {
                    i--;
                } else {
                    j++;
                    up++;
                    direction = 1;
                }
            }
        }
        return result;
    }
}
