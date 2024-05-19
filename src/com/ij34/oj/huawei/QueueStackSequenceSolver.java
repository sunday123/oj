package com.ij34.oj.huawei;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 篮球游戏
 * https://blog.csdn.net/weixin_48157259/article/details/135304492
 *
 * @Author: ij34
 * @Date: 2024-05-19
 */

public class QueueStackSequenceSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> a = new LinkedList<>(Arrays.stream(sc.nextLine().split(",")).map(m->Integer.valueOf(m)).collect(Collectors.toList()));
        LinkedList<Integer> b = new LinkedList<>(Arrays.stream(sc.nextLine().split(",")).map(m->Integer.valueOf(m)).collect(Collectors.toList()));
        StringBuilder sb = new StringBuilder();
        int len =a.size();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        while (b.isEmpty()==false){
            Integer bb = b.removeFirst();
            if (deque.isEmpty() && a.isEmpty()==false){
                deque.add(a.removeFirst());
            }
            if (deque.isEmpty()==false){
                if (deque.getFirst().equals(bb)){
                    sb.append("L");
                    deque.removeFirst();
                    continue;
                }else if (deque.size()>1 && deque.getLast().equals(bb)){
                    sb.append("R");
                    deque.removeLast();
                    continue;
                }else if (a.isEmpty()==false){
                    Integer aa = a.removeFirst();
                    while (aa.equals(bb)==false && a.isEmpty()==false){
                        deque.offer(aa);
                        aa=a.removeFirst();
                    }
                    if (aa.equals(bb)){
                        sb.append("R");
                    }else {
                        break;
                    }
                }else if (a.isEmpty() && deque.size()==1){//最后一个元素左边
                    if (deque.pop().equals(bb)){
                        sb.append("L");
                    }
                }

            }
        }
        System.out.println(sb.toString().length()==len?sb.toString():"NO");
    }
}
