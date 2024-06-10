package com.ij34.oj.huawei.two.ac;

import java.util.Scanner;

/**
 *
 * 简易内存池
 * https://hydro.ac/d/HWOD2023/p/OD436
 *
 * @Author: ij34
 * @Date: 2024-06-03
 */

public class OD436 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =Integer.valueOf(sc.nextLine());
        String[] commands = new String[n];
        for (int i=0;i<n;i++){
            commands[i]= sc.nextLine();
        }
        sc.close();
        int[] used= new int[101];
        for (int i=0;i<n;i++){
            String[] strings = commands[i].split("=");
            String a =strings[0];
            int size = Integer.valueOf(strings[1]);
            if ("REQUEST".equals(a)){
                int first = request(used,size);
                System.out.println(first<0?"error":first);
            }

            if ("RELEASE".equals(a)){
                if (release(used,size)==false){
                    System.out.println("error");
                }
            }
        }




    }

    private static boolean release(int[] used, int start) {
        if (start<0 ||start>=used.length || used[start]==0){
            return false;
        }

        int head = used[start];
        if (start>0 && used[start-1]==head){
            return false;
        }
        while (start<used.length){
            if (used[start]==head){
                used[start]=0;
                start++;
            }else {
                break;
            }

        }

        return true;
    }
    private static int index=1;
    private static int request(int[] used, int size) {
        if (size<1 || size>=used.length){
            return -1;
        }
        int zeroCount=0;//保持长度size的滑动窗口
        int l=0,r=size-1;
        for (int i=0;i<size;i++){
            if (used[i]==0){
                zeroCount++;
            }
        }
        while (r<used.length){
            if (zeroCount==size){
                for (int i=l;i<=r;i++){
                    used[i]=index;
                }
                index++;
                return l;
            }
            r++;
            if (r>=used.length){
                break;
            }
            zeroCount+=used[r]==0?1:0;
            zeroCount-=used[l]==0?1:0;
            l++;
        }
        return -1;
    }

}
