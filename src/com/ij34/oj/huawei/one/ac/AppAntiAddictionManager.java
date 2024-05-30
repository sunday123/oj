package com.ij34.oj.huawei.one.ac;
/**
 * 手机App防沉迷系统
 * https://hydro.ac/d/HWOD2023/p/OD411
 */

import java.util.*;


public class AppAntiAddictionManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());

        LinkedList<int []> list = new LinkedList<>();
        for (int i=0;i<n;i++){
            String str =sc.nextLine();
            String[] s = str.split(" ");
            int name = Integer.valueOf(s[0].substring(3));
            int score = Integer.valueOf(s[1]);
            int start = Integer.valueOf(s[2].replace(":",""));
            int end = Integer.valueOf(s[3].replace(":",""));

            boolean isAdd =true;
            List<Integer> delIndexList = new ArrayList<>();
            for (int j=0;j<list.size();j++){
                int[] pre = list.get(j);
//                if (start>=pre[3] || end<=pre[2]){
//                    continue;
//                }
//                if ((start>=pre[2] && start<pre[3]) || (end>pre[2] && end<=pre[3])){ //有误
                    if (score>pre[1]){
                        delIndexList.add(j);
                    }else {
                        isAdd=false;
                    }
//                }
            }
            if (isAdd){
                delIndexList.sort((c, d) -> d-c);
                for (int index: delIndexList){
                    list.remove(index);
                }
                list.addLast(new int[]{name,score,start,end});;
            }

        }
        int k = Integer.valueOf(sc.nextLine().replace(":",""));
        String res ="NA";
        for (int[] a :list){
            if (k>=a[2] && k<a[3]){
                res="App"+a[0];
                break;
            }
        }
        System.out.println(res);
    }
}