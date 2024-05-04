package com.ij34.oj.huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 转盘寿司
 * @Author: ij34
 * @Date: 2024-05-04
 */

public class SushiConveyorBeltSolver {
    public static void main(String[] args) {

        int[] a = Arrays.stream(new Scanner(System.in).nextLine()
                .split( " ")).mapToInt(Integer::parseInt).toArray();

        int[] result = new int[a.length];
        List<Integer> initList= Arrays.stream(a).boxed().collect(Collectors.toList());

        LinkedList<Integer> list= new LinkedList<> ( initList);

        while (list.size()>1){{
            for (int i=0;i<list.size()-1;i++){
                if (list.get(i)>list.get(i+1)){
                   int index =initList.indexOf(list.get(i));
                   result[index]=list.get(i)+list.get(i+1);
                   list.remove(list.get(i));
                   break;
                }
            }
            if (list.get(list.size()-1)>list.get(0)){
                int index =initList.indexOf(list.get(list.size()-1));
                result[index]=list.get(list.size()-1)+list.get(0);
                list.remove(list.get(list.size()-1));
            }


        }}


        int index =initList.indexOf(list.get(list.size()-1));
        result[index]=list.get(list.size()-1);


        System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));;






    }
}
