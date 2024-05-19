package com.ij34.oj.huawei;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * OCR038. 会议通知转发总人数
 * https://hydro.ac/d/HWOCR/p/OCR038
 *
 * @Author: ij34
 * @Date: 2024-05-19
 */

public class MeetingNotificationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= Integer.valueOf(sc.nextLine());
        int m= Integer.valueOf(sc.nextLine());
        int[][] a = new int[n][m];
        for (int i=0;i<n;i++){
            a[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] start = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int K = Integer.valueOf(sc.nextLine());

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(start);
        a[start[0]][start[1]]=-1;
        int res=0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while (deque.isEmpty()==false){
            int[] pop = deque.pop();
            for (int[] d :dir){
                int x = pop[0]+d[0],y=pop[1]+d[1];
                if (x<0 || y<0 || x>=n || y>=m){
                    continue;
                }
                if (a[x][y]==K){
                    res++;
                    a[x][y]=-1; //做标志，避免重新遍历到
                    deque.offer(new int[]{x,y});
                }
            }
        }
        System.out.println(res);
    }
}
