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
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(s.substring(0,1));
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
