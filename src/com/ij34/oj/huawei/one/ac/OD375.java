package com.ij34.oj.huawei.one.ac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 机场航班调度程序
 * https://hydro.ac/d/HWOD2023/p/OD375
 *
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD375 {
    public static void main(String[] args) {
        String[] s = new Scanner(System.in).nextLine().split(",");
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int c=a.substring(0,2).compareTo(b.substring(0,2));
                if (c==0){
                    return a.substring(2).compareTo(b.substring(2));
                }
                return c;
            }
        });
        System.out.println(Arrays.stream(s).collect(Collectors.joining(",")));


    }
}
