package com.ij34.oj.leetcode.str;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author: ij34
 * @Date: 2024-07-10
 */

public class LC43 {
    public String multiply(String num1, String num2) {
        int[] a=new int[num1.length()+num2.length()];
        for (int i=num1.length()-1;i>=0;i--){
            for (int j=num2.length()-1;j>=0;j--){
                int temp=(num1.charAt(i)-'0')*(num2.charAt(j)-'0')+a[i+j+1];
                a[i+j+1]=temp%10;
                a[i+j]+=temp/10;
            }

        }
        String res = Arrays.stream(a).boxed().map(String::valueOf).collect(Collectors.joining());
        while (res.charAt(0)=='0' && res.length()>1){
            res=res.substring(1);
        }
        return res;


    }
}
