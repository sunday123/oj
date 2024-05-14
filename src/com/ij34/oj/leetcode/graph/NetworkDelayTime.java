package com.ij34.oj.leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 743. 网络延迟时间
 * https://leetcode.cn/problems/network-delay-time
 *
 * @Author: ij34
 * @Date: 2024-05-13
 */

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {
                {1, 2, 1},
                {2, 3, 2},
                {1, 3, 2}
        };
        int res = networkDelayTime(times, 3, 1);
        System.out.println("2res:" + res);
        System.out.println("===============");
        times = new int[][]{
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        res = networkDelayTime(times, 4, 2);
        System.out.println("2res:" + res);
        System.out.println("===============");

        times = new int[][]{
                {1, 2, 1},
                {2, 3, 2},
                {1, 3, 4}
        };


        res = networkDelayTime(times, 3, 1);
        System.out.println("3res:" + res);
        System.out.println("===============");

        times = new int[][]{
                {1, 2, 1}
        };
        res = networkDelayTime(times, 2, 1);
        System.out.println("1res:" + res);
        System.out.println("===============");

        times = new int[][]{
                {1, 2, 1}
        };
        System.out.println("===============");
        res = networkDelayTime(times, 2, 2);
        System.out.println("-1res:" + res);


        System.out.println("===============");
        times = new int[][]{
                {4, 2, 76},
                {1, 3, 79},
                {3, 1, 81},
                {4, 3, 30},
                {2, 1, 47},
                {1, 5, 61},
                {1, 4, 99},
                {3, 4, 68},
                {3, 5, 46},
                {4, 1, 6},
                {5, 4, 7},
                {5, 3, 44},
                {4, 5, 19},
                {2, 3, 13},
                {3, 2, 18},
                {1, 2, 0},
                {5, 1, 25},
                {2, 5, 58},
                {2, 4, 77},
                {5, 2, 74}
        };
        res = networkDelayTime(times, 5, 3);
        System.out.println("59res:" + res);
        Arrays.stream(times).sorted((a, b) -> {
            if (a[0] - b[0] != 0) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        }).forEach(f -> {
            System.out.println(Arrays.toString(f));
        });

    }


    public static int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        int max = 101 * n;
        Arrays.fill(dist, max);
        dist[k] = 0;
        List<List<int[]>> graph = new ArrayList<>();//邻接表
        for (int i = 0; i <n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            graph.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        priorityQueue.offer(new int[]{k,0});
        while (priorityQueue.isEmpty() == false) {
            int[] a = priorityQueue.poll();
            for (int[] node :graph.get(a[0])){
                if (node[1]+dist[a[0]]<dist[node[0]]){
                    dist[node[0]]=node[1]+dist[a[0]];
                    priorityQueue.offer(new int[]{node[0],dist[node[0]]});
                }
            }

        }
        //输出
        int res = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == max) {
                return -1;
            }
            res = res > dist[i] ? res : dist[i];
        }
        return res;
    }
}
