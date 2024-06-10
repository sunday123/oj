package com.ij34.oj.huawei.one.ac;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 提取字符串中的最长合法简单数学表达式
 * https://hydro.ac/d/HWOD2023/p/OD340
 *
 * 很难理解： 只有一个整数+整数，而且前后可以有+-*符号
 *
 * @Author: ij34
 * @Date: 2024-06-10
 */

public class OD340 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String regex = "([+\\-*]?)(\\d+[+\\-*]\\d+)([+\\-*]?)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String max="";
        while (matcher.find()) {
            String str = matcher.group();
            max=str;
            break;
        }
        if (max.length()<1){
            System.out.println(0);
            return;
        }
        if (List.of('+','*').contains(max.charAt(0))){
            max=max.substring(1);
        }

        if (List.of('+','-','*').contains(max.charAt(max.length()-1))){
            max=max.substring(0,max.length()-1);
        }
        System.out.println(evl(max));

    }

    private static long evl(String str) {
        int index=0;
        char sign='+';
         for (int i=1;i<str.length();i++){
             if (List.of('+','-','*').contains(str.charAt(i))){
                 index=i;
                 sign=str.charAt(i);
                 break;
             }
         }
         if (sign=='*'){
             return Long.parseLong(str.substring(0,index))*Long.parseLong(str.substring(index+1));
         }else if (sign=='+'){
             return Long.parseLong(str.substring(0,index))+Long.parseLong(str.substring(index+1));
         }else if (sign=='-'){
             return Long.parseLong(str.substring(0,index))-Long.parseLong(str.substring(index+1));
         }
         return 0;
    }

}
