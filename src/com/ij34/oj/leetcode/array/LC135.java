package com.ij34.oj.leetcode.array;

import java.util.Arrays;

/**
 * 135. 分发糖果
 * https://leetcode.cn/problems/candy/
 *
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC135 {

    public int candy(int[] ratings) {
        if (ratings.length<2){
            return ratings.length;
        }
        int[] candy = new int[ratings.length];
        Arrays.fill(candy,1);
        for (int i=1;i<ratings.length;i++){
            if (ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1]+1;
            }
        }
        System.out.println(Arrays.toString(candy));
        for (int i=ratings.length-2;i>=0;i--){
            if (ratings[i]>ratings[i+1] && candy[i]<=candy[i+1]){
                candy[i]=candy[i+1]+1;
            }
        }
        System.out.println(Arrays.toString(candy));
        return Arrays.stream(candy).sum();


    }



}
