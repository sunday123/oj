package com.ij34.oj.leetcode.tradition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=top-interview-150
 * @Author: ij34
 * @Date: 2024-05-09
 */

public class LongestPalindrome {

   //动态规划，可以参考https://leetcode.cn/problems/palindromic-substrings/description/
    public String longestPalindrome2(String s) {
        if (s.length()<2){
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int max=Integer.MIN_VALUE,x = 0,y=0;
        for (int i=len-1;i>=0;i--){
            for (int j=i;j<len;j++){
                if (s.charAt(i)!=s.charAt(j)){
                    continue;
                }
                if (j-i<2){
                    dp[i][j]=true;
                    if (j-i>max){
                        max=j-i;
                        x=i;
                        y=j;
                    }

                }else if (dp[i+1][j-1]){
                    dp[i][j]=true;

                    if (j-i>max){
                        max=j-i;
                        x=i;
                        y=j;
                    }
                }


            }
        }
        return s.substring(x,y+1);
    }
    public String longestPalindrome(String s) {
        for (int len=s.length();len>1;len--){
            for (int start=0;start+len<=s.length();start++){
                if (isPalindrome(s,start,start+len-1)){
                    return s.substring(start,start+len);
                }
            }
        }
        return s.substring(0,1);
    }

    public boolean isPalindrome(String s,int start,int end) {
        if (end-start<1){
            return true;
        }
        int len=(end-start+1)/2;
        int i=start,j=end;
        while (len-->0){
            if (s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
