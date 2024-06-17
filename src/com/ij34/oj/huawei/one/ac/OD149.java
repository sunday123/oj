package com.ij34.oj.huawei.one.ac;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 求字符串中所有整数的最小和
 * https://hydro.ac/d/HWOD2023/p/OD149
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD149 {
    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("[0-9\\-]+").matcher(new Scanner(System.in).nextLine());
        long sum=0;
        while (matcher.find()){
            String str = matcher.group();
            if (str.length()==1 && str.equals("-")==false){
                sum+=Integer.valueOf(str);
                continue;
            }
            Matcher matcher2 = Pattern.compile("\\-[0-9]+").matcher(str);
            while (matcher2.find()){
                sum+=Long.valueOf(matcher2.group());
            }
            int i=0;
            while (i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9'){
                sum+=str.charAt(i)-'0';
                i++;
            }

        }
        System.out.println(sum);

    }
}

