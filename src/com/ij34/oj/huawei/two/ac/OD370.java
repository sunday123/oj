package com.ij34.oj.huawei.two.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * API集群负载统计
 * https://hydro.ac/d/HWOD2023/p/OD370
 * @Author: ij34
 * @Date: 2024-06-01
 */

public class OD370 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        List<List<String>> resList = new ArrayList<>();
        for (int i=0;i<n;i++){
            resList.add(Arrays.stream(sc.nextLine().split("/")).toList());
        }
        String[] s = sc.nextLine().split(" ");
        int k=Integer.valueOf(s[0]);
        String key =s[1];
        int res =0;
        for (List<String> list :resList){
            if (list.size()>k && key.equals(list.get(k))){
                res++;
            }
        }
        System.out.println(res);
    }
}
