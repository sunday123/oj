package com.ij34.oj.leetcode.group;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 *  https://leetcode.cn/problems/group-anagrams
 *
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class GroupAnagramsOj {
    public static void main(String[] args) {
//        String a ="nat",b="tan",c="tna";
//        System.out.println('a'+'c'+'e');
//        System.out.println('a'+'b'+'f');
//        System.out.println(Arrays.stream(a.split("")).sorted().toList());
        new GroupAnagramsOj().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).forEach(System.out::println);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length<2){
                return List.of(List.of(strs.length>0?strs[0]:""));
            }
            Map<String,List<String>> map=new HashMap<>();
            for (String str : strs){
                String key =getKey(str);
                List<String> list = map.containsKey(key)?map.get(key):new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }

            List<List<String>> resList = new ArrayList<>();
            for (List<String>  list: map.values()){
                resList.add(list);
            }
            return resList;
    }

    private String getKey(String str) {
        if (str.length()<2){
            return str;
        }
        return Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
    }
}
