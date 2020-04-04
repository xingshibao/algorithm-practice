package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-04 19:53
 *
 * 题目：礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class Question47 {

    public int maxValue(int[][] grid) {
        int line = grid.length;
        int column = grid[0].length;
        int[][] result = new int[line][column];
        // 初始化最后一行的数据
        int sum = 0;
        for (int i = column - 1; i >= 0; i--) {
            sum += grid[line - 1][i];
            result[line - 1][i] = sum;
        }
        // 初始化最后一列的数据
        if (line - 2 >= 0) {
            sum = grid[line - 1][column - 1];
            for (int i = line - 2; i >= 0 ; i--) {
                sum += grid[i][column - 1];
                result[i][column - 1] = sum;
            }
        }

        if (line - 2 >= 0 && column - 2 >= 0) {
            for (int i = line - 2; i >= 0 ; i--) {
                for (int j = column - 2; j >= 0; j--) {
                    result[i][j] = grid[i][j] + Math.max(result[i + 1][j], result[i][j + 1]);
                }
            }
        }
        return result[0][0];
    }

    /**
     * 递归解法超时
     */
    private int subMaxValue1(int[][] grid, int i, int j) {
        int line = grid.length - 1;
        int column = grid[0].length - 1;
        int sum = 0;
        if (i == line) {
            for (int k = j; k <= column; k++) {
                sum += grid[i][k];
            }
            return sum;
        }
        if (j == column) {
            for (int k = i; k <= line; k++) {
                sum += grid[k][j];
            }
            return sum;
        }

        int a = subMaxValue1(grid, i + 1, j);
        int b = subMaxValue1(grid, i, j + 1);
        return grid[i][j] + Math.max(a, b);
    }

    public static void main(String[] args) {
        Question47 question47 = new Question47();
        int[][] matrix = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        int[][] matrix = new int[][]{{1}, {2}, {4}};
        int maxValue = question47.maxValue(matrix);
        System.out.println(maxValue);
    }
}
