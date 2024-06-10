package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 电脑病毒感染
 * https://hydro.ac/d/HWOD2023/p/OD364
 * @Author: ij34
 * @Date: 2024-06-04
 */

public class OD364 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =Integer.valueOf(sc.nextLine());
        int k = Integer.valueOf(sc.nextLine());
        List<List<int[]>> graph = new ArrayList<>();
        for (int i=0;i<n+1;i++){
            graph.add(new ArrayList<int[]>());
        }
        for (int i=0;i<k;i++){
            int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(a[0]).add(new int[]{a[1],a[2]});
        }

        int start = Integer.valueOf(sc.nextLine());
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        priorityQueue.offer(new int[]{start,0});
        while (priorityQueue.isEmpty()==false){
            int[] poll = priorityQueue.poll();
            for (int[] node : graph.get(poll[0])){
                if (dist[node[0]] > dist[poll[0]]+node[1]){
                    dist[node[0]] = dist[poll[0]]+node[1];
                    priorityQueue.offer(new int[]{node[0],dist[node[0]]});
                }
            }
        }
        dist=Arrays.copyOfRange(dist,1,dist.length);

        int res = Arrays.stream(dist).anyMatch(a->a==Integer.MAX_VALUE)?-1:
                Arrays.stream(dist).filter(f->f!=Integer.MAX_VALUE).reduce(0,Integer::max);
        System.out.println(res);

    }
}
