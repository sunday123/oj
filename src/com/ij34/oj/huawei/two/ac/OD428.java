package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 运输时间
 * https://hydro.ac/d/HWOD2023/p/OD428
 *
 * @Author: ij34
 * @Date: 2024-06-08
 */

public class OD428 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] b = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count=b[0],len=b[1];
        int[] a = new int[count];
        float maxEndTime = 0;
        for (int time=0;time<count;time++){
            int cur = Integer.valueOf(scanner.nextLine());
            float temp = len*1000.0f/cur -(count-1-time)*1000;
            float needTime = Math.round(temp)/1000.000f;
            maxEndTime=maxEndTime>needTime?maxEndTime:needTime;
        }

        int abs = (int) maxEndTime;
        if (maxEndTime==abs){
            System.out.println(abs);
        }else {
            System.out.println(maxEndTime);
        }

    }
}
