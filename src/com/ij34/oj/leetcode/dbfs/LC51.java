package com.ij34.oj.leetcode.dbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 51. N 皇后
 * https://leetcode.cn/problems/n-queens/
 *
 * @Author: ij34
 * @Date: 2024-06-26
 */

public class LC51 {

    public List<List<String>> solveNQueens(int n) {
        if (n==1){
            return List.of(List.of("Q"));
        }else if (List.of(2,3).contains(n)){
            return List.of();
        }
        int[] match = new int[n];//每行对应的列号
        Arrays.fill(match,-1);
        m=n;
        resList=new ArrayList<>();
        dfs(match,0);
        return resList;
    }

    private void dfs(int[] match, int row) {
        if (row==m){
            resList.add(new ArrayList<>(print(match)));
            return;
        }

        for (int col=0;col<m;col++){
            if (check(match,row,col)){
                match[row]=col;
                dfs(match,row+1);
                match[row]=-1;
            }
        }


    }

    private List<String> print(int[] match) {
        List<String> list = new ArrayList<>();
        for (int i=0;i<m;i++){
            char[] cs = new char[m];
            Arrays.fill(cs,'.');
            cs[match[i]]='Q';
            list.add(new String(cs));
        }
        return list;

    }

    private boolean check(int[] match, int row, int col) {
        for (int i=0;i<m;i++){
           if (match[i]!=-1){
               if (match[i]==col || match[i]-i==col-row || match[i]+i==col+row){
                   return false;
               }
           }
        }
        return true;
    }

    private int m;
    private List<List<String>> resList;


}
