package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.stream.Collectors;

public class NumberSort {

    public static void main(String[] args) {
        int[] a = Arrays.stream(new Scanner(System.in).nextLine().split(","))
                .map(m->Integer.valueOf(m)).mapToInt(Integer::intValue).toArray();
        Arrays.sort(a);
        if(check(a)==false){
            System.out.println(-1);
            return;
        }

        int N = a[a.length-1];
        for (int i=0;i<a.length;i++){
            if (a[i]==5){
                a[i]=2;
            }else if (a[i]==9){
                a[i]=6;
            }
        }
        backtrack(a,0,new LinkedList<>());
        System.out.println(Arrays.toString(a));
        List<List<Integer>> otherList = new ArrayList<>();
        for (List<Integer> list : resList){
            if (list.contains(2)){
                List<Integer> oList = new ArrayList<>(list);
                oList.remove(Integer.valueOf(2));
                oList.add(5);
                otherList.add(oList);
            }else if (list.contains(6)){
                List<Integer> oList = new ArrayList<>(list);
                oList.remove(Integer.valueOf(6));
                oList.add(9);
                otherList.add(oList);
            }
        }
        resList.addAll(otherList);
        for (List<Integer> list : resList){
            backtrack2(list.stream().mapToInt(Integer::intValue).toArray(),new LinkedList<Integer>());
        }
        set=set.stream().sorted(Comparator.comparingInt(Integer::valueOf)).collect(Collectors.toList());
        System.out.println(set.get(N-1));

    }

    private static boolean check(int[] a) {
        if (a.length!=4){
            return false;
        }
        int a2=0,a6=0;
        for(int aa : a){
            if (aa==2 || aa==5){
                a2++;
            }
            if (aa==6 || aa==9){
                a6++;
            }
            if (aa<1 || aa>9){
                return false;
            }
        }
        if (a2>1 || a6>1){
            return false;
        }
        for (int i=1;i<a.length;i++){
            if (a[i]==a[i-1]){
                return false;
            }
        }
        return true;
    }

    private static void backtrack2(int[] a, LinkedList<Integer> list) {
        if (list.size()==a.length){
            set.add(list.stream().map(Objects::toString).collect(Collectors.joining()));
        }
        for (int i=0;i<a.length;i++){
            if (list.contains(a[i])){
                continue;
            }
            list.addLast(a[i]);
            backtrack2(a,list);
            list.removeLast();
        }
    }

    private static List<String> set = new ArrayList<>();
    private static List<List<Integer>> resList = new ArrayList<>();
    private static void backtrack(int[] a, int start, LinkedList<Integer> list) {
        for (int i=start;i<a.length;i++){

            list.addLast(a[i]);
            backtrack(a,i+1,list);
            list.removeLast();
        }
        if (list.isEmpty()==false){
            resList.add((new ArrayList<>(list)));
        }
    }

}