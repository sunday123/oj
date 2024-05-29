package com.ij34.oj.huawei.one;

import java.util.Scanner;

/**
 * OD258. 字符串序列判定
 * https://hydro.ac/d/HWOD2023/p/OD258
 * @Author: ij34
 * @Date: 2024-05-28
 */

public class StringSequenceChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(),l=sc.nextLine();
        System.out.println(doIt(s,l));

    }

    private static int doIt(String s, String l) {
        if (s==null || l==null || s.isEmpty() || l.isEmpty() || s.length()>l.length()){
            return -1;
        }
        int i =0,j=0;
        int res = -1;//S=”ace”是L=”abpdo”的一个子序列且有效字符是a
        while(i<s.length() && j<l.length()){
            if (s.charAt(i)==l.charAt(j)){
                res=j;
                i++;
            }
            j++;

        }
        return res;
    }

}
