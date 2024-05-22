package com.ij34.oj.leetcode.dbfs;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 *
 * @Author: ij34
 * @Date: 2024-05-22
 */

public class LetterCombinations {
    /**
     * 暴力
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"qprs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        List<String> list = new ArrayList<>();
        for (char c : digits.toCharArray()){
            if (list.isEmpty()){
                for (char cc: map.get(c-'0').toCharArray()){
                    list.add(String.valueOf(cc));
                }
                continue;
            }
            List<String> tempList = new ArrayList<>();
            for (String s : list){
                for (char cc: map.get(c-'0').toCharArray()){
                    tempList.add(s+cc);
                }
            }
            list= new ArrayList<>(tempList);
        }
        return list;
    }

    /**
     * 回溯
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"qprs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        backtrack(digits,0,digits.length(),new StringBuilder(),map);
        return resList;
    }

    private void backtrack(String digits, int index, int len, StringBuilder sb,Map<Integer,String> map) {
        if (digits.isEmpty()){
            return;
        }
        if (index==len){
            resList.add(sb.toString());
            return;
        }
        for (char c : map.get(digits.charAt(index)-'0').toCharArray()){
            sb.append(c);
            backtrack(digits,index+1,len,sb,map);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    private List<String> resList = new ArrayList<>();

}
