package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 推荐多样性
 * https://hydro.ac/d/HWOD2023/p/OD406
 * @Author: ij34
 * @Date: 2024-06-03
 */

public class OD406 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int k = Integer.valueOf(sc.nextLine());
        List<String> stringList = new ArrayList<>();
        while (sc.hasNextLine()){
            stringList.add(sc.nextLine());
        }
        List<LinkedList<Integer>> aList = new ArrayList<>();
        for (int i=0;i< stringList.size();i++){
            aList.add(new LinkedList<>(Arrays.stream(stringList.get(i).split(" ")).map(Integer::valueOf).collect(Collectors.toList())));
        }
        List<Integer> reslist = new ArrayList<>();
        int i=0;
        while (i<n*k){
            int res=0;//上一次还差res个是
            for (LinkedList<Integer> list :aList){
                if (list.isEmpty()){
                    continue;
                }
                int count=0;
                count-=res;
                while (list.isEmpty()==false && count<n){
                    reslist.add(list.removeFirst());
                    i++;
                    count++;
                }
                res=(n-count)%n;
            }
        }
        List<Integer> an = new ArrayList<>();
        for (int j=0;j<n;j++){
            for(i=0;i<k;i++){
                int ii= i*n+j;
                an.add(reslist.get(ii));
            }
        }
        System.out.println(an.stream().map(String::valueOf).collect(Collectors.joining(" ")));



    }
}
