package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 找城市
 * https://hydro.ac/d/HWOD2023/p/OD380
 *
 * @Author: ij34
 * @Date: 2024-06-10
 */

public class OD380 {

    static class DSUnion {
        private int[] parent;
        private int count = 0;

        public DSUnion(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            if (parent[x] != x) {
                return find(parent[x]);
            }
            return x;
        }

        private void union(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            if (xx != yy) {
                count++;
                parent[xx] = yy;
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        if (n==1){
            System.out.println(1);
            return;
        }
        int[][] a = new int[n-1][2];
        for (int i=0;i<n-1;i++){
            a[i]= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }
        int min=Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=n;i++){
            int len = getMax(a,i);
            if (len<min){
                min=len;
                list.clear();
                list.add(i);
            }else if (len==min){
                list.add(i);
            }

        }
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));





    }
    //连通图
    private static int getMax(int[][] a, int index) {
        DSUnion dsu = new DSUnion(a.length+2);
        for (int[] b : a){
            if (b[0]==index || b[1]==index){
                continue;
            }
            dsu.union(b[0], b[1]);

            }
        int[] d = new int[a.length+2];
        for (int i=1;i<=a.length+1;i++){
            d[dsu.find(i)]++;
        }

        return Arrays.stream(d).max().getAsInt();

    }


    //暴力，数据大会超时
    private static int getMax2(int[][] a, int index) {
        List<Set<Integer>> resList = new ArrayList<>();
        for (int[] b : a){
            if (b[0]==index || b[1]==index){
                continue;
            }
            boolean isAdd=false;
            for (int i=0;i<resList.size();i++){
                Set<Integer> set = resList.get(i);
                if (set.contains(b[0]) || set.contains(b[1])){
                    resList.get(i).add(b[0]);
                    resList.get(i).add(b[1]);
                    isAdd=true;
                    break;
                }

            }

            if (isAdd==false){
                Set<Integer> set = new HashSet<>();
                set.add(b[0]);
                set.add(b[1]);
                resList.add(set);
                continue;
            }





        }

        return resList.isEmpty()?0:resList.stream().mapToInt(m->m.size()).max().getAsInt();

    }



}
