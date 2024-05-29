package com.ij34.oj.huawei.one.ac;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * OD268. 字符串变换最小字符串
 * https://hydro.ac/d/HWOD2023/p/OD268
 * @Author: ij34
 * @Date: 2024-05-29
 */

public class MinimumStringTransformer {
    public static void main(String[] args) {
        String [] array = Arrays.stream(new Scanner(System.in).nextLine().split("")).toArray(String[]::new);
        if (array.length<3){
            Arrays.sort(array);
            System.out.println(Arrays.stream(array).collect(Collectors.joining()));
            return;
        }
        List<String> list = Arrays.stream(array).sorted().toList();
        boolean flag =true;
        for(int i=0;i<list.size() && flag;i++){
            if (array[i].equals(list.get(i))==false){
                for (int j=list.size()-1;j>i && flag;j--){
                    if (array[j].equals(list.get(i))){
                        String t = array[i];
                        array[i] = array[j];
                        array[j]=t;
                        flag=false;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.stream(array).collect(Collectors.joining()));

    }
}
