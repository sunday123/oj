package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 文件缓存系统
 * https://hydro.ac/d/HWOD2023/p/OD396
 * @Author: ij34
 * @Date: 2024-06-03
 */

public class OD396 {
    private static int cap = 0,currentCap = 0,currentTime=0;

    private static List<String> list;
    private static  PriorityQueue<String[]> priorityQueue; // 0 name 1 size 2 count 3 time
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        cap = Integer.valueOf(sc.nextLine());
        int n = Integer.valueOf(sc.nextLine());
        String[] strings = new String[n];
        for (int i=0;i<n;i++){
            strings[i]=sc.nextLine();
        }


        priorityQueue = new PriorityQueue<String[]>((a, b) -> {
            if (a[2].equals(b[2]) == false) {
                return a[2].compareTo(b[2]);
            }
            return Integer.valueOf(a[3]) - Integer.valueOf(b[3]);//.compareTo(b[3]);
        });

        for (int i=0;i<n;i++){
            String[] s =strings[i].split(" ");
            if ("put".equals(s[0])){
                put(s[1],Integer.valueOf(s[2]));
            }else if ("get".equals(s[0])){
                get(s[1]);
            }
        }
        if (currentCap==0){
            System.out.println("NONE");
            return;
        }
        List<String> res = new ArrayList<>();
        while (priorityQueue.isEmpty()==false){
            res.add(priorityQueue.poll()[0]);
        }
        System.out.println(res.stream().sorted().collect(Collectors.joining(",")));

    }

    private static void get(String key) {
        if (list.contains(key)==false){
            return;
        }
        String[] s = priorityQueue.stream().filter(f->key.equals(f[0])).collect(Collectors.toList()).get(0);
        priorityQueue.remove(s);
        s[2]=String.valueOf(Integer.valueOf(s[2])+1);
        s[3]=String.valueOf(++currentTime);
        priorityQueue.offer(s);


    }

    private static void put(String key, Integer size) {
        if (list.contains(key)){
            return;
        }

        if (size>cap){
            return;
        }
        if (size==cap){
            priorityQueue.clear();
            currentCap=0;
            add(key,size);
            return;
        }

        while (size+currentCap>cap){
            String[] s = priorityQueue.poll();
            list.remove(s[0]);
            currentCap-=Integer.valueOf(s[1]);
        }

        add(key,size);
    }

    private static void add(String key, Integer size) {
        String[] s = new String[4];
        s[0]=key;
        s[1]=String.valueOf(size);
        s[2]="1";
        s[3]=String.valueOf(++currentTime);
        priorityQueue.offer(s);
        list.add(key);
        currentCap+=size;
    }
}
