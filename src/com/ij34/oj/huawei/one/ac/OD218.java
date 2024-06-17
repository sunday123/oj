package com.ij34.oj.huawei.one.ac;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 字符串筛选排序
 * https://hydro.ac/d/HWOD2023/p/OD218
 *
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k=Integer.valueOf(sc.nextLine());
        String[] s =str.split("");
        Arrays.sort(s);
        char c = Arrays.stream(s).collect(Collectors.joining()).charAt(k>=s.length?s.length-1:k-1);
        System.out.println(str.indexOf(c));
    }
}
