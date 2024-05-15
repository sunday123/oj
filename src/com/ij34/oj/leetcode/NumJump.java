package com.ij34.oj.leetcode;

import java.util.Arrays;

/**
 * 55. 跳跃游戏
 * https://leetcode.cn/problems/jump-game
 * @Author: ij34
 * @Date: 2024-05-15
 */

public class NumJump {
    public static void main(String[] args) {
        int[] a =new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
       System.out.println(a.length);
        System.out.println(new NumJump().canJump(a));
    }
    public boolean canJump(int[] nums) {
         int max =0;
         for (int i=0;i<nums.length;i++){
            if (i>max){
                return false;
            }
            max=Math.max(max,i+nums[i]);
         }
         return true;
    }


    /**
     *  https://leetcode.cn/problems/jump-game-ii
     * @param nums
     * @return
     */
    public int jump(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp,nums.length+1);
        dp[0]=0;
        for (int i=1;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[j]+j>=i){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }

        }
        return dp[nums.length-1];
    }
}
