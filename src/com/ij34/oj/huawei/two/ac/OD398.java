package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 精准核酸检测
 * https://hydro.ac/d/HWOD2023/p/OD398
 */
public class OD398 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        List<Integer> initList = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int[][] a = new int[n][n];
        for (int i=0;i<n;i++){
            a[i]=Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }
        boolean[] b = new boolean[n];
        for (int i:initList){
            b[i]=true;
        }

        LinkedList<Integer> list = new LinkedList<>(initList);
        int res=0;
        while (list.isEmpty()==false){
            int i=list.poll();
            for (int j=0;j<n;j++){
                if (a[i][j]==1 && b[j]==false){
                    res++;
                    b[j]=true;
                    list.offer(j);
                }
            }
        }
        System.out.println(res);
    }
}
