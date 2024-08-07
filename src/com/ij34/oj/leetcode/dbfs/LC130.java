package com.ij34.oj.leetcode.dbfs;

import java.util.*;

/**
 * 130. 被围绕的区域
 * https://leetcode.cn/problems/surrounded-regions
 *
 * @Author: ij34
 * @Date: 2024-08-06
 */

public class LC130 {

    public void solve(char[][] board) {
        int n= board.length;
        int m=board[0].length;

        for (int i=0;i<n;i++){
            if (board[i][0]=='O'){
                dfs(board,i,0,n,m);
            }
            if (board[i][m-1]=='O'){
                dfs(board,i,m-1,n,m);
            }
        }

        for (int j=0;j<m;j++){
            if (board[0][j]=='O'){
                dfs(board,0,j,n,m);
            }
            if (board[n-1][j]=='O'){
                dfs(board,n-1,j,n,m);
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++){

                if (board[i][j]=='y'){
                    board[i][j]='O';
                }else if (board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }


    }

    private void dfs(char[][] board, int i, int j, int n, int m) {
        if (i<0 || i>=n || j<0 || j>=m || board[i][j]!='O'){
            return;
        }
        board[i][j]='y';
        dfs(board,i+1,j,n,m);
        dfs(board,i-1,j,n,m);
        dfs(board,i,j+1,n,m);
        dfs(board,i,j-1,n,m);

    }


}
