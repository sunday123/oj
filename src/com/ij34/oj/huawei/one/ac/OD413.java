package com.ij34.oj.huawei.one.ac;

import java.util.*;

/**
 * 测试用例执行计划
 * https://hydro.ac/d/HWOD2023/p/OD413
 *
 * @Author: ij34
 * @Date: 2024-06-17
 */

public class OD413 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nm = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=nm[0],m=nm[1];
        int[] score = new int[n+1];
        for (int i=1;i<=n;i++){
            score[i]=Integer.valueOf(sc.nextLine());
        }
        List<int[]> list = new ArrayList<>();
        for (int i=1;i<=m;i++){
            int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            for (int aa:a){
                sum+=score[aa];
            }
            list.add(new int[]{i,sum});
        }
        list.sort((a, b) -> {
            if (a[1]!=b[1]){
                return b[1]-a[1];
            }
            return a[1]-b[1];
        });
        list.forEach(l->{
            System.out.println(l[0]);
        });

    }

}
