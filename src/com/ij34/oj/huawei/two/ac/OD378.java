package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 攀登者2
 * https://hydro.ac/d/HWOD2023/p/OD378
 *
 * @Author: ij34
 * @Date: 2024-06-09
 */

public class OD378 {

    private static int weight;
    private static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        weight = Integer.valueOf(sc.nextLine());
        List<Integer> zeroList = new ArrayList<>();
        for (int i=0;i<a.length;i++){
            if (a[i]==0){
                zeroList.add(i);
            }
        }
        if (zeroList.isEmpty()){
            System.out.println(0);
            return;
        }

        for (int i=0;i<zeroList.size();i++){
            if(i+1<zeroList.size()){
                climb(a,zeroList.get(i),zeroList.get(i+1),false);
                climb(a,zeroList.get(i),zeroList.get(i+1),true);
                climb2(a,zeroList.get(i),zeroList.get(i+1),false);
                climb2(a,zeroList.get(i),zeroList.get(i+1),true);
            }
        }

        //2 1 0
        int index = zeroList.get(0);
        if (index>1){
            climb2(a,0,index,true);
        }

        //0 2 1
        index=zeroList.get(zeroList.size()-1);
        if (index<a.length-2){
            climb2(a,index,a.length-1,false);
        }
        System.out.println(set.size());

    }
    //单方向爬，从原路下山。
    private static void climb2(int[] array,int start,int end,boolean reverse) {
        if (array.length<3){
            return;
        }
        int[] a;
        if (reverse==false){
            a=Arrays.copyOfRange(array,start,end+1);
        }else {
            a=reverse(array,start,end);
        }
        int k=weight,to=0;
        for (int i=1;i<a.length;i++){
            if (k<0){
                break;
            }
            int b = Math.abs(a[i]-a[i-1])*3;
            if (k>=b){
                to=i;
                k-=b;
            }else {
                break;
            }
        }
        if (k<0){
            return;
        }
//        System.out.println(Arrays.toString(a)+"|"+to+"k:"+k);
        for (int i=0;i<=to-2;i++){
            if (a[i+1]>a[i] && a[i+1]>a[i+2]){
                int x=i+1;
                if (reverse==false){
                    x+=start;
                }else {
                    x=end-x;
                }
//                System.out.println(Arrays.toString(a)+"|"+to+"|"+reverse);
                set.add(x);
            }

        }

    }

    private static int[] reverse(int[] a, Integer i, int j) {
        int[] b= new int[j-i+1];
        for (int t=0;t<b.length;t++){
            b[t]=a[j-t];
        }
        return b;
    }


    //左到右
    private static void climb(int[] array,int start,int end,boolean reverse) {
        if (array.length<3){
            return;
        }
        int[] a;
        if (reverse==false){
            a=Arrays.copyOfRange(array,start,end+1);
        }else {
            a=reverse(array,start,end);
        }
        //左边往右直到下山。
        int k=weight;
        for (int i=1;i<a.length;i++){
            if (a[i]>a[i-1]){
                k-=Math.abs(a[i]-a[i-1])*2;
            }else if (a[i-1]>a[i]){
                k-=Math.abs(a[i]-a[i-1]);
            }
            if (k<0){
                return;
            }
        }
        if (k<0){
            return;
        }
        for (int i=0;i<a.length-2;i++){
            if (a[i+1]>a[i] && a[i+1]>a[i+2]){
                int x=i+1;
                if (reverse==false){
                    x+=start;
                }else {
                    x=end-x;
                }
                set.add(x);
            }

        }

    }
}
