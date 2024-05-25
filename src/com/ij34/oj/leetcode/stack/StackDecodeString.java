package com.ij34.oj.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 394. 字符串解码
 *  https://leetcode.cn/problems/decode-string
 * @Author: ij34
 * @Date: 2024-05-25
 */

public class StackDecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("abc3[cd]xyz"));
    }

    public static String decodeString(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (c!=']'){
                deque.offerLast(c);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (deque.isEmpty()==false && deque.getLast().equals('[')==false){
                sb.append(deque.removeLast());
            }
            deque.removeLast();
            String str = sb.reverse().toString();
            sb = new StringBuilder();
            while (deque.isEmpty()==false && deque.getLast()<='9' && deque.getLast()>='0'){
                sb.append(deque.removeLast());
            }
            int len = Integer.valueOf(sb.reverse().toString());
            sb = new StringBuilder();
            for (int i=0;i<len;i++){
                sb.append(str);
            }
            for (char cc : sb.toString().toCharArray()){
                deque.offerLast(cc);
            }

        }
        return deque.stream().toList().stream().map(Objects::toString).collect(Collectors.joining());
    }


}
