package com.ij34.oj.leetcode.tree;

import com.ij34.oj.leetcode.tree.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class LowestCommonAncestorTreeNode {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        if (root.val== p.val || root.val==q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left==null){
            return right;
        }
        if (right==null){
            return left;
        }
        return root;
    }
}
