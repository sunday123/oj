package com.ij34.oj.huawei.one.ac;

import java.util.Scanner;

/**
 * 执行时长
 * https://hydro.ac/d/HWOD2023/p/OD219
 *
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD219 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k= sc.nextInt(),n=sc.nextInt();
        int[] tasks = new int[n];
        for (int i=0;i<n;i++){
            tasks[i]= sc.nextInt();
        }
        int sum=0;
        int count=0;
        for (int task: tasks) {
            sum+=task;
            sum=sum>k?sum-k:0;
            count++;
        }

        count+=(sum+k-1)/k;
        System.out.println(count);

    }
}
