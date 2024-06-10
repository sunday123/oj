package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 解密犯罪时间
 * https://hydro.ac/d/HWOD2023/p/OD314
 *
 * @Author: ij34
 * @Date: 2024-06-08
 */

public class OD314 {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        current=str.replaceAll(":","");
        int[] a = Arrays.stream(str.replaceAll(":","").split("")).mapToInt(Integer::parseInt).toArray();
        if (a[0]==a[1] && a[1]==a[2] && a[2]==a[3]){
            System.out.println(str);
            return;
        }
        bt(a,0, new LinkedList<Integer>());
        System.out.println(next.substring(0,2)+":"+next.substring(2));


    }
    private static String current;
    private static String next;

    private static int minTime=Integer.MAX_VALUE;
    private static void bt(int[] a, int index, LinkedList<Integer> list) {
        if (list.size()==4){

            if (check(list)==false){
                return;
            }
            String str = list.stream().map(String::valueOf).collect(Collectors.joining());

            if (str.compareTo(current)>0){
                int dif = Integer.valueOf(str)-Integer.valueOf(current);
                if (dif<minTime){
                    minTime=dif;
                    next=str;
                }

            }else if (str.compareTo(current)<0){
                int dif =2359- Integer.valueOf(current)+Integer.valueOf(str);
                if (dif<minTime){
                    minTime=dif;
                    next=str;
                }

            }
            return;
        }
        for (int i=0;i<a.length;i++){
            list.add(a[i]);
            bt(a,index+1,list);
            list.removeLast();
        }
    }

    private static boolean check(LinkedList<Integer> list) {
        int one = Integer.valueOf(""+list.get(0)+list.get(1));
        if (one<0 || one>23){
            return false;
        }
        one = Integer.valueOf(""+list.get(2)+list.get(3));
        if (one<0 || one>59){
            return false;
        }
        return true;
    }
}
