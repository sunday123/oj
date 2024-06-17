package com.ij34.oj.huawei.one.ac;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 计算面积、绘图机器
 * https://hydro.ac/d/HWOD2023/p/OD320
 *
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD320 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),e=sc.nextInt();
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{0,0});
        int y=0,x=0,res=0;
        for (int i=0;i<n;i++){
           int xx= sc.nextInt(),yy= sc.nextInt();
           res+= Math.abs(y)*Math.abs(xx-x);
           y+=yy;
           x=xx;
        }

        if (x<e){
            res+=Math.abs(y)*Math.abs(e-x);
        }
        System.out.println(res);

    }
}
