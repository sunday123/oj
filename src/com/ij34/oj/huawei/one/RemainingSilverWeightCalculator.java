package com.ij34.oj.huawei.one;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 剩余银饰的重量
 * https://hydro.ac/d/HWOD2023/p/OD367
 * @Author: ij34
 * @Date: 2024-05-28
 */

public class RemainingSilverWeightCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        List<Integer> list =  Arrays.stream(sc.nextLine().split(" ")).
                map(Integer::valueOf).collect(Collectors.toList());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
        priorityQueue.addAll(list);
        while (priorityQueue.size()>2){
            int x=priorityQueue.poll(),y= priorityQueue.poll(),z=priorityQueue.poll();


            if (x!=y && y==z){
                priorityQueue.offer(Math.abs(x-y));
            }
            if (x==y && y!=z){
                priorityQueue.offer(Math.abs(y-z));
            }
            if (x!=y && y!=z){
                int a = Math.abs(x-y),b=Math.abs(y-z);
                int c =Math.abs(a-b);
                if (c>0){
                    priorityQueue.offer(c);
                }
            }
        }
        System.out.println(priorityQueue.isEmpty()?0:priorityQueue.poll());
    }
}

