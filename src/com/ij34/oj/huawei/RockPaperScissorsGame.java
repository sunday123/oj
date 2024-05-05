package com.ij34.oj.huawei;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 石头剪刀布游戏
 * @Author: ij34
 * @Date: 2024-05-05
 */

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,String> map = new HashMap<>();
        int len =sc.nextInt();
        for (int i=0;i<len;i++){
            map.put(sc.next(),sc.next());
        }
        if (map.values().stream().collect(Collectors.toSet()).size()==3){
            System.out.println("NULL");
            return;
        }
        HashMap<String,Integer> result = new HashMap<>();
        for (Map.Entry<String,String> entry : map.entrySet()){
            int count =getCount(map,entry.getKey(),entry.getValue());
            if (count>0){
                result.put(entry.getKey(),count);
            }
        }
        if (result.isEmpty()){
            System.out.println("NULL");
        }else {
            result.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(a-> System.out.println(a.getKey()));
        }



    }

    private static int getCount(HashMap<String, String> map, String key, String value) {
        int count=0;
        for (Map.Entry<String,String> entry : map.entrySet()){
            if (entry.getKey().equals(key)){
                continue;
            }
            if ("A".equals(value) && "B".equals(entry.getValue())){
                count++;
            }
            if ("B".equals(value) && "C".equals(entry.getValue())){
                count++;
            }
            if ("C".equals(value) && "A".equals(entry.getValue())){
                count++;
            }
        }
        return count;
    }
}
