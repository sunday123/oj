package com.ij34.oj.huawei.one.ac;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 查找众数及中位数
 * https://hydro.ac/d/HWOD2023/p/OD212
 * @Author: ij34
 * @Date: 2024-05-04
 */

public class ModeAndMedianFinder {
    public static void main(String[] args) {
        List<Integer> list =Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i :list){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int max = map.values().stream().mapToInt(Integer::intValue).max().getAsInt();
        List<Integer> aList = new ArrayList<>();
        for (Map.Entry<Integer,Integer> e : map.entrySet()){
            if (e.getValue()==max && aList.contains(e.getKey())==false){
                aList.add(e.getKey());
            }
        }
        aList.sort(Comparator.comparingInt(a -> a));//中位数是指把一组数据从小到大排列

        if (aList.size()%2==1){
            System.out.println(aList.get(aList.size()/2));
        }else {
            int c =aList.get(aList.size()/2) +aList.get(aList.size()/2-1);
            System.out.println(c/2);
        }

    }
}
