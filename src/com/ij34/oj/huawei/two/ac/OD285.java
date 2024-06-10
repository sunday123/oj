package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 数组去重和排序
 * https://hydro.ac/d/HWOD2023/p/OD285
 * @Author: ij34
 * @Date: 2024-06-02
 */

public class OD285 {
    public static void main(String[] args) {
        String[] a = new Scanner(System.in).nextLine().split(",");
        List<String> indexList = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for (String aa:a){
            if (indexList.contains(aa)==false){
                indexList.add(aa);
            }
            map.put(aa,map.getOrDefault(aa,0)+1);
        }

        List<String> list = new ArrayList<>(indexList);
        String res = list.stream().sorted((o1, o2) -> {
            if (map.get(o1)!=map.get(o2)){
                return map.get(o2)-map.get(o1);
            }
            return indexList.indexOf(o1)-indexList.indexOf(o1);
        }).collect(Collectors.joining(","));
        System.out.println(res);
    }
}
