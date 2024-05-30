package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 没完成
 * 田忌赛马
 * https://hydro.ac/d/HWOD2023/p/OD425
 * @Author: ij34
 * @Date: 2024-05-20
 */

public class TianJiHorseRacingStrategy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        backtrack(a, new LinkedList<>());

        aList.forEach(System.out::println);
        Map<Integer,Integer> map = new HashMap<>();
        for (List<Integer> l : aList) {
          int sucess =isSuccess(l, b);
          map.put(sucess,map.getOrDefault(sucess,0)+1);

        }
        int max=Integer.MIN_VALUE;
        for (Integer k:map.keySet()){
            max=max>k?max:k;
        }
        System.out.println(map.get(max));
    }

    private static int isSuccess(List<Integer> l, int[] b) {
        int count=0;
        for(int i=0;i<b.length;i++){
            if (l.get(i)>b[i]){
                count++;
            }
        }
        return count;
    }

    private static void backtrack ( int[] a, LinkedList<Integer > list){
            if (list.size() == a.length) {
                List<Integer> temp = new ArrayList<>();
                for (int i:list){
                    temp.add(a[i]);
                }
                String hash = temp.toString();
                if (aSet.contains(hash)==false){
                    aList.add(temp);
                    aSet.add(hash);
                }
                return;
            }
            for (int i = 0; i < a.length; i++) {
                if (list.contains(i)) {
                    continue;
                }
                list.addLast(i);
                backtrack(a, list);
                list.removeLast();
            }
        }
        private static Set<String> aSet = new HashSet<>();
        private static List<List<Integer>> aList = new ArrayList<>();

}