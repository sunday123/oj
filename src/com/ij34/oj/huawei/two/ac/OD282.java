package com.ij34.oj.huawei.two.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 查找接口成功率最优时间段
 * https://hydro.ac/d/HWOD2023/p/OD282
 * @Author: ij34
 * @Date: 2024-06-02
 */

public class OD282 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minAverageLost = Integer.valueOf(sc.nextLine());
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int len=a.length;len>0;len--){
            List<List<Integer>> resList= new ArrayList<>();
            for (int i=0;i+len<=a.length;i++){
                int sum=0;
                for (int j=i;j<i+len;j++){
                    sum+=a[j];
                }
                if (len*minAverageLost>=sum){
                    resList.add(List.of(i,i+len-1));
                }
            }
            if (resList.size()>0){
                String res = resList.stream().map(m->m.get(0)+"-"+m.get(1)).collect(Collectors.joining(" "));
                System.out.println(res);
                return;
            }
        }
        System.out.println("NULL");
    }
}
