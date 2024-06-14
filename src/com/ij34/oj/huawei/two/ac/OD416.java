package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 寻找最优的路测线路
 * https://hydro.ac/d/HWOD2023/p/OD416
 * @Author: ij34
 * @Date: 2024-06-11
 */

public class OD416 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =Integer.valueOf(sc.nextLine()),m=Integer.valueOf(sc.nextLine());
        int[][] a = new int[n][m];
        int left=0,right=0,res=0;
        for (int i=0;i<n;i++){
            a[i]= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for (int aa:a[i]){
                right=right>aa?right:aa;
            }
        }

        while (left<=right){
            int mid =(left+right)/2;//默认是最小的
            if (bfs(a,n,m,mid)){//dfs(a,0,0,n,m,mid,new boolean[n][m])
                res=mid;
                left=mid+1;
            }else {
                right=mid-1; //找不到就变小
            }
        }


        System.out.println(res);

    }

    private static boolean bfs(int[][] a, int n, int m, int k) {
        if (a[0][0]<k || a[n-1][m-1]<k){
            return false;
        }
        boolean[][] visited= new boolean[n][m];
        LinkedList<int[]> list = new LinkedList<>();
        visited[0][0] =true;
        list.add(new int[]{0,0});
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while (list.isEmpty()==false){
            int[] poll = list.removeFirst();
            int x=poll[0],y=poll[1];
            if (x==n-1 && y==m-1){
                return true;
            }

            for (int[] d:dir){
                int i=d[0]+x,j=d[1]+y;
                if (i>=0 && j>=0 && i<n && j<m && visited[i][j]==false && a[i][j]>=k){
                    visited[i][j]=true;
                    list.offer(new int[]{i,j});
                }
            }

        }
        return false;


    }


    //数据大会超时
    private static boolean dfs(int[][] a, int i, int j, int n, int m, int k, boolean[][] visited) {
        if (i<0 || i>=n || j<0 || j>=m || visited[i][j] || a[i][j]<k){
            return false;
        }
        if (i==n-1 && j==m-1){
            return true;
        }
        visited[i][j]=true;
        boolean b= dfs(a,i+1,j,n,m,k,visited)
                ||dfs(a,i-1,j,n,m,k,visited)
                ||dfs(a,i,j+1,n,m,k,visited)
                ||dfs(a,i,j-1,n,m,k,visited);
        visited[i][j]=false;
        return b;
    }


}
