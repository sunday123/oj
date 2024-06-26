package com.ij34.oj.leetcode.tree;

/**
 * 124. 二叉树中的最大路径和
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum
 *
 * @Author: ij34
 * @Date: 2024-06-26
 */

public class LC124 {
    private int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        cal(root);
        return res;
    }

    private int cal(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left=cal(root.left);
        int right = cal(root.right);
        int sum=Math.max(Math.max(left,right)+root.val,root.val);
        res=Math.max(Math.max(res,sum), root.val+left+right);
        return sum;

    }

}
