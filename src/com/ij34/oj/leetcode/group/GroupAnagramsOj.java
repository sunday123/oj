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
       return Arrays.stream(strs).collect(Collectors.groupingBy(str->{
            return Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
        })).values().stream().toList();
    }


}
