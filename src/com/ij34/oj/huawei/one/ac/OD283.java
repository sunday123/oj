package com.ij34.oj.huawei.one.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 最大N个数与最小N个数的和
 * https://hydro.ac/d/HWOD2023/p/OD283
 *
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD283 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =Integer.valueOf(sc.nextLine());
        int[] a = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::valueOf).toArray();
        int k=Integer.valueOf(sc.nextLine());

        for (int aa :a){
            if (aa<0 || aa>1000){
                System.out.println(-1);
                return;
            }
        }
        if (k<1){
            System.out.println(-1);
            return;
        }

        List<Integer> list = new ArrayList<>(Arrays.stream(a).boxed().sorted().toList());
        for (int i=1;i<list.size();i++){
            if (list.get(i).equals(list.get(i-1))){
                list.set(i-1,null);
            }
        }
        a=list.stream().filter(f->f!=null).sorted().mapToInt(Integer::valueOf).toArray();

        if (2*k>a.length){
            System.out.println(-1);
            return;
        }

        Arrays.sort(a);
        int max=a[k-1];
        int min=a[a.length-k];
        if (min<=max){
            System.out.println(-1);
            return;
        }

        System.out.println(Arrays.stream(Arrays.copyOfRange(a,0,k)).sum()
                +Arrays.stream(Arrays.copyOfRange(a,a.length-k,a.length)).sum());








    }
}
