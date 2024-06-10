package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 开源项目热榜、开源项目热度榜单
 * https://hydro.ac/d/HWOD2023/p/OD352
 * @Author: ij34
 * @Date: 2024-06-01
 */

public class OD352 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =Integer.valueOf(sc.nextLine());
        int[] weights = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<String,Integer> map = new HashMap<>();
        for (int i=0;i<n;i++){
            String[] s = sc.nextLine().split(" ");
            int score=0;
            for(int j=0;j<weights.length;j++){
                score += weights[j]*Integer.valueOf(s[j+1]);
            }
            map.put(s[0],score);
        }
        map.entrySet().stream().sorted((o1, o2) -> o2.getValue()-o1.getValue()).forEach(e->{
            System.out.println(e.getKey());
        });
    }
}
