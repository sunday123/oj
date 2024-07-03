package com.ij34.oj.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 647. 回文子串
 * https://leetcode.cn/problems/palindromic-substrings
 *
 * abcba
 * 如果字符相等，相邻1个元素以内，必然是回文
 * 如果字符相等，比如第一个a和最后一个a，就判断bcb是否为回文。
 *
 * @Author: ij34
 * @Date: 2024-07-03
 */

public class LC647 {
    public int countSubstrings(String s) {
        int len=s.length();
        boolean[][] dp = new boolean[len][len];
        int count=0;
        for (int i=len-1;i>=0;i--){
            for (int j=i;j<len;j++){
                if (j-i<2 && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                    count++;
                }else if (s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                    count++;

                }
            }
        }

        return count;

    }
}
