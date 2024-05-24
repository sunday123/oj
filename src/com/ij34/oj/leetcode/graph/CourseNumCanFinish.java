package com.ij34.oj.leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 207. 课程表
 * https://leetcode.cn/problems/course-schedule
 * @Author: ij34
 * @Date: 2024-05-24
 */

public class CourseNumCanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer,Integer> numMap = new HashMap<>();
        for (int i=0;i<prerequisites.length;i++){
            List<Integer> list = map.getOrDefault(prerequisites[i][1],new ArrayList<>());
            list.add(prerequisites[i][0]);
            map.put(prerequisites[i][1],list);
            numMap.put(prerequisites[i][0],numMap.getOrDefault(prerequisites[i][0],0)+1);
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i=0;i<numCourses;i++){
            if (numMap.containsKey(i)==false){
                deque.offer(i);
            }
        }
        while (deque.isEmpty()==false){
            int a = deque.removeFirst();
            numCourses--;
            for (int b : map.getOrDefault(a,List.of())){
                numMap.put(b,numMap.getOrDefault(b,0)-1);
                if (numMap.get(b)==0){
                    deque.addLast(b);
                }
            }
        }
        return numCourses==0;
    }
}
