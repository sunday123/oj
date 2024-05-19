package com.ij34.oj.leetcode.sub;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  90. 子集 II
 *  https://leetcode.cn/problems/subsets-ii
 *
 * @Author: ij34
 * @Date: 2024-05-19
 */

public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0,new LinkedList<Integer>());
        return resList;
    }

    private List<List<Integer>> resList = new ArrayList<>();
    private void backtrack(int[] a,int start,LinkedList<Integer> list) {
        resList.add((new ArrayList<>(list)));
        for (int i=start;i<a.length;i++){
            if (i>start && a[i]==a[i-1]){
                continue;
            }
            list.add(a[i]);
            backtrack(a,i+1,list);
            list.removeLast();
        }
    }

}
