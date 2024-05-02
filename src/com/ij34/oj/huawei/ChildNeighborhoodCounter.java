package com.ij34.oj.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 小朋友来自多少分区
 * https://hydro.ac/d/HWOD2023/p/OD397
 * @Author: ij34
 * @Date: 2024-05-02
 */

public class ChildNeighborhoodCounter {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(a->{
            map.put(a+1,map.getOrDefault(a+1,0)+1);
        });
        AtomicInteger result= new AtomicInteger(0);
        map.entrySet().forEach(a->{
            int i =a.getValue()/a.getKey()+(a.getValue()%a.getKey()>0?1:0);
            result.addAndGet(a.getKey()*i) ;
        });
        System.out.println(result.get());
    }
}
