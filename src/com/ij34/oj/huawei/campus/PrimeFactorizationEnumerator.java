package com.ij34.oj.huawei.campus;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  整数分解结果的枚举
 *  https://blog.csdn.net/qfc_128220/article/details/135978192?spm=1001.2014.3001.5501
 *
 * @Author: ij34
 * @Date: 2024-05-19
 */

public class PrimeFactorizationEnumerator {
    private static List<List<Integer>> resList = new ArrayList<>();
    private static Set<String> hash = new HashSet<>();
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        process(N,new ArrayList<>());
        resList.stream().sorted(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.size()!=o2.size()){
                    return o2.size()-o1.size();
                }
                String c=o1.stream().map(String::valueOf).collect(Collectors.joining());
                String d=o2.stream().map(String::valueOf).collect(Collectors.joining());
                return c.compareTo(d);
            }
        }).forEach(list->{
            String str = N+"="+list.stream().map(Objects::toString).collect(Collectors.joining("*"));
            System.out.println(str);
        });
    }

    private static void process(int n, List<Integer> list) {
        if (list.isEmpty()){
            resList.add(List.of(n));
        }
        if (List.of(1,2,3,5,7,11,13).contains(n)){
            return;
        }

        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0){
                List<Integer> temp = new ArrayList<>(List.of(i,n/i));
                temp.addAll(list);
                temp=temp.stream().sorted().collect(Collectors.toList());
                if (hash.contains(temp.toString())==false){
                    hash.add(temp.toString());
                    resList.add(temp);
                }
                List<Integer> list1 = new ArrayList<>(list);
                list1.add(i);
                process(n/i,list1);
                List<Integer> list2 = new ArrayList<>(list);
                list2.add(n/i);
                process(i,list2);
            }
        }
    }
}
