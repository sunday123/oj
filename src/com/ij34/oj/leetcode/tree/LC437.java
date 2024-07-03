package com.ij34.oj.leetcode.tree;

/**
 * 437. 路径总和 III
 * https://leetcode.cn/problems/path-sum-iii
 *
 * @Author: ij34
 * @Date: 2024-07-03
 */

public class LC437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root==null){
            return 0;
        }
        int count=  calCount(root,targetSum);
        return count+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }

    private int calCount(TreeNode root, long targetSum) {
        if (root==null){
            return 0;
        }
        int count= targetSum-root.val==0?1:0;
        return count+calCount(root.left,targetSum-root.val)+calCount(root.right,targetSum-root.val);
    }

}
