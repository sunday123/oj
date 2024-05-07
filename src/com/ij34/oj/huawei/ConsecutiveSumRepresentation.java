package com.ij34.oj.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 用连续自然数之和来表达整数
 * @Author: ij34
 * @Date: 2024-05-06
 */

public class ConsecutiveSumRepresentation {
    public static void main(String[] args) {
        int sum = new Scanner(System.in).nextInt();
        int cout =0;
        for (int n=1;n<=sum;n++){
            double a1 = ((2.0*sum/n) -n+1)/2.0;
            int b = (int) a1;
            if (a1==b && a1>0){
                cout++;
                List<Integer> list = new ArrayList<>();
                for (int i=0;i<n;i++){
                    list.add(b+i);
                }
                System.out.println(sum+"="+list.stream().map(Objects::toString).collect(Collectors.joining("+")));
            }
        }
        System.out.println("Result:"+cout);

    }
}
