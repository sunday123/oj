package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 贪吃的猴子
 * https://hydro.ac/d/HWOD2023/p/OD399
 * @Author: ij34
 * @Date: 2024-06-04
 */

public class OD399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.valueOf(sc.nextLine());
        int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n =Integer.valueOf(sc.nextLine());
        if (n>=len){
            System.out.println(Arrays.stream(numbers).sum());
            return;
        }
        int[] a = new int[len+1],b=new int[len+1];
        for (int i=1;i<=len;i++){
            a[i]=numbers[i-1] + a[i-1];
            int j=len-i;
            b[j]=numbers[j] + b[j+1];
        }
        int res=0;
        for (int left =0;left<=n;left++){
            int right = n-left;
            int sum = a[left] + b[len-right];
            res=res>sum?res:sum;
        }
        System.out.println(res);
    }
}
