package com.ij34.oj.leetcode.sub;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode.cn/problems/combination-sum
 *
 * @Author: ij34
 * @Date: 2024-05-22
 */

public class CombinationSum {
    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[]{2},1).forEach(System.out::println);
    }
    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        for (int n : candidates){
            for (int i=0;i<target/n;i++){
                list.add(n);
            }
        }
        int[] a = list.stream().sorted().mapToInt(Integer::intValue).toArray();
        backtrack(a,target,0,new LinkedList<Integer>());
        return resList;
    }

    private void backtrack(int[] a,int target, int start, LinkedList<Integer> list) {
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        if (sum==target){
            resList.add(new ArrayList<>(list));
            return;
        }
        if (sum>target){
            return;
        }
        for (int i=start;i<a.length;i++){
            if (i>start && a[i]==a[i-1]){
                continue;
            }
            list.add(a[i]);
            backtrack(a,target,i+1,list);
            list.removeLast();
        }
    }
}
