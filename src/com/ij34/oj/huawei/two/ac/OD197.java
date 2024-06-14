package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 欢乐的周末
 * https://hydro.ac/d/HWOD2023/p/OD197
 *
 * @Author: ij34
 * @Date: 2024-06-11
 */

public class OD197 {
    static class DSUnion{
        private int[] parent;
        public DSUnion(int n){
            parent=new int[n];
            for (int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        private int find(int x){
            if (parent[x]!=x){
                return find(parent[x]);
            }
            return x;
        }
        private void union(int x,int y){
            int xx = find(x);
            int yy = find(y);
            if (xx!=yy){
                parent[xx]=yy;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] mn=Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n=mn[0], m=mn[1];
        int[][] a = new int[n][m];
        List<Integer> twoList = new ArrayList<>(),threeList = new ArrayList<>();
        for (int i=0;i<n;i++){
            a[i]= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for (int j=0;j<m;j++){
                if (a[i][j]==2){
                    twoList.add(i*m+j);
                }else if (a[i][j]==3){
                    threeList.add(i*m+j);
                }
            }
        }

        DSUnion dsu = new DSUnion(n*m);
        boolean[][] used = new boolean[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                used[i][j]=false;
            }
        }
        LinkedList<int[]> list = new LinkedList<>();
        list.offer(new int[]{twoList.get(0)/m,twoList.get(0)%m});
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        used[twoList.get(0)/m][twoList.get(0)%m]=true;
        while (list.isEmpty()==false){
            int[] poll = list.poll();

            int num=poll[0]*m+poll[1];
            for (int[] d:dir){
                int x=d[0]+poll[0],y=d[1]+poll[1];
                while (x>=0 && y>=0 && x<n && y<m && used[x][y]==false && a[x][y]!=1){
                    used[x][y]=true;
                    dsu.union(num,x*m+y);
                    list.offer(new int[]{x,y});
                }

            }
        }
        if (dsu.find(twoList.get(0))!=dsu.find(twoList.get(1))){
            System.out.println(0);
            return;
        }

        int count=0;
        int f=dsu.find(twoList.get(0));

        for (int num :threeList){
            if (dsu.find(num)==f){
                count++;
            }
        }
        System.out.println(count);


    }
}
