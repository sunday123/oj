package com.ij34.oj.huawei.one.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 攀登者1
 * https://hydro.ac/d/HWOD2023/p/OD377
 *
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD377 {
    public static void main(String[] args) {
        int[] a = Arrays.stream(new Scanner(System.in).nextLine().split(",")).mapToInt(Integer::valueOf).toArray();
        int count=0;
        if (a[0]>a[1]){
            count++;
        }

        if (a[a.length-1]>a[a.length-2]){
            count++;
        }

        for (int i=1;i<a.length-1;i++){
            if (a[i]>a[i-1] && a[i]>a[i+1]){
                count++;
            }
        }
        System.out.println(count);





    }
}
