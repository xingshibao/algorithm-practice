package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-11 17:50
 *
 * 题目：n个骰子的点数
 * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 */
public class Question60 {

    public double[] twoSum(int n) {
        int[][] states = new int[n][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            states[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j <= (i + 1) * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k >= 0) {
                        states[i][j] += states[i - 1][j - k];
                    }
                }
            }
        }

        double total = Math.pow(6, n);
        double[] result = new double[5 * n + 1];
        for (int i = n; i <= 6 * n ; i++) {
            result[i - n] = states[n - 1][i] / total;
        }
        return result;
    }

    public double[] twoSum1(int n) {
        int[][] states = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            states[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k >= 0) {
                        states[i][j] += states[i - 1][j - k];
                    }
                }
            }
        }

        double total = Math.pow(6, n);
        double[] result = new double[5 * n + 1];
        for (int i = n; i <= 6 * n ; i++) {
            result[i - n] = states[n][i] / total;
        }
        return result;
    }

    public static void main(String[] args) {
        Question60 question60 = new Question60();
    }
}
