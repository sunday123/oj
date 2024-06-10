package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 按身高和体重排队
 * https://hydro.ac/d/HWOD2023/p/OD301
 * @Author: ij34
 * @Date: 2024-06-02
 */

public class OD301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[] heights = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] weights = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<int[]> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            list.add(new int[]{i+1,heights[i],weights[i]});
        }
        String res = list.stream().sorted((a, b) -> {
            if (a[1]!=b[1]){
                return a[1]-b[1];
            }
            if (a[2]!=b[2]){
                return a[2]-b[2];
            }
            return a[1]-b[1];

        }).map(m->String.valueOf(m[0])).collect(Collectors.joining(" "));
        System.out.println(res);

    }
}
