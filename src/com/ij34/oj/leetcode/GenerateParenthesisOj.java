package com.ij34.oj.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 22. 括号生成
 * https://leetcode.cn/problems/generate-parentheses
 *  第8个，超时
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class GenerateParenthesisOj {


    public static void main(String[] args) {
        System.out.println(isOk(Arrays.stream("())(()".split("")).map(c->c.charAt(0)).collect(Collectors.toList()).toArray(new Character[0])));
        List<String> list =new GenerateParenthesisOj().generateParenthesis(8);
        for (String s:list){
            System.out.println(s);
        }



    }



    public List<String> generateParenthesis(int n) {
        Set<String> allList = new HashSet<>();
        Character[] a = new Character[n*2];
         for (int i=0;i<n;i++){
             a[i]='(';
             a[i+n]=')';
         }
         backtrack(a,0,allList);
        return new ArrayList<>(allList);
    }

    private void backtrack(Character[] a, int index ,Set<String> list) {
        if (index==a.length){
            if (a[0]=='(' && a[a.length-1]==')' && isOk(a)){
                String s= Arrays.stream(a).map(String::valueOf).collect(Collectors.joining());
                list.add(s);
            }
            return;
        }
        for (int i=index;i<a.length;i++){
            if (i!=index && a[i]==a[index]){
                continue;
            }
            swap(a,i,index);
            backtrack(a,index+1,list);
            swap(a,i,index);
        }
    }


    private static boolean isOk(Character[] a) {
        ArrayDeque<Character> deque = new ArrayDeque();
        for (int i=0;i<a.length;i++){
            if (a[i]=='('){
                deque.addLast(a[i]);
                continue;
            }
            if (deque.isEmpty()){
                return false;
            }
            deque.removeLast();
        }
        return deque.isEmpty();
    }

    private void swap(Character[] a, int i, int index) {
        Character t = a[i];
        a[i] =a[index];
        a[index] =t;
    }
}
