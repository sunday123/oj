package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 没完成
 * 超时
 * 任务处理、可以处理的最大任务数
 * https://hydro.ac/d/HWOD2023/p/OD405
 *
 * @Author: ij34
 * @Date: 2024-06-09
 */
public class OD405 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> {
            if (b[1]!=a[1]){
                return b[1]-a[1];
            }
            return b[0]-a[0];
        });

        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{scanner.nextInt(),scanner.nextInt()});
        }


        int count=0,lastTime=queue.peek()[1];
        while (queue.isEmpty()==false){

            int[] poll = queue.poll();
            if (poll[1]<poll[0]){
                continue;
            }
            if (poll[1]>lastTime){
                poll[1]=lastTime;
                queue.offer(poll);
                continue;
            }
            if (lastTime>=poll[0]){
                count++;
                lastTime--;
                continue;
            }

        }
        System.out.println(count);
    }
}