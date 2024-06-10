package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最大坐标值、小明的幸运数
 * https://hydro.ac/d/HWOD2023/p/OD368
 * @Author: ij34
 * @Date: 2024-06-01
 */

public class OD368 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =Integer.valueOf(sc.nextLine());
        int lucky = Integer.valueOf(sc.nextLine());
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = 0;
        int cur=0;
        if (n<0 || n>100){
            System.out.println(12345);
            return;
        }
        if (lucky>100 || lucky<-100){
            System.out.println(12345);
            return;
        }
        for (int b :a){
            if (b>100 || b<-100){
                System.out.println(12345);
                return;
            }
            if (b==lucky){
                if (b>0){
                    b++;
                }else {
                    b--;
                }
            }
            cur+=b;

            max=cur>max?cur:max;
        }
        System.out.println(max);
    }
}
