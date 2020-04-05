package com.xsb.offer;

import java.util.Arrays;

/**
 * @author shibao.xing
 * @since 2020-04-05 11:08
 *
 * 题目：最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class Question40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        int s = 0;
        int e = arr.length - 1;
        int pivot = partition(arr, s, e);
        while (pivot != k - 1) {
            if (pivot > k - 1) {
                e = pivot - 1;
                pivot = partition(arr, s, e);
            } else {
                s = pivot + 1;
                pivot = partition(arr, s, e);
            }
        }
        int[] result = new int[k];
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }

    private int partition(int[] arr, int s, int e) {
        int pivot = arr[e];
        int i = s;
        for (int j = s; j <= e - 1 ; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, e);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void sort(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }

        int partition = partition(arr, s, e);
        sort(arr, s, partition - 1);
        sort(arr, partition + 1, e);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,2,4,2,2,3,1,4};
//        int[] arr = new int[]{3};
        Question40 question40 = new Question40();
//        question40.sort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));

        int[] leastNumbers = question40.getLeastNumbers(arr, 8);
        System.out.println(Arrays.toString(leastNumbers));
    }
}
