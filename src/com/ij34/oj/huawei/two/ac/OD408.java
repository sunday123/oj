package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 跳马
 * https://hydro.ac/d/HWOD2023/p/OD408
 * @Author: ij34
 * @Date: 2024-06-13
 */

public class OD408 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nm = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n=nm[0],m=nm[1];
        List<int[]> list = new ArrayList<>();
        int index=0;
        for (int i=0;i<n;i++){
            String[] cs =sc.nextLine().split("");
            for (int j=0;j<cs.length;j++){
                char c =cs[j].charAt(0);
                if (c!='.'){
                    list.add(new int[]{i,j,c-'0',index++});
                }
            }
        }
        if (list.isEmpty()){
            System.out.println(-1);
            return;
        }
        if (list.size()==1){
            System.out.println(0);
            return;
        }


        int[][][] dist = new int[n][m][list.size()];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        for (int[] a : list){
            int[][] res = bfs(n,m,a[0],a[1],a[2]);
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    dist[i][j][a[3]]=res[i][j];
                }
            }
        }
        int res=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                int sum=0;
                for (int k=0;k<list.size();k++){
                    if (dist[i][j][k]==Integer.MAX_VALUE){
                        sum=Integer.MAX_VALUE;
                        break;
                    }else {
                        sum+=dist[i][j][k];
                    }
                }
                if (sum<Integer.MAX_VALUE){
                    res=Math.min(res,sum);
                }
            }
        }
        System.out.println(res==Integer.MAX_VALUE?-1:res);

    }

    private static int[][] bfs(int n, int m, int x0, int y0, int k) {
        int[][] a = new int[n][m];
        for (int i=0;i<n;i++){
            Arrays.fill(a[i],Integer.MAX_VALUE);
        }
        a[x0][y0]=0;
        int[][] dir = {{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{x0,y0});
        int count=0;
        while (list.isEmpty()==false){
            int len =list.size();
            count++;
            if (count>k){
                break;
            }
            for (int i=0;i<len;i++){
                int[] poll=list.removeFirst();
                for (int[] d:dir){
                    int x=poll[0]+d[0],y=poll[1]+d[1];
                    if (x<0 || x>=n || y<0 || y>=m || a[x][y]!=Integer.MAX_VALUE){
                        continue;
                    }
                    a[x][y]=count;
                    list.addLast(new int[]{x,y});
                }
            }

        }
        return a;
    }
}
