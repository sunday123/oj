package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 信道分配
 * https://hydro.ac/d/HWOD2023/p/OD334
 * @Author: ij34
 * @Date: 2024-06-15
 */

public class OD334 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int[] countArray = new int[r+1];
        int[] capArray = new int[r+1];
        for (int i=0;i<=r;i++){
             capArray[i]= 1<<i;
             countArray[i]=sc.nextInt();
        }
        int d = sc.nextInt();
        int count=0,total= Arrays.stream(countArray).sum();
        while (true){
            if (total<1){
                break;
            }
            int k=d;
            for (int i=r;i>=0;i--){
                while (countArray[i]>0 && k>=capArray[i]){//从大到小遍历，用掉比k小的
                    k-=capArray[i];
                    total--;
                    countArray[i]--;
                }
            }
            if (k<=0){
                count++;
                continue;
            }
            for (int i=0;i<=r;i++){//小到到，依次减到k小于1
                if (countArray[i]<1){
                    continue;
                }
                k-=capArray[i];
                total--;
                countArray[i]--;
                if (k<1){
                    break;
                }
            }

            if (k<1){
                count++;
            }



        }
        System.out.println(count);





    }
}
