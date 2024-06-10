package com.ij34.oj.huawei.two.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 数的分解
 * https://hydro.ac/d/HWOD2023/p/OD382
 * @Author: ij34
 * @Date: 2024-06-02
 */

public class OD382 {
    public static void main(String[] args) {
        long sum =new Scanner(System.in).nextLong();
        if (sum>Integer.MAX_VALUE){
            System.out.println("N");
            return;
        }
        for (int m=2;m<sum;m++){
            double a = ((2.0*sum)/m - m+1)/2.0;
            int b= (int) a;
            if (a==b){
                List<Integer> list = new ArrayList<>();
                for (int i=0;i<m;i++){
                    list.add(b++);
                }
                System.out.println(sum+"="+list.stream().map(String::valueOf).collect(Collectors.joining("+")));
                return;
            }

        }
        System.out.println("N");

    }
}
