package com.ij34.oj.huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 字符串排序
 * @Author: ij34
 * @Date: 2024-05-07
 */

public class StrSorter {
    public static void main(String[] args) {
        String[] a= Arrays.stream("i LOVE Cc I love CC Hello Hel Hellow".split(" ")).sorted((b,c)->{
            if (b.equalsIgnoreCase(c)){
                return b.compareTo(c);
            }
            return b.toUpperCase().compareTo(c.toUpperCase());
        }).toArray(String[]::new);
        System.out.println(Arrays.toString(a));
        if (a.length<2){
            System.out.println(a[0]);
        }
        for (int i=1;i<a.length;i++){
            if (a[i].equalsIgnoreCase(a[i-1])){
               a[i-1]="";
            }
        }
        String res ="";
        for (int i=0;i<a.length;i++){
            if (a[i]!=""){
                res += a[i]+" ";
            }
        }
        System.out.println(res.trim());
    }
}
