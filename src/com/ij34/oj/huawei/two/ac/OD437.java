package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 找单词
 * https://hydro.ac/d/HWOD2023/p/OD437
 *
 * @Author: ij34
 * @Date: 2024-06-06
 */

public class OD437 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int[][] a = new int[n][n];
        for (int i=0;i<n;i++){
            a[i] = Arrays.stream(scanner.nextLine().split(",")).map(m->(int)m.charAt(0)).mapToInt(Integer::intValue).toArray();
        }
        int[] target = Arrays.stream(scanner.nextLine().split("")).map(m->(int)m.charAt(0))
                .mapToInt(Integer::intValue).toArray();

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (a[i][j]==target[0]){
                    LinkedList<int[]> resList = new LinkedList<>();
                    resList.addLast(new int[]{i,j});
                    boolean[][] used = new boolean[a.length][a[0].length];
                    used[i][j]=true;
                    process(a,n,i,j,target,resList,used);
                    if (res!=null){
                        System.out.println(res);
                        return;
                    }

                }
            }
        }
        System.out.println("N");

    }






    private static String res=null;
    private static void process(int[][] a,int n, int i, int j, int[] target,LinkedList<int[]> list,boolean[][] used) {
        if (res!=null){
            return;
        }

        if (list.size()== target.length){
            StringJoiner sj = new StringJoiner(",");
            for (int x=0;x<list.size();x++){
                int[] b =list.get(x);
                sj.add(b[0]+","+b[1]);
            }
            res=new String(sj.toString());
            return;
        }




        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d :dir){
            int x = d[0]+i,y=d[1]+j;
            if (x>=0 && y>= 0 && x<n && y<n && used[x][y]==false && a[x][y]==target[list.size()]){
                list.addLast(new int[]{x,y});
                used[x][y]=true;
                process(a,n,x,y,target,list,used);
                if (res!=null){
                    return;
                }
                used[x][y]=false;
                list.removeLast();
            }
        }

    }
}
