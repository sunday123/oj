package com.ij34.oj.huawei;

import java.util.*;

/**
 * OCR032. 云上故障逃生
 * https://hydro.ac/d/HWOCR/p/OCR032
 * @Author: ij34
 * @Date: 2024-05-18
 */

public class CloudEscapeStrategy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[][] delayMatrix = new int[n][n];
        for (int i=0;i<n;i++){
            delayMatrix[i]= Arrays.stream(sc.nextLine().split(" ")).map(m->Integer.valueOf(m))
                    .mapToInt(Integer::intValue).toArray();
        }
        int[] remainingCapacity = Arrays.stream(sc.nextLine().split(" ")).map(m->Integer.valueOf(m))
                .mapToInt(Integer::intValue).toArray();
        int faultyNode = Integer.valueOf(sc.nextLine());
        int faultyCount =  Integer.valueOf(sc.nextLine());
        String res = netWorkFaultyCount(delayMatrix,n,remainingCapacity,faultyNode,faultyCount);
        System.out.println(res);
    }

    /**
     *  Dijkstra算法， dist-List<List<int[]>> -PriorityQueue<int[]>
     * @param delayMatrix
     * @param n
     * @param remainingCapacity
     * @param faultyNode
     * @param faultyCount
     * @return
     */
    private static String netWorkFaultyCount(int[][] delayMatrix, int n, int[] remainingCapacity, int faultyNode, int faultyCount) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[faultyNode]=0;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (delayMatrix[i][j]!=-1){
                    graph.get(i).add(new int[]{j,delayMatrix[i][j]});
                }
            }
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        priorityQueue.offer(new int[]{faultyNode,0});
        while (priorityQueue.isEmpty()==false){
            int[] a = priorityQueue.poll();
            for (int[] node : graph.get(a[0])){
                if (dist[node[0]] > dist[a[0]]+node[1]){
                    dist[node[0]] = dist[a[0]]+node[1];
                    priorityQueue.offer(new int[]{node[0],dist[node[0]]});
                }
            }
        }
        List<int[]> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            if (i!=faultyNode && dist[i]!=Integer.MAX_VALUE){
                list.add(new int[]{i,dist[i],remainingCapacity[i]});

            }
        }
        list.sort((a,b)-> a[1]-b[1]);
        String res ="";
        for (int[] node : list){
            if (faultyCount<1){
                break;
            }
            faultyCount-=node[2];
            res+= node[0] +" ";
        }
        return res.trim();

    }
}
