package com.ij34.oj.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 整数对最小和
 * @Author: ij34
 * @Date: 2024-05-06
 */

public class MinSumOfIntegerPairs  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] array2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k =sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for (int a:array1){
            for (int b:array2){
                queue.offer(a+b);
            }
        }
        int sum =0;
        while (queue.isEmpty()==false){
            if (queue.size()<=k){
                sum+=queue.poll();
            }else {
                queue.poll();
            }
        }
        System.out.println(sum);
    }

}
