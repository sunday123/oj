package com.ij34.oj.huawei.one.ac;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 找朋友
 * https://hydro.ac/d/HWOD2023/p/OD211
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD211 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        for (int i=0;i<a.length-1;i++){
            boolean isFind=false;
            for (int j=i+1;j<a.length;j++){
                if (a[j]>a[i]){
                    isFind=true;
                    a[i]=j;
                    break;
                }
            }
            if (isFind==false){
                a[i]=0;
            }
        }
        a[a.length-1]=0;
        System.out.println(Arrays.stream(a).boxed().map(String::valueOf).collect(Collectors.joining(" ")));;
    }
}
