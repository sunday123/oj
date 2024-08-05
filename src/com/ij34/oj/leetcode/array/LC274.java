package com.ij34.oj.leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 274. H 指数
 * https://leetcode.cn/problems/h-index
 *
 * @Author: ij34
 * @Date: 2024-08-05
 */

public class LC274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h=0,i=citations.length-1;
        while (i>=0 && citations[i]>h){
            h++;
            i--;
        }
        return h;
    }

}
