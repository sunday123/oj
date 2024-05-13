package com.ij34.oj.huawei;

import java.util.*;

/**
 * 发广播
 * https://hydro.ac/d/HWOD2023/p/OCR003
 * @Author: ij34
 * @Date: 2024-05-13
 */

public class BroadcastSender  {
    public static void main(String[] args) {
        String[] s = new Scanner(System.in).nextLine().split(",");
        int n = s.length,m=s[0].length();
        int[][] a = new int[n][m];
        HashSet<Integer> inList = new HashSet<>();
        for (int i=0;i<n;i++){
            a[i] =  Arrays.stream(s[i].split("")).mapToInt(Integer::parseInt).toArray();
        }
        int res =0;
        for(int i=0;i<n;i++){
            if (inList.contains(i)){
                continue;
            }
            res++;
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int j=0;j<m;j++){
                if (a[i][j]==1){
                    inList.add(j);
                    if (i!=j){
                        deque.addLast(j);
                    }
                }
            }
            while (deque.isEmpty()==false){
                int ii = deque.removeFirst();
                if (inList.contains(ii)){
                    continue;
                }
                for (int j=0;j<m;j++){
                    if (a[ii][j]==1){
                        inList.add(j);
                        if (ii!=j){
                            deque.addLast(j);
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}
