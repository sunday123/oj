package com.ij34.oj.leetcode.dp;

import java.util.Arrays;

/**
 * 1143. 最长公共子序列
 * https://leetcode.cn/problems/longest-common-subsequence/description/
 * @Author: ij34
 * @Date: 2024-05-09
 */

public class LongestCommonSubsequenceOj {
    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("abcde",  "ace")==3);
//        System.out.println(longestCommonSubsequence("abc",  "def")==0);
//        System.out.println(longestCommonSubsequence("abc",  "abc")==3);
//        System.out.println(longestCommonSubsequence("bsbininm",  "jmjkbkjkv")==1);
//        System.out.println(longestCommonSubsequence("ylqpejqbalahwr",  "yrkzavgdmdgtqpg")==3);
//        System.out.println(longestCommonSubsequence("qrsvwf",  "shmtulqrypy")==2);
//        System.out.println(longestCommonSubsequence("accddgeafdsv",  "aadgvaregbtrdce")==5);



//        System.out.println(longestCommonSubsequenceStr("abcde",  "ace").length()==3);
//        System.out.println(longestCommonSubsequenceStr("abc",  "def").length()==0);
//        System.out.println(longestCommonSubsequenceStr("abc",  "abc").length()==3);
//        System.out.println(longestCommonSubsequenceStr("bsbininm",  "jmjkbkjkv").length()==1);
//        System.out.println(longestCommonSubsequenceStr("ylqpejqbalahwr",  "yrkzavgdmdgtqpg").length()==3);
//        System.out.println(longestCommonSubsequenceStr("qrsvwf",  "shmtulqrypy").length()==2);
//        System.out.println(longestCommonSubsequenceStr("accddgeafdsv",  "aadgvaregbtrdce").length()==5);
        System.out.println(longestCommonSubsequenceStr("intention","execution").length());
        System.out.println("intention".length());
        System.out.println("execution".length());
    }
    public static String longestCommonSubsequenceStr(String text1, String text2) {
        String[][] a = new String[text1.length()+1][text2.length()+1];
        for (int i=0;i<a.length;i++){
            Arrays.fill(a[i],"");
        }
        for (int i=1;i<=text1.length();i++){
            for (int j=1;j<=text2.length();j++){
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    a[i][j]= a[i-1][j-1]+text1.charAt(i-1);
                }else {
                    a[i][j]=a[i-1][j].length()>a[i][j-1].length()?a[i-1][j]:a[i][j-1];
                }

            }
        }

       for (String[] aa:a){
           System.out.println(Arrays.toString(aa));
       }
        return a[text1.length()][text2.length()];

    }


    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] a = new int[text1.length()+1][text2.length()+1];
        for (int i=1;i<=text1.length();i++){
            for (int j=1;j<=text2.length();j++){
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    a[i][j]= a[i-1][j-1]+1;
                }else {
                    a[i][j]=Math.max(a[i-1][j],a[i][j-1]);
                }

            }
        }
        return a[text1.length()][text2.length()];
    }
}
