package com.ij34.oj.huawei.two.wa;

import java.util.*;

/**
 * 没完成
 * OD433. 快递员的烦恼
 * https://hydro.ac/d/HWOD2023/p/OD433
 *
 * @Author: ij34
 * @Date: 2024-05-14
 */

public class CourierOptimizationDilemma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        int n =Integer.valueOf(s[0]),m=Integer.valueOf(s[1]);
        Map<Integer, List<int[]>> graph = new HashMap<>();//邻接表
        Map<Integer,Integer> dist = new HashMap<>();
        dist.put(0,0);
        List<int[]> list0 = new ArrayList<>();
        for (int i=0;i<n;i++){//默认公司是0出发
            String[] sn=sc.nextLine().split(" ");
            int a1=Integer.valueOf(sn[0]);
            int a2=Integer.valueOf(sn[1]);
            list0.add(new int[]{a1,a2});

            dist.put(a1,a2);
            //反向
            if (graph.containsKey(a1)){
                graph.get(a1).add(new int[]{0,a2});
            }else {
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{0,a2});
                graph.put(a1,list);
            }
        }
        graph.put(0,list0);
        for (int i=0;i<m;i++){
            String[] sm=sc.nextLine().split(" ");
            int a1=Integer.valueOf(sm[0]);
            int a2=Integer.valueOf(sm[1]);
            int a3=Integer.valueOf(sm[2]);
            if (graph.containsKey(a1)){
                graph.get(a1).add(new int[]{a2,a3});
            }else {
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{a2,a3});
                graph.put(a1,list);
            }

            list0.add(new int[]{Integer.valueOf(sm[0]),Integer.valueOf(sm[1])});
        }

        dist.forEach((k,v)->{
            System.out.println(k+","+v);
        });

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        priorityQueue.offer(new int[]{0,0});

        while (priorityQueue.isEmpty() == false) {
            int[] a = priorityQueue.poll();
            if (graph.containsKey(a[0])==false){
                continue;
            }
            for (int[] node :graph.get(a[0])){
                if (node[1]+dist.get(a[0])>dist.get(node[0])){
                    dist.put(node[0],node[1]+dist.get(a[0]));
                    priorityQueue.offer(new int[]{node[0],dist.get(node[0])});
                }
            }

        }
        System.out.println("============================res=");
        dist.forEach((k,v)->{
            System.out.println(k+","+v);
        });
    }
}
