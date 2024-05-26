package com.ij34.oj.huawei;

import java.util.*;

/**
 * 发广播
 * https://hydro.ac/d/HWOD2023/p/OCR003
 * @Author: ij34
 * @Date: 2024-05-13
 */

public class BroadcastSender  {
    public static void main(String[] args) {
        String[] s = new Scanner(System.in).nextLine().split(",");
        int n = s.length,m=s[0].length();
        int[][] a = new int[n][m];
        boolean[] visited = new boolean[n];
        for (int i=0;i<n;i++){
            a[i] =  Arrays.stream(s[i].split("")).mapToInt(Integer::parseInt).toArray();
        }
        int res =0;
        for(int i=0;i<a.length;i++){
            if (visited[i]==false){
                res++;
                dfs(a,i,visited);
            }

        }
        System.out.println(res);
    }

    private static void dfs(int[][] a, int start,boolean[] visited) {
         visited[start]=true;
         for (int j=0;j<a[0].length;j++){
             if (a[start][j]==1 && visited[j]==false){
                 dfs(a,j,visited);
             }
         }
    }
}
