package com.ij34.oj.huawei;

import java.util.*;

/**
 * 田忌赛马
 * https://blog.csdn.net/qfc_128220/article/details/135024242?spm=1001.2014.3001.5501
 * @Author: ij34
 * @Date: 2024-05-20
 */

public class TianJiHorseRacingStrategy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        backtrack(a,new LinkedList<>());
        int max =0,res=0;
        for (List<Integer> l : aList){
            int count = 0;
            for (int i=0;i<b.length;i++){
                int t = l.get(i)-b[i];
                count+= t>0?1:t==0?0:-1;
            }
            if (count>max){
                res=1;
                max=count;
            }else if (count==max){
                res++;
            }
        }
        System.out.println(res);

    }

    private static void backtrack(int[] a, LinkedList<Integer> list) {
        if (list.size()==a.length){
            aList.add(new ArrayList<>(list));
        }
        for (int i=0;i<a.length;i++){
            if (list.contains(a[i])){
                continue;
            }
            list.add(a[i]);
            backtrack(a,list);
            list.removeLast();
        }
    }

    private static List<List<Integer>> aList = new ArrayList<>();
}
