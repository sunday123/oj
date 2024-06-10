package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 可以组成网络的服务器
 * https://hydro.ac/d/HWOD2023/p/OD233
 * @Author: ij34
 * @Date: 2024-06-06
 */

public class OD233 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n =Integer.valueOf(s[0]),m=Integer.valueOf(s[1]);
        int[][] a = new int[n][m];
        for (int i=0;i<n;i++){
            a[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int max = 0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (a[i][j]==1){
                    max = Math.max(max,process(a,i,j));
                }


            }
        }
        System.out.println(max);
    }

    private static int process(int[][] a, int i, int j) {
        int count = 1;
        a[i][j]=0;
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{i,j});
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (list.isEmpty()==false){
            int[] poll  =list.removeFirst();
            for (int[] d : dir){
                int x = poll[0]+d[0],y = poll[1]+d[1];
                if (x>=0 && y>=0 && x<a.length && y<a[0].length && a[x][y]==1){
                    count++;
                    a[x][y]=0;
                    list.addLast(new int[]{x,y});
                }
            }
        }
        return count;
    }
}
