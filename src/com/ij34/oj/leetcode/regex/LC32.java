package com.ij34.oj.leetcode.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 32. 最长有效括号
 * https://leetcode.cn/problems/longest-valid-parentheses
 *
 * @Author: ij34
 * @Date: 2024-06-23
 */

public class LC32 {

    public  int longestValidParentheses(String s) {
        if (s.length()<2){
            return 0;
        }
        Matcher matcher = Pattern.compile("\\([a]*\\)").matcher(s);
        while (matcher.find()){
            int i=matcher.start();
            String str= matcher.group();
            String temp="";
            for (int j=0;j<str.length();j++){
                temp+="a";
            }
            s=s.substring(0,i)+temp+s.substring(i+str.length());
            matcher = Pattern.compile("\\(a*\\)").matcher(s);
        }
        int max=0;
        matcher = Pattern.compile("a+").matcher(s);
        while (matcher.find()){
           String str=matcher.group();
            max=Math.max(str.length(),max);
        }
      return max;
    }
}
