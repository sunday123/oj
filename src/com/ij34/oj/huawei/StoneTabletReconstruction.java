package com.ij34.oj.huawei;
/**
 * 考古学家
 */

import java.util.*;
import java.util.stream.Collectors;

public class StoneTabletReconstruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len= sc.nextInt();
        String[] a= new String[len];
//        HashMap<Integer,String> map = new HashMap<>();
        for (int i=0;i<len;i++){
            a[i]=sc.next();
        }

        HashSet<String> result = new HashSet<>();
        bt(a,result,new LinkedList<Integer>());
        result.stream().sorted().forEach(System.out::println);
    }

    private static void bt(String[] a, HashSet<String> result, LinkedList<Integer> list) {
        if (list.size()==a.length){
            StringBuilder sb  = new StringBuilder();
            for (int i=0;i<list.size();i++){
                sb.append(a[list.get(i)]);
            }
            result.add(sb.toString());
            return;
        }

        for (int i=0;i<a.length;i++){
            if (list.contains(i)) continue;
            list.addLast(i);
            bt(a,result,list);
            list.removeLast();
        }



    }


}