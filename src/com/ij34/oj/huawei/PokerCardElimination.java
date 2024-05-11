package com.ij34.oj.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 扑克牌消除
 * https://fcqian.blog.csdn.net/article/details/137889384
 * @Author: ij34
 * @Date: 2024-05-11
 */

public class PokerCardElimination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();//跳过
        //3 K A 2 2 2 A A K 7 7 7 K
        List<String> list =Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
        while (true){
            List<Integer> removeIndex  = new ArrayList<>();
            for (int i=0;i<list.size()-2;i++){
                if (list.get(i).equals(list.get(i+1)) && list.get(i).equals(list.get(i+2))){
                    removeIndex.add(i);
                    removeIndex.add(i+1);
                    removeIndex.add(i+2);
                    break;
                }
            }
            if (removeIndex.isEmpty()){
                System.out.println(list.isEmpty()?0:list.stream().collect(Collectors.joining(" ")));
                break;
            }
            while (removeIndex.isEmpty()==false){
                int i = removeIndex.get(removeIndex.size()-1);
                list.remove(i);
                removeIndex.remove(removeIndex.size()-1);
            }
        }
    }
}
