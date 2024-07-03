package com.ij34.oj.leetcode.dp;

/**
 * 96. 不同的二叉搜索树
 * https://leetcode.cn/problems/unique-binary-search-trees
 *
 * n个节点
 * G(n)=f(1)+f(2)+...+f(n)[f(i)代表i为根节点的个数]
 * f(i)=G(i-1)*G(n-i)
 * G(i)=G(j-1)*G(i-j).......+
 *
 * @Author: ij34
 * @Date: 2024-07-03
 */

public class LC96 {


    public  int numTrees(int n) {
        int[] dp = new int[Math.max(n+1,5)];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=5;
        if (dp[n]>0){
            return dp[n];
        }
        for (int i=4;i<=n;i++){
            int count=0;
            for (int j=1;j<=i;j++){
               count+=dp[j-1]*dp[i-j];
            }
            dp[i]=count;
        }


        return dp[n];
    }


}
