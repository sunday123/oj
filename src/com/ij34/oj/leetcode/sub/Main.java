package com.ij34.oj.leetcode.sub;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 42. 接雨水
 * https://leetcode.cn/problems/trapping-rain-water
 *
 * @Author: ij34
 * @Date: 2024-05-21
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("res:"+new Main().trap(Arrays.stream(new Scanner(System.in).nextLine().split(",")).mapToInt(Integer::parseInt).toArray()));
    }

    public int trap(int[] height) {
        int res=0,leftH=0,rightH=0;
        for (int i=0,j=height.length-1;i<height.length && j>=0;i++,j--){
            leftH=Math.max(leftH,height[i]);
            rightH=Math.max(rightH,height[j]);
            res+=leftH+rightH-height[i];
        }
        return res-height.length*leftH;
    }

    public int trap2(int[] height) {
        LinkedList<Integer> list = new LinkedList<>();//确保左边是最大数字比如 3 2 0 0  ,如果遇到4队列就变成4
        int res = 0;

        for (int h : height) {
            if (list.isEmpty() || list.getLast().compareTo(h) >= 0) {
                list.addLast(h);
                continue;
            }
            for (int i = list.size() - 2; i >= 0; i--) {
                if (list.get(i) > list.get(i + 1) && list.get(i+1)<h) {
                    res+=(list.size() - i - 1) * (Math.min(h, list.get(i)) - list.get(i + 1));
                }
            }

            if (list.getFirst().compareTo(h) <= 0) {//>=第一个，覆盖所有
                list.clear();
                list.add(h);
                continue;
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) < h) {
                        list.set(i, h);
                    }
                }
                list.addLast(h);
            }

        }
        return res;
    }
}
