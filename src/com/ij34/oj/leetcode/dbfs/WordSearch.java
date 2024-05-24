package com.ij34.oj.leetcode.dbfs;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 79. 单词搜索
 * https://leetcode.cn/problems/word-search/
 * @Author: ij34
 * @Date: 2024-05-24
 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    b = false;
                    char[][] a = copy(board);
                    exist2(a, i, j, '1', word.substring(1), dir);
                    if (b) {
                        return true;
                    }
                }

            }
        }

        return false;
    }

    private char[][] copy(char[][] board) {
        char[][] a = new char[board.length][];
        for (int t = 0; t < board.length; t++) {
            a[t] = board[t].clone();
        }
        return a;
    }

    private boolean b = false;

    private void exist2(char[][] a, int x, int y, char cur, String word, int[][] dir) {
        if (word.length() < 1) {
            b = true;
            return;
        }
        a[x][y] = Character.MIN_VALUE;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for (int[] d : dir) {
            int x2 = x + d[0], y2 = y + d[1];
            if (x2 < 0 || y2 < 0 || x2 >= a.length || y2 >= a[0].length) {
                continue;
            }

            if (a[x2][y2] == word.charAt(0)) {
                exist2(copy(a), x2, y2, word.charAt(0), word.substring(1), dir);
                if (b) {
                    return;
                }
            }

        }
    }

    //或者第三方的代码
    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // Mark as visited

        // Explore neighbors
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            if (dfs(board, i + dir[0], j + dir[1], word, index + 1)) {
                return true;
            }
        }

        board[i][j] = temp; // Restore original character
        return false;
    }


}
