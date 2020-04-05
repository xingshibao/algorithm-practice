package com.xsb.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shibao.xing
 * @since 2020-04-05 19:23
 *
 * 题目：矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 *
 * 总结：典型的回溯思想，递归实现。难点在于出错的时候，递归的写法不好排查问题，可以用栈将走过的路径记录下来，然后打印出来进行排查。
 */
public class Question12 {

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    private Deque<Point> path = new ArrayDeque<>();

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() <= 0 || board.length * board[0].length < word.length()) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean ok = ok(board, i, j, 0, chars, visited);
                if (ok) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean ok(char[][] board, int i, int j, int nowPosition, char[] chars, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (board[i][j] != chars[nowPosition]) {
            return false;
        } else {
            path.offerLast(new Point(i, j));
            if (nowPosition == chars.length - 1) {
                while (!path.isEmpty()) {
                    System.out.println(path.pollLast());
                }
                return true;
            }
            visited[i][j] = true;
            nowPosition++;
        }

        // 上
        boolean okUp = ok(board, i - 1, j, nowPosition, chars, visited);
        if (okUp) {
            return true;
        }
        // 右
        boolean okRight = ok(board, i, j + 1, nowPosition, chars, visited);
        if (okRight) {
            return true;
        }
        // 下
        boolean okDown = ok(board, i + 1, j, nowPosition, chars, visited);
        if (okDown) {
            return true;
        }
        // 左
        boolean okLeft = ok(board, i, j - 1, nowPosition, chars, visited);
        if (okLeft) {
            return true;
        }
        visited[i][j] = false;
        path.pollLast();
        return false;
    }

    public static void main(String[] args) {
        Question12 question12 = new Question12();
        char[][] board = new char[][]{
                {'a', 'a', 'a'},
                {'a', 'b', 'b'},
                {'a', 'b', 'b'},
                {'b', 'b', 'b'},
                {'b', 'b', 'b'},
                {'a', 'a', 'a'},
                {'b', 'b', 'b'},
                {'a', 'b', 'b'},
                {'a', 'a', 'b'},
                {'a', 'b', 'a'},
        };
        boolean exist = question12.exist(board, "aabaa");
        System.out.println(exist);
    }
}
