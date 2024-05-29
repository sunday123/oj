package com.ij34.oj.huawei.one.ac;

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

        int[] result = Arrays.stream(new Scanner(System.in).nextLine()
                .split( " ")).mapToInt(Integer::parseInt).toArray();


        List<Integer> initList= Arrays.stream(result).boxed().collect(Collectors.toList());

        LinkedList<Integer> list= new LinkedList<> ();
        list.addAll(initList);
        list.addAll(initList);
        for (int i=0;i<result.length;i++){
            for (int j=i+1;j<list.size();j++){
                if (list.get(j)<result[i]){
                    result[i]+= list.get(j);
                    break;
                }
            }

        }
        System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));;

    }
}
