package com.ij34.oj.leetcode.tree;

/**
 * 543. 二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }
    int res=0;
    private int dfs(TreeNode root) {
        if (root==null){
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        res=Math.max(res,l+r);
        return Math.max(l,r)+1;


    }
}
