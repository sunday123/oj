package com.ij34.oj.leetcode;

import java.util.Arrays;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 * https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts
 * @Author: ij34
 * @Date: 2024-05-11
 */

public class FindTheLongestSubstring {

    public int findTheLongestSubstring(String s) {
        char[]  a = new char[]{ 'a','e','i','o','u' };
        if (s.length()<2){
            return "aeiou".contains(s)?0:1;
        }

        int lastIndex=s.length()-1;
        while (lastIndex>=0){
            for (int i=0;(i+lastIndex)<s.length();i++){
                String str = s.substring(i,i+lastIndex+1);
                boolean flag=true;
                for(char c: a) {
                    flag=flag && isIncludeDouble(str,c);
                    if (flag==false){
                        break;
                    }
                }
                if (flag){
                    return lastIndex+1;
                }
            }
            lastIndex--;
        }
        return 1;
    }

    private boolean isIncludeDouble(String str, char target) {
        int n=0;
        for (char c : str.toCharArray()){
            if (target == c){
                n++;
            }
        }
        return n%2==0;
    }

}
