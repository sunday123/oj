package com.ij34.oj.leetcode.stack;

import java.util.ArrayDeque;

/**
 * 84. 柱状图中最大的矩形
 * https://leetcode.cn/problems/largest-rectangle-in-histogram
 *
 * @Author: ij34
 * @Date: 2024-06-26
 */

public class LC84 {

    public static int largestRectangleArea(int[] heights) {
        int max=heights[0];
        if (heights.length<2){
            return max;
        }
        ArrayDeque<Integer> indexDeque= new ArrayDeque<>();
        for (int i=0;i<heights.length;){
            if (indexDeque.isEmpty() || heights[i]>=heights[indexDeque.getLast()]){
                indexDeque.offerLast(i);
                i++;
                continue;
            }
            int pop = indexDeque.removeLast();
            int width = indexDeque.isEmpty()?i:i-indexDeque.getLast()-1;
            max=Math.max(max,heights[pop]*width);
        }

        while (indexDeque.size()>0){
            int pop = indexDeque.removeLast();
            int width = indexDeque.isEmpty()?heights.length:heights.length-indexDeque.getLast()-1;
            max=Math.max(max,heights[pop]*width);
        }

        return max;



    }
}
