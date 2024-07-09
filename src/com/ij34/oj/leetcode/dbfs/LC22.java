package com.ij34.oj.leetcode.dbfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 22. 括号生成
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * @Author: ij34
 * @Date: 2024-06-24
 */

public class LC22 {

    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(new StringBuilder(),0,0,n-1);
        return list;
    }
    public boolean isValid(String s) {
        char[] cs = s.toCharArray();
        if (cs.length<2){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c:cs){
            if (List.of('(').contains(c)){
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()){
                return false;
            }
            char pop = stack.pop();
            if (c==')'){
                c='(';
            }
            if (pop!=c){
                return false;
            }


        }
        return stack.isEmpty();
    }

    private void dfs(StringBuilder sb, int left, int right, int k) {
        if (sb.length()==2*k){
            if (left==k && right==k){
                String s="("+ sb +")";
                if (isValid(s)){
                    list.add(s);
                }
            }

            return;
        }
        if (left<k){
            sb.append("(");
            dfs(sb,left+1,right,k);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right<k){
            sb.append(")");
            dfs(sb,left,right+1,k);
            sb.deleteCharAt(sb.length()-1);
        }


    }



}
