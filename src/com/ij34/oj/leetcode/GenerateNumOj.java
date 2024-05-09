package com.ij34.oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角
 * https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class GenerateNumOj {
    public static void main(String[] args) {
        new GenerateNumOj().generate(5).forEach(System.out::println);

    }
    public List<List<Integer>> generate(int numRows) {
        if (numRows<=2){
            List<List<Integer>> resList = new ArrayList<>();
            for (int i=0;i<numRows;i++){
                List<Integer> list =new ArrayList<>();
                for (int j=0;j<=i;j++){
                    list.add(1);
                }
                resList.add(list);

            }
            return resList;
        }
        List<List<Integer>> resList = generate(numRows-1);
        List<Integer> list = resList.get(resList.size()-1);
        List<Integer> list2 =new ArrayList<>();
        list2.add(1);
        for(int i=0;i<list.size()-1;i++){
          list2.add(list.get(i)+list.get(i+1));
        }
        list2.add(1);
        resList.add(list2);
        return resList;
    }
}
