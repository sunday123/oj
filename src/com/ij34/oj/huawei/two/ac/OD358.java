package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 围棋的气
 * https://hydro.ac/d/HWOD2023/p/OD358
 * @Author: ij34
 * @Date: 2024-06-02
 */

public class OD358 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] b = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] c = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int bb = process(b,c);
        int cc = process(c,b);
        System.out.println(bb+" "+cc);

    }

    private static int process(int[] allow, int[] dis) {
        int[][] a = new int[19][19];
        for (int i=0;i<dis.length;i=i+2){
            a[dis[i]][dis[i+1]]=-1;
        }
        for (int i=0;i<allow.length;i=i+2){
            a[allow[i]][allow[i+1]]=-1;
        }
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int res=0;
        for (int i=0;i<allow.length;i=i+2){
            for (int[] d : dir){
                int x = allow[i]+d[0],y=allow[i+1]+d[1];
                if (x>=0 && y>=0 && x<19 && y<19 && a[x][y]==0){
                    res++;
                    a[x][y]=1;
                }
            }
        }
        return res;
    }
}
