package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * OD374分披萨
 * https://hydro.ac/d/HWOD2023/p/OD374
 * @Author: ij34
 * @Date: 2024-06-01
 */

public class OD374 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=sc.nextInt();
        }

        long max = 0;
        memo= new long[n][n];
        for (int i = 0; i < n; i++) {
            for (long[] m :memo){
                Arrays.fill(m,0);
            }

            int temp=array[0];
            for (int j=1;j<n;j++){
                array[j-1]=array[j];
            }
            array[n-1]=temp;

            max = Math.max(process(array,true,0,array.length-1), max);
        }
        System.out.println(max);
    }
    private static long [][] memo;//记忆搜索
    private static long process(int[] array, boolean isTrueA,int left,int right) {
        if (left>right){
            return 0;
        }
        if (isTrueA==false){
            if (array[left]>array[right]){
                return process(array,true,left+1,right);
            }else {
                return process(array,true,left,right-1);
            }
        }else {
            if (memo[left][right]!=0){
                return memo[left][right];
            }
            long a = array[left]+process(array,false,left+1,right);
            long b =array[right]+process(array,false,left,right-1);
            long max= Math.max(a,b);
            memo[left][right]=max;
            return max;
        }


    }

}