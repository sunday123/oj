package com.ij34.oj.huawei.one.ac;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 * 小华最多能得到多少克黄金、小华地图寻宝
 * https://hydro.ac/d/HWOD2023/p/OD361
 *
 * @Author: ij34
 * @Date: 2024-05-04
 */

public class MaxGoldCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt(),n=sc.nextInt(),k= sc.nextInt();
        if (n==0 || m==0){
            System.out.println(0);
            return;
        }
        int sum =0;
        int[][] dir= {{0,1},{0,-1},{-1,0},{1,0} };
        LinkedList<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        list.add(0);
        set.add(0);
        int len=n+m;
        while (list.isEmpty()==false){
            int pop = list.removeFirst();
            int i=pop/len,j=pop%len;
            sum++;
            for (int[] d:dir){
                int x=i+d[0],y=j+d[1];
                int temp =x*len+y;
                if (x>=0 && y>=0 && x<n && y<m && set.contains(temp)==false && (getBit(x)+getBit(y)<=k)){
                    list.push(temp);
                    set.add(temp);

                }
            }

        }

        System.out.println(sum);


    }
    private static int getBit(int n) {
        int sum=0,i=n;
        while (i>0){
            sum+=i%10;
            i/=10;
        }
        return sum;
    }
}
