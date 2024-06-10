package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 爱吃蟠桃的孙悟空
 * https://hydro.ac/d/HWOD2023/p/OD354
 * @Author: ij34
 * @Date: 2024-06-08
 */

public class OD354 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int h = Integer.valueOf(sc.nextLine());
        if (h<a.length){
            System.out.println(0);
            return;
        }
        Arrays.sort(a);
        int r = a[a.length-1],l=1,res=r;
        while (l<=r){
            int mid=(l+r)/2;
            if (isOk(a,mid,h)){
                res=res<mid?res:mid;
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        System.out.println(res);

    }

    private static boolean isOk(int[] a, int speed, int h) {
        int hh=h;
        for (int n :a){
            hh-=(n+speed-1)/speed;
            if (hh<0){
                return false;
            }
        }
        return hh>=0;
    }
}
