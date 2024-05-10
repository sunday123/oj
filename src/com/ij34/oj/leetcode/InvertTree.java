package com.ij34.oj.leetcode;

/**
 * 226. 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode left = root.left;
        invertTree(left);
        TreeNode right = root.right;
        invertTree(right);
        root.left = right;
        root.right=left;
        return root;
    }
}
