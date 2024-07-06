package com.ij34.oj.leetcode.sort;

import java.util.*;

/**
 * 406. 根据身高重建队列
 * https://leetcode.cn/problems/queue-reconstruction-by-height
 *
 * @Author: ij34
 * @Date: 2024-07-04
 */

public class LC406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length<2){
            return people;
        }
        List<int[]> list = Arrays.stream(people).sorted((a, b) -> {
            if (a[1]==b[1]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        }).toList();
        System.out.println();
        int index=0;
        while (++index<list.size()){//插入排序，找到数量大于的自身数量的个数的位置插入。到该位置，后移动
            if (list.get(index)[1]==0){
                continue;
            }
            int count=0,findIndex=0;
            for (int i=0;i<=index;i++){
                if (list.get(i)[0]>=list.get(index)[0]){
                    count++;
                }
                if (count>list.get(index)[1]){
                    findIndex=i;
                    break;
                }else {
                    findIndex=i;
                }
            }

            if (index==findIndex ){
                continue;
            }


            int a = list.get(index)[0],b=list.get(index)[1];
            int i=index;
            while (i>findIndex){
                list.get(i)[0]=list.get(i-1)[0];
                list.get(i)[1]=list.get(i-1)[1];
                i--;
            }
            list.get(findIndex)[0]=a;
            list.get(findIndex)[1]=b;

        }
        for (int i=0;i<people.length;i++){
            people[i]=list.get(i);
        }
        return people;
    }
}