package com.xsb.offer;

import java.util.Arrays;

/**
 * @author shibao.xing
 * @since 2020-04-11 18:55
 */
public class Question51 {

    private int count;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        mergeSort(nums, 0, nums.length - 1);
        return this.count;
    }

    private void mergeSort(int[] num, int s, int e) {
        if (s >= e) {
            return;
        }

        int m = (s + e) / 2;
        mergeSort(num, s, m);
        mergeSort(num, m + 1, e);
        merge(num, s, m, m + 1, e);
    }

    private void merge(int[] a, int s, int q, int i, int e) {
        int[] tmp = new int[e - s + 1];
        int position = 0;
        int kk = s;
        while (s <= q && i <= e) {
            if (a[s] < a[i]) {
                tmp[position++] = a[s++];
            } else {
                count += (e - i + 1);
                tmp[position++] = a[i++];
            }
        }

        while (s <= q) {
            tmp[position++] = a[s++];
        }
        while (i <= e) {
            tmp[position++] = a[i++];
        }

        for (int k = 0; k < tmp.length; k++) {
            a[kk + k] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 3, 2, 3, 1};
        Question51 question51 = new Question51();
        question51.mergeSort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
        System.out.println(question51.count);
    }
}
