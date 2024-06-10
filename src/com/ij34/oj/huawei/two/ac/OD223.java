package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * OD223. 数组连续和
 * https://hydro.ac/d/HWOD2023/p/OD223
 *
 * @Author: ij34
 * @Date: 2024-06-02
 */

public class OD223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = Integer.valueOf(sc.nextLine().split(" ")[1]);
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=a.length;
        long winSum =a[0],res=0;
        int l=0,r=0;
        while (r<n){
            if (l>r){
                r++;
                if (r>=n){
                    break;
                }
                winSum+=a[r];
            }
            if (winSum>=X){
                res+=n-r;
                winSum-=a[l];
                l++;

            }else {
                r++;
                if (r>=n){
                    break;
                }
                winSum+=a[r];

            }
        }

        System.out.println(res);

    }
}
