package com.ij34.oj.huawei.two.ac;

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
        int[][] dist = new int[n+1][n+1];
        for (int i=0;i<dist.length;i++){
            for (int j=0;j<dist[0].length;j++){
                if (i!=j){
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i=1;i<=n;i++){
            int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            map.put(a[0],i);
            dist[0][i]=a[1];
            dist[i][0]=a[1];
        }
        for (int i=0;i<m;i++){
            int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            dist[map.get(a[0])][map.get(a[1])]=a[2];
            dist[map.get(a[1])][map.get(a[0])]=a[2];
        }
        for (int k=0;k<=n;k++){
            for (int i=0;i<=n;i++){
                for (int j=0;j<=n;j++){
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }

        backtrack(dist,0,new LinkedList<Integer>());
        System.out.println(res);

    }
    private static int res=Integer.MAX_VALUE;


    private static void backtrack(int[][] dist,int sum, LinkedList<Integer> list) {
        if (list.size()==dist.length-1){
            res=Math.min(res,sum+dist[list.getLast()][0]);
            return;
        }

        for (int i=1;i<dist.length;i++){
            if (list.contains(i)){
                continue;
            }

            int pre=list.isEmpty()?0:list.getLast();
            list.addLast(i);
            backtrack(dist,sum+dist[pre][list.getLast()],list);
            list.removeLast();
        }

    }

    //list记录下标
    private static void backtrack2(int[][] dist, LinkedList<Integer> list) {
        if (list.size()==dist.length-1){
            LinkedList<Integer> temp = new LinkedList<>();
            temp.addFirst(0);
            temp.addAll(list);
            temp.addLast(0);
            int a=0;
            for (int i=1;i<temp.size();i++){
                a+=dist[temp.get(i-1)][temp.get(i)];
            }
            res=Math.min(res,a);
            return;
        }

        for (int i=1;i<dist.length;i++){
            if (list.contains(i)){
                continue;
            }
            list.addLast(i);
            backtrack2(dist,list);
            list.removeLast();
        }

    }


}
