package com.ij34.oj.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * 56. 合并区间
 * https://leetcode.cn/problems/merge-intervals
 *
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int i=0;i<intervals.length;i++){
            list.add(intervals[i]);
        }
        Collections.sort(list, (a, b) -> {
            if (a[0]!=b[0]){
                return a[0]-b[0];
            }
            return b[1]-a[1];

        });
        List<int[]> resList = new ArrayList<>();
        int[] pre=list.get(0);
        for (int i=1;i<list.size();i++){
            int[] cur=list.get(i);
            if (cur[1]<=pre[1]){//包含
            }else if (cur[0]>pre[1]){//不相交
                resList.add(pre);
                pre=cur;
            }else{//相交
                pre[1]=cur[1];

            }

        }
        resList.add(pre);

        int[][] res= new int[resList.size()][2];
        for (int i=0;i< resList.size();i++){
            res[i]=resList.get(i);
        }
        return res;



    }



}
