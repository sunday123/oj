package com.ij34.oj.huawei.one;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 字符串排序
 * @Author: ij34
 * @Date: 2024-05-07
 */

public class StrSorter {

    public static void main(String[] args) {
        String[] a= new Scanner(System.in).nextLine().split(" ");
        List<String> list = Arrays.stream(a).toList();
        a=Arrays.stream(a).sorted((b, c)->{
            if (b.equalsIgnoreCase(c)){
                return b.compareTo(c);
            }
            return b.toUpperCase().compareTo(c.toUpperCase());
        }).toArray(String[]::new);
        if (a.length<2){
            System.out.println(a[0]);
        }
        for (int i=1;i<a.length;i++){
            if (a[i].equalsIgnoreCase(a[i-1])){
               if (list.indexOf(a[i-1]) < list.indexOf(a[i])){
                   a[i]=a[i-1];
               }
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
