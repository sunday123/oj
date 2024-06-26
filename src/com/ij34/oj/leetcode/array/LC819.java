package com.ij34.oj.leetcode.array;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> map = new HashMap<>();
        List<String> list = Arrays.stream(banned).toList();
        Matcher matcher = Pattern.compile("[a-zA-Z]+").matcher(paragraph.toLowerCase());
        while (matcher.find()){
            String str=matcher.group();
            if (list.contains(str)==false){
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }
        int max = 0;
        String res=null;
        for (Map.Entry<String,Integer> e: map.entrySet()){
            if (e.getValue()>max){
                max=e.getValue();
                res=e.getKey();
            }

        }
       return res;
    }



}
