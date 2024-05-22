package com.ij34.oj.leetcode.sub;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * https://leetcode.cn/problems/palindrome-partitioning
 *
 * @Author: ij34
 * @Date: 2024-05-22
 */

public class PalindromePartitioner {

    public List<List<String>> partition(String s) {
        backtrack(s,0,new ArrayList<>());
        return resList;
    }

    private void backtrack(String s, int index,List<String> res) {
        if (index==s.length()){
            resList.add(new ArrayList<>(res));
            return;
        }
        for (int i=index;i<s.length();i++){
            if (isPartition(s,index,i)){
                res.add(s.substring(index,i+1));
                backtrack(s,i+1,res);
                res.remove(res.size()-1);
            }
        }

    }

    private List<List<String>> resList = new ArrayList<>();
    private boolean isPartition(String s, int start, int end) {
        for (int i=0; i<(end-start+1)/2;i++){
            if (s.charAt(start+i)!=s.charAt(end-i)){
                return false;
            }
        }
        return true;
    }
}
