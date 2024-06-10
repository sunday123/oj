package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 图像物体的边界
 * https://hydro.ac/d/HWOD2023/p/OD231
 *
 * @Author: ij34
 * @Date: 2024-06-06
 */

public class OD231 {
    static class DSUnion{
        private int[] parent;
        private int count;
        public DSUnion(int n){
            count = n;
            parent = new int[n];
            for (int i=0;i<n;i++){
               parent[i] = i;
            }
        }

        private int find(int a){
            if (parent[a]!=a){
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }
        private void union(int a,int b){
            int pa = find(a);
            int pb = find(b);
            if (pa!=pb){
                parent[pa] = pb;
                count--;
            }
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s =scanner.nextLine().split(" ");
        int n=Integer.valueOf(s[0]),m=Integer.valueOf(s[1]);
        List<List<int[]>> resList = new ArrayList<>();
        int[][] a = new int[n][m];
        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<n;i++){
            a[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] dir ={{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                  if (a[i][j]!=5){
                      continue;
                  }
                  for (int[] d: dir){
                      int x = d[0]+i,y=d[1]+j;
                      if (x>=0 && y>=0 && x<n &&y<m && a[x][y]==1){
                          set.add(x*n+y);

                      }
                  }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        DSUnion dsu = new DSUnion(set.size());
        for (int i=0;i< set.size()-1;i++){
            int x = list.get(i)/n,y=list.get(i)%n;
            for (int j=i+1;j<set.size();j++){
                int x2=list.get(j)/n,y2=list.get(j)%n;
                if (Math.abs(x-x2)<2 && Math.abs(y-y2)<2){
                    dsu.union(i,j);
                }
            }
        }

        System.out.println(dsu.count);
    }
}
