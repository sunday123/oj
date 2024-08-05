package com.ij34.oj.leetcode.array;

import java.util.*;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 * https://leetcode.cn/problems/insert-delete-getrandom-o1
 *
 * @Author: ij34
 * @Date: 2024-08-05
 */

public class RandomizedSet {


   private List<Integer> list;
   private Map<Integer,Integer> map;

    private Random random=new Random();

    public RandomizedSet() {
        list=new ArrayList<>();
        map=new HashMap<>();

    }

    public boolean insert(int val) {
        if (map.containsKey(val)==false){
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }
        return false;

    }

    public boolean remove(int val) {
        if (map.containsKey(val)==false){
            return false;
        }
        int index=map.get(val);
        //如果是最后一个元素
        if (index==list.size()-1){
            map.remove(val);
            list.remove(index);
            return true;
        }


        //和最后一个元素交换
        Integer last = list.get(list.size()-1);
        list.set(index,last);
        list.remove(list.size()-1);
        map.remove(val);
        map.put(last,index);
        return true;
    }

    public int getRandom() {
         return list.get(random.nextInt(list.size()));
    }

}
