package com.ij34.oj.leetcode.listnode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * LCR 037. 行星碰撞
 * https://leetcode.cn/problems/XagZNi/
 * @Author: ij34
 * @Date: 2024-06-14
 */

public class XagZNi {
    public static void main(String[] args) {
        int[] a=new int[]{-2,-2,1,-2};
//        System.out.println(Arrays.toString(asteroidCollision(a)));
    }
    public  int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();//维护左边负数右边整数
        for (int i=0;i<asteroids.length;i++){
            if (list.isEmpty()){
                list.add(asteroids[i]);
                continue;
            }
            if (list.getLast()<0){//左边负数可以添加正负
                list.addLast(asteroids[i]);
                continue;
            }
            if (list.getLast()>0 && asteroids[i]>0){//左边正数，只能添加正数。
                list.addLast(asteroids[i]);
                continue;
            }
            //负数
            boolean isAddCurrent=false;
            while (list.isEmpty()==false && list.getLast()>0){
                int dif = list.getLast()+asteroids[i];
                if (dif>0){
                    isAddCurrent=false;
                    break;
                }
                if (dif==0){
                    list.removeLast();
                    isAddCurrent=false;
                    break;
                }
                isAddCurrent=true;
                list.removeLast();

            }

            if (isAddCurrent){
                list.addLast(asteroids[i]);
            }

        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
