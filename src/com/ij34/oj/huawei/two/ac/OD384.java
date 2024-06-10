package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 部门人力分配
 * https://hydro.ac/d/HWOD2023/p/OD384
 * @Author: ij34
 * @Date: 2024-06-08
 */

public class OD384 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m =Integer.valueOf(sc.nextLine());
        long[] requirements = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long l=Arrays.stream(requirements).max().getAsLong(),r=Arrays.stream(requirements).sum(),res=r;
        Arrays.sort(requirements);
        while (l<=r){
            long mid=(l+r)/2;
            if (isOK(requirements,mid,m)){
                res=mid;
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        System.out.println(res);

    }
    //参考答案思路，people r和l+r之间。 是不是也需要啊a[l]-差异值呢
    private static boolean isOK(long[] a, long people, long time) {
        long otherTime =0;
        int l=0,r=a.length-1;
        while (l<=r){
            if (otherTime>time){
                return false;
            }

            long otherPeople = people-a[r];
            if (otherPeople<0){
                return false;
            }
            r--;
            otherTime++;
            if (otherPeople>=a[l]){
                l++;
            }
        }
        return  otherTime<=time;

    }
}
