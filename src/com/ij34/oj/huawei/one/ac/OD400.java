package com.ij34.oj.huawei.one.ac;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 多段线数据压缩
 * https://hydro.ac/d/HWOD2023/p/OD400
 *
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD400 {
    public static void main(String[] args) {
        int[] a = Arrays.stream(new Scanner(System.in).nextLine().split(" "))
                .mapToInt(Integer::valueOf).toArray();
        int pre=-1;
        StringJoiner sj=new StringJoiner(" ");
        for (int i=0;i<a.length;i+=2){
            if (i==0){
                sj.add(a[i]+" "+a[i+1]);
                continue;
            }
            if (pre<0){
                pre=getDir(a[i-2],a[i-1],a[i],a[i+1]);
                continue;
            }
            int current = getDir(a[i-2],a[i-1],a[i],a[i+1]);
            if (current!=pre){
                sj.add(a[i-2]+" "+a[i-1]);
            }
            pre=current;
        }
        if (a.length>3){
            sj.add(a[a.length-2]+" " +a[a.length-1]);
        }
        System.out.println(sj);







    }

    private static int getDir(int x1, int y1, int x2, int y2) {
        if (x1==x2){
            return y2>y1?1:2;
        }
        if (y1==y2){
            return x2>x1?3:4;
        }
        if (x1>x2){
            return y1>y2?5:6;
        }else {
            return y1>y2?7:8;
        }







    }

}
