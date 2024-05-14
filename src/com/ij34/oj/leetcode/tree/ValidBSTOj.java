package com.ij34.oj.leetcode.tree;

import com.ij34.oj.leetcode.tree.TreeNode;

/**
 * 98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class ValidBSTOj {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
}

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root==null){
            return true;
        }
        if ((min!=null && root.val<=min)||(max!=null && root.val>=max)){
            return false;
        }

        return isValidBST(root.left,min, root.val)&&isValidBST(root.right, root.val, max);
    }

    }
