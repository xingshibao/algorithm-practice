package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-06 13:51
 *
 * 题目：扑克牌中的顺子
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
public class Question61 {

    public boolean isStraight(int[] nums) {
        if (nums == null) {
            return false;
        }
        if (nums.length <= 1) {
            return true;
        }

        boolean[] states = new boolean[14];
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                states[num] = true;
            }
        }

        int startPos = 0;
        for (int i = 1; i < 14; i++) {
            if (states[i]) {
                startPos = i;
                break;
            }
        }

        int count = 0;
        for (int i = startPos; i < 14; i++) {
            if (states[i]) {
                count++;
            } else {
                if (zeroCount > 0) {
                    zeroCount--;
                    count++;
                } else {
                    break;
                }
            }
            if (count == nums.length) {
                return true;
            }
        }
        if (count == nums.length || count == nums.length - zeroCount) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Question61 question61 = new Question61();
        int[] num = new int[]{0, 0, 11, 10, 12};
        boolean straight = question61.isStraight(num);
        System.out.println(straight);
    }
}
