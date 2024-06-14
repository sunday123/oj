package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 两个字符串间的最短路径问题
 * https://hydro.ac/d/HWOD2023/p/OD407
 *
 * @Author: ij34
 * @Date: 2024-06-14
 */

public class OD407 {
    public static void main(String[] args) {
        String[] str = new Scanner(System.in).nextLine().split(" ");
        List<Integer> aList = new ArrayList<>(Arrays.stream(str[0].split("")).map(m->m.charAt(0)-'A').toList());
        List<Integer> bList = new ArrayList<>(Arrays.stream(str[1].split("")).map(m->m.charAt(0)-'A').toList());
        int[][] dp = new int[aList.size()+1][bList.size()+1];
        for (int i=0;i<=aList.size();i++){
            dp[i][0]=i;
        }
        for (int j=0;j<=bList.size();j++){
            dp[0][j]=j;
        }

        for (int i=1;i<=aList.size();i++){
            for (int j=1;j<=bList.size();j++){
                if (aList.get(i-1).equals(bList.get(j-1))){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;
                }
            }
        }

        System.out.println(dp[aList.size()][bList.size()]);


    }
}
