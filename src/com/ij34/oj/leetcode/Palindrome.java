package com.ij34.oj.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证回文串
 * https://leetcode.cn/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
 * @Author: ij34
 * @Date: 2024-05-09
 */

public class Palindrome {
    public boolean isPalindrome(String s) {
        if (s.length()<2){
            return true;
        }
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile("[a-zA-Z0-9]+");
        Matcher m =p.matcher(s);
        while (m.find()){
            sb.append(m.group().toLowerCase());
        }
        if (sb.length()<2){
            return true;
        }
        int len =sb.length();
        for (int i=0;i<len/2;i++){
            if (sb.charAt(i)!=sb.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}
