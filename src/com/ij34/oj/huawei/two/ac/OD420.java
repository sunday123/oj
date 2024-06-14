package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 没完成
 * 矩阵匹配
 * https://hydro.ac/d/HWOD2023/p/OD420
 * @Author: ij34
 * @Date: 2024-06-10
 */

public class OD420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nmk = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        n=nmk[0];
        m=nmk[1];
        k=nmk[2];
        a=new int[n*m];

        for (int i=0;i<n;i++){
            int[] b = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int max=Arrays.stream(b).sorted().toArray()[k];
            for (int j=0;j<m;j++){
                if (b[j]<=max){
                    a[i*m+j]=b[j];
                }else {
                    a[i*m+j]=Integer.MAX_VALUE;
                }
            }

        }

        dfs(new LinkedList<>());
        System.out.println(kth);




    }
    private static int kth=Integer.MAX_VALUE;
    private static int[] a;
    private static int n,m,k;


    private static void dfs(LinkedList<Integer> list) {
        if (list.size()==n){
            List<Integer> temp =list.stream().map(m->a[m]).sorted((o1, o2) -> o2-o1).toList();
            kth=Math.min(kth,temp.get(k-1));
            return;
        }

        for (int i=0;i<a.length;i++){
            if (a[i]==Integer.MAX_VALUE || list.contains(i) || isSame(list,i)){
                continue;
            }
            list.addLast(i);
            dfs(list);
            list.removeLast();

        }



    }

    private static boolean isSame(LinkedList<Integer> list, int num) {
        int x=num/m,y=num%m;
        for (int l:list){
            if (x==(l/m) || y==(l%m)){
                return true;
            }
        }
        return false;
    }
}