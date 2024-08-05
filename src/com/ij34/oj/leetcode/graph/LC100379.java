package com.ij34.oj.leetcode.graph;

import java.util.*;

/**
 * 100379. 新增道路查询后的最短距离 I
 * https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-i
 * @Author: ij34
 * @Date: 2024-08-04
 */

public class LC100379 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            if (i < n - 1) {
                graph.get(i).add(new int[]{i + 1, 1});
            }
        }
        int[] res = new int[queries.length];
        int[] dist = new int[n];

        for (int i = 0; i < queries.length; i++) {
            Arrays.fill(dist, n - 1);
            dist[0] = 0;
            int[] q = queries[i];
            graph.get(q[0]).add(new int[]{q[1], 1});
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            queue.offer(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();

                for (int[] node : graph.get(poll[0])) {
                    if (node[1] + poll[1] < dist[node[0]]) {
                        dist[node[0]] = node[1] + poll[1];
                        queue.offer(new int[]{node[0], dist[node[0]]});
                    }
                }
            }
            res[i] = dist[n - 1];

        }
        return res;
    }
}
