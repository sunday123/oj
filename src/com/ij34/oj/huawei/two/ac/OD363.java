package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://hydro.ac/d/HWOD2023/p/OD363
 *
 * @Author: ij34
 * @Date: 2024-05-31
 */

public class OD363 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int k= Integer.valueOf(sc.nextLine());
        Map<Integer,Integer> map = new HashMap<>();
        for (int aa:a){
            map.put(aa,map.getOrDefault(aa,0)+1);
        }
        List<Integer>list = map.entrySet().stream().filter(f->f.getValue()>=k)
                .sorted((c, d) -> {
                    if (d.getValue().equals(c.getValue())==false){
                       return d.getValue()-c.getValue();
                    }
                    return c.getKey()-d.getKey();
                }).map(m->m.getKey()).collect(Collectors.toList());
        System.out.println(list.isEmpty()?0:list.size());
        list.forEach(System.out::println);
    }
}
