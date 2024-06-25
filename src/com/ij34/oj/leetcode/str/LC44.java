package com.ij34.oj.leetcode.str;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 没完成
 * 44. 通配符匹配
 * https://leetcode.cn/problems/wildcard-matching/description/
 *
 * @Author: ij34
 * @Date: 2024-06-23
 */

public class LC44 {
    public static void main(String[] args) {
        //String s="abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
       // String p="**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";

        String s="";
        String p="******";
        System.out.println(isMatch(s,p));
    }
    //正则，不通过全部
    public static boolean isMatch2(String s, String p) {
        p=p.replaceAll("[*]+","*").replaceAll("\\?","[a-z]").replaceAll("\\*","\\.*");
        System.out.println(p);
        return Pattern.matches(p,s);
    }
    //dp
    public static boolean isMatch(String s, String p) {
        //前i个和前j个字符串匹配
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        for (int j=1;j<=p.length();j++){//匹配第一行多个***前缀
            if (p.charAt(j-1)=='*'){
                dp[0][j]=true;
            }else {
                break;
            }
        }
        dp[0][0]=true;

        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=p.length();j++){
//                System.out.println("hello");//打印会超时
                if (p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-1]||dp[i-1][j];
                }else if (p.charAt(j-1)=='?' || p.charAt(j-1)==s.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }
//
//        for (int i=0;i<=s.length();i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
       return dp[s.length()][p.length()];

    }
}
