package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 伐木工
 * @Author: ij34
 * @Date: 2024-05-07
 */

public class Woodcutter {
    public static void main(String[] args) {
        int x = new Scanner(System.in).nextInt();
        int[] dp = new int[x+1];//可分割第i长度时候最大收益
        dp[0] =1;
        for (int i=1;i<=x;i++){
            dp[i]=i;
            for (int j=1;j<i;j++){
                dp[i] = Math.max(dp[i],dp[i-j]*j);
            }
        }
        System.out.println(Arrays.toString(dp));
        List<Integer> list = new ArrayList<>();
        while (x>0){
            for (int i=1;i<=x;i++){
                if (dp[x]==dp[x-i]*i){
                    list.add(i);
                    x-=i;
                    break;
                }
            }
        }
        int[] a= list.stream().sorted().mapToInt(Integer::intValue).toArray();
        for (int i=1;i<list.size();i++){
            if (a[i]+a[i-1] == a[i]*a[i-1]){
                a[i]=a[i]+a[i-1];
                a[i-1] = 0 ;
            }
        }
        System.out.println(Arrays.stream(a).filter(f->f!=0).sorted().boxed().map(Objects::toString).collect(Collectors.joining(" ")));
    }
}
