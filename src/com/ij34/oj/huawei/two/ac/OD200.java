package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 整型数组按个位值排序
 * https://hydro.ac/d/HWOD2023/p/OD200
 * @Author: ij34
 * @Date: 2024-06-01
 */

public class OD200 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.stream(new Scanner(System.in).nextLine().split(","))
                .mapToInt(Integer::parseInt).boxed().toList();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<list.size();i++){
            map.put(list.get(i),i);
        }
        String res = list.stream().sorted((a, b) -> {
            int aaa = Math.abs(a)%10,bbb=Math.abs(b)%10;
            return aaa-bbb;
        }).map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(res);
    }
}
