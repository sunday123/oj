package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 最富裕的小家庭
 * https://hydro.ac/d/HWOD2023/p/OD342
 * @Author: ij34
 * @Date: 2024-06-02
 */

public class OD342 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[] ws = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Set<Integer>> graph = new ArrayList<>();
        if (n==1){
            System.out.println(ws[0]);
            return;
        }
        for (int i=0;i<=n;i++){
            graph.add(new HashSet<>());
        }
        for (int i=0;i<n-1;i++){
            int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(a[0]).add(a[0]);
            graph.get(a[0]).add(a[1]);
        }
        int max = 0;
        for (int i=1;i<=n;i++){
            Set<Integer> a = graph.get(i);
            if (a.isEmpty()==false){
                int sum =0;
                for (int aa : a){
                    sum+=ws[aa-1];
                }
                max=Math.max(max,sum);
            }
        }
        System.out.println(max);

    }
}
