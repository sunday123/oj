package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 反射计数
 * https://hydro.ac/d/HWOD2023/p/OD422
 *
 * @Author: ij34
 * @Date: 2024-06-08
 */

public class OD422 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] c = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = c[1],m=c[0],x=c[3],y=c[2],sx=c[5],sy=c[4],t=c[6];
        int count=0;
        int[][] a = new int[n][m];

        for (int i=0;i<n;i++){
            a[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        while (t-->=0){
            if (a[x][y]==1){
                count++;
            }
            x+=sx;
            y+=sy;

            if (x<0 || x>=n){
                sx=0-sx;
                x+=2*sx;
                if (x<0 || x>=n){
                    x-=sx;
                }
            }

            if (y<0 || y>=m){
                sy=0-sy;
                y+=2*sy;
                if (y<0 ||y>=m){
                    y-=sy;
                }
            }
        }
        System.out.println(count);

    }
}
