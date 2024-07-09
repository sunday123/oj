package com.ij34.oj.leetcode.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 1249. 移除无效的括号
 * https://leetcode.cn/problems/minimum-remove-to-make-valid-parentheses
 *
 * @Author: ij34
 * @Date: 2024-07-09
 */

public class LC1249 {

    public String minRemoveToMakeValid(String s) {
        char[] cs = s.toCharArray();
        int leftCount=0,rightCount=0;//stack里面()的数量
        Stack<Character> stack = new Stack<>();
        for (char c:cs){
            if (c!=')'){
                stack.push(c);
                if (c=='('){
                    leftCount++;
                }
                continue;
            }
            if (leftCount<=rightCount){//关键不匹配不加入）
                continue;
            }
            stack.push(c);
            rightCount++;


        }
        List<Character> list = new ArrayList<>();
        leftCount=0;
        rightCount=0;
        while (stack.isEmpty()==false){
            char pop = stack.pop();
            if (pop=='('){
                leftCount++;
            }else if (pop==')'){
                rightCount++;
            }
            list.add(pop);
        }
        int dif = leftCount-rightCount;
        while (dif>0){//删除右边的（
            list.remove((Character) '(');
            dif--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : list){
            sb.append(c);
        }
        return sb.reverse().toString();
    }

}
