package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 寻找身高相近的小朋友
 * https://hydro.ac/d/HWOD2023/p/OD247
 * @Author: ij34
 * @Date: 2024-06-01
 */

public class OD247 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k=Integer.valueOf(sc.nextLine().split(" ")[0]);
        List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().toList();
        String res = list.stream().sorted((a, b) -> {
            int aa = Math.abs(a-k);
            int bb =Math.abs(b-k);
            if (aa!=bb){
                return aa-bb;
            }
            return a-b;
        }).map(m->String.valueOf(m)).collect(Collectors.joining(" "));
        System.out.println(res);

    }
}
