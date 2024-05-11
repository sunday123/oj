package com.ij34.oj.huawei.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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
//        sc.nextLine();
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

                    List<String> aList =Arrays.stream(aa.stream().map(String::valueOf).collect(Collectors.joining()).split("0"))
                            .filter(f->f.length()>0).sorted((o1, o2) -> o2.length()-o1.length()).toList();
                    aList = new ArrayList<>(aList);
                    String as  = aa.stream().map(String::valueOf).collect(Collectors.joining());
                    List<String> bList =Arrays.stream(bb.stream().map(String::valueOf).collect(Collectors.joining()).split("0"))
                            .filter(f->f.length()>0).sorted((o1, o2) -> o2.length()-o1.length()).toList();
                    bList=new ArrayList<>(bList);
                    String bs  =bb.stream().map(String::valueOf).collect(Collectors.joining());
                    while (aList.isEmpty()==false && bList.isEmpty()==false){
                        String at= aList.get(0),bt=bList.get(0);
                        System.out.println(aList+"="+bList);
                        aList.remove(0);
                        bList.remove(0);
                        if (at.length()!=bt.length()){
                            System.out.println(at+"|"+bt);
                            return at.length()-bt.length();
                        }
                        int ai = as.indexOf(at),bi=bs.indexOf(bt);
                        if (ai!=bi){
                            return ai-bi;
                        }
                        as.replace(at, IntStream.generate(()->2).limit(at.length()).mapToObj(String::valueOf).collect(Collectors.joining()));
                        bs.replace(bt, IntStream.generate(()->2).limit(bt.length()).mapToObj(String::valueOf).collect(Collectors.joining()));
                    }
                    bs  =bb.stream().map(String::valueOf).collect(Collectors.joining());
                    as  =aa.stream().map(String::valueOf).collect(Collectors.joining());
//                    System.out.println(as+"|"+a.indexOf(as));
//                    System.out.println(as+"|"+a.indexOf(bs));
                    return a.indexOf(as)-a.indexOf(bs);
                }).map(ll->ll.stream().map(String::valueOf)
                        .collect(Collectors.joining())).map(s->String.valueOf(a.indexOf(s)+1))
                .collect(Collectors.joining(" "));
        System.out.println(res);
    }
}
