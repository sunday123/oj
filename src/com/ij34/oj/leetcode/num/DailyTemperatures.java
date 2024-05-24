package com.ij34.oj.leetcode.num;

/**
 * 739 每日温度
 * https://leetcode.cn/problems/daily-temperatures
 *
 * @Author: ij34
 * @Date: 2024-05-25
 */

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            if (i>0 && temperatures[i]==temperatures[i-1]){
                res[i]= res[i-1]>1?res[i-1]-1:res[i-1];
                continue;
            }
            int j=1;
            while(j+i<temperatures.length){
                if(temperatures[i+j]>temperatures[i]){
                    res[i]=j;
                    break;
                }
                j++;
            }
        }
        return res;
    }
}
