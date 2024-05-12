package com.ij34.oj.huawei.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 足球队员射门能力排序
 * https://hydro.ac/d/HWOCR/p/OCR035
 * @Author: ij34
 * @Date: 2024-05-11
 */

public class FootBallSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        List<String> a = Arrays.stream(sc.nextLine().split(" ")).toList();
        List<List<Integer>> list = new ArrayList<>();
        for (String aa:a){
            List<Integer> l = new ArrayList<>();
            for (int i=0;i<aa.length();i++){
                l.add(Integer.valueOf(aa.substring(i,i+1)));
            }
            list.add(l);
        }
        String res =list.stream().sorted((aa, bb) -> {
                    long a1 = aa.stream().filter(f -> f == 1).count();
                    long b1 = bb.stream().filter(f -> f == 1).count();
                    if (a1 != b1) {
                        return (int) (b1 - a1);
                    }
                    //连续最多1个数
                    int a2= Arrays.stream(aa.stream().map(String::valueOf).collect(Collectors.joining()).split("0"))
                            .toList().stream().mapToInt(s->s.length()).boxed().max(Integer::compareTo).get();
                    int b2= Arrays.stream(bb.stream().map(String::valueOf).collect(Collectors.joining()).split("0"))
                            .toList().stream().mapToInt(s->s.length()).boxed().max(Integer::compareTo).get();
                    if (a2!=b2){
                        return b2-a2;
                    }
                    //比较0谁最先
                    String as  = aa.stream().map(String::valueOf).collect(Collectors.joining());
                    String bs  =bb.stream().map(String::valueOf).collect(Collectors.joining());
                    int a3=as.indexOf('0'),b3=bs.indexOf('0');
                    while (a3>=0 && b3>=0){
                        if (a3!=b3){
                            return b3-a3;
                        }
                        as=as.replaceFirst("0","");
                        bs=bs.replaceFirst("0","");
                        a3=as.indexOf('0');
                        b3=bs.indexOf('0');
                    }

                    //比较最初字符串位置
                    bs  =bb.stream().map(String::valueOf).collect(Collectors.joining());
                    as  =aa.stream().map(String::valueOf).collect(Collectors.joining());
                    return a.indexOf(as)-a.indexOf(bs);
                }).map(ll->ll.stream().map(String::valueOf)
                        .collect(Collectors.joining())).map(s->String.valueOf(a.indexOf(s)+1))
                .collect(Collectors.joining(" "));
        System.out.println(res);
    }
}
