package com.ij34.oj.huawei.one.ac;

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
        for (int i=1;i<array1.length;i++){
            for (int j=1;j<array2.length;j++){
                queue.offer(array1[i]+array2[j]);
                if (queue.size()>k){
                    queue.poll();
                }
            }
        }
        int sum =0;
        while (queue.isEmpty()==false){
            if (k>0){
                sum+=queue.poll();
                k--;
            }else {
                break;
            }
        }
        System.out.println(sum);
    }

}
