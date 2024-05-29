package com.ij34.oj.huawei;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 火星文计算
 * @Author: ij34
 * @Date: 2024-05-04
 */

public class MartianTextCalculator {
    public static void main(String[] args) {

        String input= new Scanner(System.in).nextLine();//"123#4$5#67$78";



        while (input.contains("$")){
            Pattern pattern = Pattern.compile("\\d+\\$\\d+");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String str =matcher.group();
                int [] a= Arrays.stream(str.split("\\$")).mapToInt(Integer::parseInt).toArray();
                int x =a[0],y=a[1];
                int sum =3*x+y+2;
                input=input.replace(str,String.valueOf(sum));
            }
        }

        while (input.contains("#")){
            Pattern pattern = Pattern.compile("\\d+\\#\\d+");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String str =matcher.group();
                int [] a= Arrays.stream(str.split("\\#")).mapToInt(Integer::parseInt).toArray();
                long x =a[0],y=a[1];
                long sum =(2*x)+(3*y)+4;
                input=input.replace(str,String.valueOf(sum));
            }
        }



        System.out.println(input);



    }
}
