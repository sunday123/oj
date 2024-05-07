package com.ij34.oj.huawei;

import java.util.*;

/**
 * 内存资源分配
 * @Author: ij34
 * @Date: 2024-05-07
 */

public class MemoryAllocator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sss =sc.nextLine().split(",");
        int[] a = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        List<Integer> list = new ArrayList<>();
        for (String ss: sss){
            String[] s = ss.split(":");
            int v = Integer.valueOf(s[0]);
            int count = Integer.valueOf(s[1]);
            for(int i=0;i<count;i++){
                list.add(v);
            }
        }
        list.sort((x, y) -> x-y);
        boolean[] res = new boolean[a.length];
        for (int j=0;j<a.length;j++){
            for (int i=0;i<list.size();i++){
                if (list.get(i)>=a[j]){
                    res[j]=true;
                    list.remove(i);
                    break;
                }
            }
        }
        String result ="";
        for (int i=0;i<res.length;i++){
            result += res[i] +",";
        }
        System.out.println(result.substring(0,result.length()-1));

    }
}
