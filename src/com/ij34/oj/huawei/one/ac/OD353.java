package com.ij34.oj.huawei.one.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 机器人仓库搬砖
 * https://hydro.ac/d/HWOD2023/p/OD353
 *
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD353 {
    public static void main(String[] args) {
        int[] a = Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (a.length>8){
            System.out.println(-1);
            return;
        }
        if (a.length==8){
            System.out.println(Arrays.stream(a).max().getAsInt());
            return;
        }
        int l= Arrays.stream(a).sum()/8,r=Arrays.stream(a).max().getAsInt();
        int res=r;
        while (l<=r){
            int mid = (l+r)/2;
            if (check(a,mid)){
                res=mid;
                r=mid-1;
            }else {
                l=mid+1;
            }

        }
        System.out.println(res);


    }

    private static boolean check(int[] a, int count) {
        int time=8;
        for (int c : a){
            time-=(c+count-1)/count;
            if (time<0){
                return false;
            }
        }
        return time>=0;
    }
}
