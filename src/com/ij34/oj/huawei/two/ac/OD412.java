package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 字符串拼接
 * https://hydro.ac/d/HWOD2023/p/OD412
 * @Author: ij34
 * @Date: 2024-06-07
 */

public class OD412 {
    public static void main(String[] args) {
        String[] s = new Scanner(System.in).nextLine().split(" ");
        String str =s[0];
        int k=Integer.valueOf(s[1]);
        if (k>str.length()){
            System.out.println(0);
            return;
        }

        char[] a = str.toCharArray();
        for (char c :a){
            if ((c>='a' && c<='z')==false){
                System.out.println(0);
                return;
            }
        }


        backtrack(a,new LinkedList<Integer>(),k);
        System.out.println(set.size());

    }

    private static void backtrack(char[] a,LinkedList<Integer> list,int k) {
        if (list.size()>1){
            for (int i=0;i<list.size()-1;i++){
                if (a[list.get(i)]==a[list.get(i+1)]){
                    return;
                }
            }
        }
        if (list.size()==k){
            for (int i=0;i<list.size()-1;i++){
                if (a[list.get(i)]==a[list.get(i+1)]){
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<list.size();i++){
                sb.append(a[list.get(i)]);
            }
            set.add(sb.toString());
            return;
        }
        for(int i=0;i<a.length;i++){
            if (list.contains(i)){
                continue;
            }
            list.addLast(i);
            backtrack(a,list,k);
            list.removeLast();

        }



    }

    private static Set<String> set = new HashSet<>();
}
