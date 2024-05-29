package com.ij34.oj.huawei.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 堆内存申请
 * https://hydro.ac/d/HWOD2023/p/OD401
 *
 * @Author: ij34
 * @Date: 2024-05-29
 */

public class HeapMemoryAllocator {

    public static void main(String[] args) {
        int total = 100;
        Scanner sc = new Scanner(System.in);
        int apply = Integer.valueOf(sc.nextLine());
        List<int[]> list = new ArrayList<>();
        while (sc.hasNext()){
            list.add(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        list.sort((a, b) -> {
            if (a[0]!=b[0]){
                return a[0]-b[0];
            }else {
                return b[1]-a[1];
            }
        });
        int[] end = list.get(list.size()-1);
        if (end[0]+end[1]>100){
            System.out.println(-1);
            return;
        }
        int findIndex=-1,minLen=Integer.MAX_VALUE;
        int[] a = list.get(0);
        if (a[0]==apply){
            System.out.println(0);
            return;
        }
        if (a[0]>apply){
            findIndex=0;
            minLen=a[0];
        }

        for (int i=1;i<list.size();i++){
            int[] pre = list.get(i-1);
            int[] curr=list.get(i);
            int allow=curr[0]-(pre[0]+pre[1]);
            if (allow<apply){
                continue;
            }
            if (allow==apply){
                System.out.println(pre[0]+pre[1]);
                return;
            }
            if (allow<minLen){
                minLen=allow;
                findIndex=pre[0]+pre[1];
            }
        }
        if (end[0]+end[1]+apply==100){
            System.out.println(end[0]+end[1]);
            return;
        }
        if (end[0]+end[1]+apply<100){
            int allow=100-(end[0]+end[1]);
            if (allow<minLen){
                minLen=allow;
                findIndex=end[0]+end[1];
            }
        }



        System.out.println(findIndex);
    }
}
