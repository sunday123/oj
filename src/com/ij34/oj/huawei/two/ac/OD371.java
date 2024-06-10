package com.ij34.oj.huawei.two.ac;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 万能字符单词拼写、掌握的单词个数
 * https://hydro.ac/d/HWOD2023/p/OD371
 * @Author: ij34
 * @Date: 2024-06-01
 */

public class OD371 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[] strings = new String[n];
        for (int i=0;i<n;i++){
            strings[i]= sc.nextLine();
        }
        Map<Character,Integer> map = new HashMap<>();
        int count=0;
        for (char c : sc.nextLine().toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i=0;i<strings.length;i++){
            int res=map.getOrDefault('?',0);
            Map<Character,Integer> temp= new HashMap<>();
            for (char c : strings[i].toCharArray()){
                temp.put(c,temp.getOrDefault(c,0)+1);
            }
            for (char c: temp.keySet()){
                if (map.containsKey(c)==false){
                    res-=temp.get(c);
                }else {
                    int a = map.get(c)-temp.get(c);
                    if (a>=0){
                        continue;
                    }else {
                        res+=a;
                    }
                }
                if (res<0){
                    break;
                }
            }
            count+=res>=0?1:0;
        }

        System.out.println(count);

    }
}
