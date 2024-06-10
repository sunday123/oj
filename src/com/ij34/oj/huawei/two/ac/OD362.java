package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 智能成绩表
 * https://hydro.ac/d/HWOD2023/p/OD362
 * @Author: ij34
 * @Date: 2024-06-08
 */

public class OD362 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] s = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=s[0],m=s[1];
        List<String> courseList = Arrays.stream(sc.nextLine().split(" ")).toList();
        Map<Integer,String>   map  = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            String[] a=sc.nextLine().split(" ");
            map.put(i,a[0]);
            int[] b= new int[a.length];
            b[0]=i;
            for (int j=1;j<a.length;j++){
                b[j]=Integer.valueOf(a[j]);
            }
            list.add(b);
        }
        int index = courseList.indexOf(sc.nextLine())+1;

        list.sort((a, b) -> {
            int dif;
            if (index<1){
                 dif = Arrays.stream(b).sum()-b[0]-Arrays.stream(a).sum()+a[0];
            }else {
                 dif = b[index]-a[index];
            }
            if (dif==0){
                return map.get(a[0]).compareTo(map.get(b[0]));
            }
            return dif;
        });
        StringJoiner sj = new StringJoiner(" ");
        for (int i=0;i<list.size();i++){
            sj.add(map.get(list.get(i)[0]));
        }
        System.out.println(sj.toString());
    }
}
