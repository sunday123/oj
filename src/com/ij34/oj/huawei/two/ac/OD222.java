package com.ij34.oj.huawei.two.ac;

import java.util.Scanner;

/**
 * 素数之积
 * https://hydro.ac/d/HWOD2023/p/OD222
 * @Author: ij34
 * @Date: 2024-06-08
 */

public class OD222 {
    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        int max = (int) Math.sqrt(num);
        for (int i=2;i<=max;i++){
            int j = num/i;
            if (prime(i)==false || i*j!=num || prime(j)==false){
                continue;
            }
            System.out.println(i+" "+j);
            return;

        }
        System.out.println("-1 -1");

    }

    private static boolean prime(int num) {
        for (int i=2;i<=Math.sqrt(num);i++){
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
}
