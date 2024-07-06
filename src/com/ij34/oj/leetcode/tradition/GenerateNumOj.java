package com.ij34.oj.leetcode.tradition;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class GenerateNumOj {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList =new ArrayList<>();
        for (int i=1;i<=numRows;i++){
            resList.add(getRow(i));
        }
        return resList;
    }

    private List<Integer> getRow(int n) {
        List<Integer> list = new ArrayList<>();
        if (n<=2){

            for (int i=0;i<n;i++){
                list.add(1);
            }
            return list;
        }
        List<Integer> preList = getRow(n-1);
        list.add(1);
        for (int i=1;i<preList.size();i++){
            list.add(preList.get(i-1)+preList.get(i));
        }
        list.add(1);
        return list;
    }

}
