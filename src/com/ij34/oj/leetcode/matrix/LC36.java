package com.ij34.oj.leetcode.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. 有效的数独
 * https://leetcode.cn/problems/valid-sudoku
 *
 * @Author: ij34
 * @Date: 2024-08-06
 */

public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int k = (i / 3) * 3 + (j / 3);
                if (!rows[i].add(board[i][j]) || !cols[j].add(board[i][j]) || !boxes[k].add(board[i][j])) {
                    return false;
                }

            }
        }
        return true;
    }

}
