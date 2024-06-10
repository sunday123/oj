package com.ij34.oj.huawei.two.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 火星文计算2
 * https://hydro.ac/d/HWOD2023/p/OD417
 * @Author: ij34
 * @Date: 2024-06-02
 */

public class OD417 {
    public static void main(String[] args) {
        String str =  new Scanner(System.in).nextLine();

        Matcher matcher;
        while (str.contains("#")){
            matcher = Pattern.compile("\\d+#\\d+").matcher(str);
            if (matcher.find()){
                String pre =matcher.group();
                long x = Long.valueOf(pre.substring(0,pre.indexOf('#')));
                long y = Long.valueOf(pre.substring(pre.indexOf('#')+1));
                long sum = 4*x+3*y+2;
                str=str.replaceFirst(x+"#"+y,String.valueOf(sum));
            }
        }

        while (str.contains("$")){
            matcher = Pattern.compile("\\d+\\$\\d+").matcher(str);
            if (matcher.find()){
                String pre =matcher.group();
                long x = Long.valueOf(pre.substring(0,pre.indexOf('$')));
                long y = Long.valueOf(pre.substring(pre.indexOf('$')+1));
                long sum = 2*x+y+3;
                str =str.replaceFirst(x+"\\$"+y,String.valueOf(sum));
            }

        }

        System.out.println(str);
    }
}
