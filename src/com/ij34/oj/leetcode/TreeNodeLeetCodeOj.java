package com.ij34.oj.leetcode;

/**
 * 104. 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class TreeNodeLeetCodeOj {

    public int maxDepth(TreeNode root) {
       if (root==null){
           return 0;
       }
       int left = maxDepth(root.left);
       int right = maxDepth(root.right);
       return left>right?left+1:right+1;
    }






}
