package com.ij34.oj.leetcode.win;

/**
 * 1208. 尽可能使字符串相等
 * https://leetcode.cn/problems/get-equal-substrings-within-budget/
 *
 * @Author: ij34
 * @Date: 2024-07-09
 */

public class LC1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int len=s.length();
        int[] a = new int[len];
        for (int i=0;i<s.length();i++){
            int b=s.charAt(i)-'a';
            int c=t.charAt(i)-'a';
            a[i]=Math.abs(b-c);
        }
        int maxLen=0,l=0,r=0,winSum=0;
        while (r<len){
            winSum+=a[r];
            while (winSum>maxCost){
                winSum-=a[l];
                l++;
            }
            r++;
            maxLen=Math.max(maxLen,r-l);
        }
        return maxLen;

    }

}
