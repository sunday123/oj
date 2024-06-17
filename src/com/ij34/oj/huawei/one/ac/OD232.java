package com.ij34.oj.huawei.one.ac;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 英文输入法
 * https://hydro.ac/d/HWOD2023/p/OD232
 *
 * 去重-字段排序
 *
 * @Author: ij34
 * @Date: 2024-06-17
 */

public class OD232 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> wordList=new HashSet<>();
        Matcher matcher = Pattern.compile("[a-zA-Z]+").matcher(sc.nextLine());
        while (matcher.find()){
            wordList.add(matcher.group());
        }

        String key=sc.nextLine();
        List<String> list= wordList.stream().filter(f->f.startsWith(key)).collect(Collectors.toList());
        if (list.isEmpty()){
            System.out.println(key);
        }else {
            System.out.println(list.stream().sorted().collect(Collectors.joining(" ")));
        }
    }
}
