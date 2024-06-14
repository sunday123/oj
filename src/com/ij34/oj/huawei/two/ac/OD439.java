package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 中文分词模拟器
 * https://hydro.ac/d/HWOD2023/p/OD439
 * 词典只能用一次
 * @Author: ij34
 * @Date: 2024-06-11
 */

public class OD439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String[] dictionaryInput = sc.nextLine().split(",");
        Set<String> dictionary = new HashSet<>(Arrays.asList(dictionaryInput));

        List<String> list = new ArrayList<>();
        for (String str :sentence.split("[,.;]+")){
            list.addAll(process(str, dictionary));
        }



        System.out.println(list.stream().collect(Collectors.joining(",")));
    }

    private static List<String> process(String str, Set<String> dictionary) {
        int len =str.length();
        int pre=0;
        String cur=str;
        List<String> list = new ArrayList<>();
        while (pre<len){
            cur=str.substring(pre,len);
            while (cur.length()>0 && dictionary.contains(cur)==false){
                cur=cur.substring(0,cur.length()-1);
            }

            if (cur.length()<1){
                cur=str.substring(pre+cur.length(),pre+cur.length()+1<len?pre+cur.length()+1:len);
            }
            if (cur.isEmpty()){
                continue;
            }
            list.add(cur);
            dictionary.remove(cur);
            pre+=cur.length();
        }

        return list;
    }
}
