package com.ij34.oj.leetcode.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 692. 前K个高频单词
 * https://leetcode.cn/problems/top-k-frequent-words
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC692 {



    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for (String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<String> list = map.entrySet().stream().sorted((a, b) -> {
            if (a.getValue().equals(b.getValue())==false){
                return b.getValue()-a.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        }).map(Map.Entry::getKey).collect(Collectors.toList());
        return list.subList(0,k);




    }
}
