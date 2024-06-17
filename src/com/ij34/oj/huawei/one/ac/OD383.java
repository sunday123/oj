package com.ij34.oj.huawei.one.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 求幸存数之和
 * https://hydro.ac/d/HWOD2023/p/OD383
 * 不能用递归
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD383 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int jump=Integer.valueOf(sc.nextLine()),left=Integer.valueOf(sc.nextLine());
        System.out.println(sumOfLeft(nums,jump,left));
    }
    private static int sumOfLeft(int[] nums, int jump, int left){

        if (left<1){
            return 0;
        }
        List<Integer> list = process(new ArrayList<>(Arrays.stream(nums).boxed().toList()),(jump+1)%nums.length,jump+1,left);
        return list.stream().reduce(0,Integer::sum).intValue();
    }

    //保证合法传入delIndex
    private static List<Integer> process(ArrayList<Integer> list, int delIndex, int k, int len) {
        if (list.size()<=len){
            return list;
        }
        while (list.size()>len){//不能用递归，深度太大，报错
            list.remove(delIndex);
            delIndex-=1;
            delIndex+=k;
            delIndex%=list.size();//防止循环遍历到起点start
        }
        return list;
    }


}
