package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 跳格子3
 * https://hydro.ac/d/HWOD2023/p/OD394
 *
 * @Author: ij34
 * @Date: 2024-06-12
 */

public class OD394 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int k=Integer.valueOf(sc.nextLine());
        int[] dp = new int[a.length];
        dp[0]=a[0];
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        for (int i=1;i<a.length;i++){

            while (list.size()>0 &&  i-k>list.getFirst()){
                list.removeFirst();
            }
            if (list.size()>0){
                dp[i]=a[i]+dp[list.getFirst()];
            }

            while (list.size()>0 && dp[i]>=dp[list.getLast()]){
                list.removeLast();
            }
            list.addLast(i);
        }
        System.out.println(dp[n-1]);
    }
}
