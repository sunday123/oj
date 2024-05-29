package com.ij34.oj.huawei.two.ac;
/**
 * 考古学家
 * https://hydro.ac/d/HWOD2023/p/OD381
 */

import java.util.*;
import java.util.stream.Collectors;

public class StoneTabletReconstruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len= sc.nextInt();
        String[] a= new String[len];
        for (int i=0;i<len;i++){
            a[i]=sc.next();
        }

        List<String> result = new ArrayList<>();
        used=new boolean[a.length];
        Arrays.sort(a);
        bt(a,result,0);
        result.stream().sorted().forEach(System.out::println);
    }
    private static boolean[] used;
    private static void bt(String[] a, List<String> result,int start) {
        if (start==a.length){
            result.add(Arrays.stream(a).collect(Collectors.joining()));
            return;
        }

        for (int i=start;i<a.length;i++){
            if (i>0 && a[i]==a[i-1] && used[i-1]==false){
                continue;
            }
            if (used[i]==false){
                used[i]=true;
                swap(a,i,start);
                bt(a,result,start+1);
                used[i]=false;
                swap(a,i,start);
            }
        }

    }

    private static void swap(String[] a, int i, int j) {
        String t =a[i];
        a[i]=a[j];
        a[j]=t;
    }

}