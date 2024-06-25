package com.ij34.oj.leetcode.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1190. 反转每对括号间的子串
 * https://leetcode.cn/problems/reverse-substrings-between-each-pair-of-parentheses/
 *
 * @Author: ij34
 * @Date: 2024-06-23
 */

public class LC1190 {
    public static void main(String[] args) {
        String s="vdgzyj()";
//        System.out.println(reverseParentheses(s));
    }

    public String reverseParentheses(String s) {
        while (s.contains("(")){

            Matcher matcher = Pattern.compile("\\([a-z]+\\)").matcher(s);
            if (matcher.find()){
                String str = matcher.group();
                StringBuilder sb = new StringBuilder(str.substring(1,str.length()-1));
                s=s.replace(str,sb.reverse().toString());
            }
            s=s.replaceAll("\\(\\)","");

        }
        return s;

    }


}
