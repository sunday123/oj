package com.ij34.oj.leetcode.sub;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 47. 全排列 II
 * https://leetcode.cn/problems/permutations-ii/
 *
 * @Author: ij34
 * @Date: 2024-05-11
 */

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] a) {
        backtrack(a,0);
        return resList;
    }

    private Set<String> hash = new HashSet<>();
    private List<List<Integer>> resList = new ArrayList<>();
    private void backtrack(int[] a,int start) {
        if (start==a.length){
            if (!hash.contains(Arrays.toString(a))){
                hash.add(Arrays.toString(a));
                resList.add(Arrays.stream(a).boxed().collect(Collectors.toList()));
            }
            return;
        }

        for (int i=start;i<a.length;i++){
            if (a[start]==a[i] && start!=i){
                continue;
            }
            swap(a,start,i);
            backtrack(a,start+1);
            swap(a,start,i);
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
