package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 查找一个有向网络的头节点和尾节点
 * https://hydro.ac/d/HWOD2023/p/OD432
 * @Author: ij34
 * @Date: 2024-06-08
 */

public class OD432 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        if (n<1){
            System.out.println(-1);
            return;
        }
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0;i<a.length;i+=2){
            List<Integer> list = map.getOrDefault(a[i],new ArrayList<>());
            list.add(a[i+1]);
            map.put(a[i],list);
        }

        if (check(map)==false){
            System.out.println(-1);
            return;
        }
        List<Integer> entryList = new ArrayList<>();
        for (int key : map.keySet()){
            boolean isAdd=true;
            for (List<Integer> list : map.values()){
                if (list.contains(key)){
                    isAdd=false;
                    break;
                }
            }
            if (isAdd){
                entryList.add(key);
            }
        }
        if (entryList.size()!=1){
            System.out.println(-1);
            return;
        }
        int entry = entryList.get(0);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(entry);
        Set<Integer> endList = new HashSet<>();
        while (list.isEmpty()==false){
            int pop = list.removeFirst();
            if (map.containsKey(pop)==false){
                endList.add(pop);
                continue;
            }
            list.addAll(map.get(pop));
        }
        System.out.println(entry+" "+endList.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));





    }

    private static boolean check(Map<Integer, List<Integer>> map) {
        for (Map.Entry<Integer,List<Integer>> e : map.entrySet()){
            Set<Integer> set = new HashSet<>();
            set.add(e.getKey());
            LinkedList<Integer> list = new LinkedList<>();
            list.addAll(e.getValue());
            while (list.isEmpty()==false){
                int a = list.removeFirst();
                if (set.contains(a)){
                    return false;
                }
                if (map.containsKey(a)){
                    list.addAll(map.get(a));
                }
            }
        }
        return true;
    }
}
