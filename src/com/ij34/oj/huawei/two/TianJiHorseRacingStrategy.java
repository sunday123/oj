package com.ij34.oj.huawei.two;

import java.util.*;

/**
 * 没完成
 * 田忌赛马
 * https://hydro.ac/d/HWOD2023/p/OD425
 * @Author: ij34
 * @Date: 2024-05-20
 */

public class TianJiHorseRacingStrategy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        backtrack(a, new LinkedList<>());
        int  res=0;
        for (List<Integer> l : aList) {
            if (isSuccess(l, b)){
                res++;
            }
        }
        if (res==0){
            res=1;
            for(int i=1;i<=b.length;i++){
                res*=i;
            }
        }
        System.out.println(res);
    }

    private static boolean isSuccess(List<Integer> l, int[] b) {
        int count=0;
        for(int i=0;i<b.length;i++){
            if (l.get(i)>b[i]){
                count++;
            }else if (l.get(i)<b[i]){
                count--;
            }
        }
        return count>=0;
    }

    private static void backtrack ( int[] a, LinkedList<Integer > list){
            if (list.size() == a.length) {
                aList.add(new ArrayList<>(list));
            }
            for (int i = 0; i < a.length; i++) {
                if (list.contains(a[i])) {
                    continue;
                }
                list.addLast(a[i]);
                backtrack(a, list);
                list.removeLast();
            }
        }

        private static List<List<Integer>> aList = new ArrayList<>();




}