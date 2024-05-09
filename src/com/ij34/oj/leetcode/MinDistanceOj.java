package com.ij34.oj.leetcode;

import java.util.Arrays;

/**
 * 72. 编辑距离
 * https://leetcode.cn/problems/edit-distance/?envType=study-plan-v2&envId=top-100-liked
 * @Author: ij34
 * @Date: 2024-05-09
 */

public class MinDistanceOj {
    public static void main(String[] args) {
        System.out.println(new MinDistanceOj().minDistance("horse","ros"));
    }


    public int minDistance(String word1, String word2) {
        int[][] a = new int[word1.length()+1][word2.length()+1];
        for (int i=0;i<=word1.length();i++){
            a[i][0]=i;
        }
        for (int j=0;j<=word2.length();j++){
            a[0][j]=j;
        }

        for (int i=1;i<=word1.length();i++){
            for (int j=1;j<=word2.length();j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    a[i][j]= a[i-1][j-1];
                }else {
                    a[i][j]=Math.min(a[i-1][j],Math.min(a[i-1][j-1],a[i][j-1]))+1;
                }

            }
        }

        return a[word1.length()][word2.length()];
    }

}
