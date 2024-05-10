package com.ij34.oj.leetcode;

/**
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class TreeNodeLeetCodeOj {
    /**
     * 104. 二叉树的最大深度
     * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
       if (root==null){
           return 0;
       }
       int left = maxDepth(root.left);
       int right = maxDepth(root.right);
       return left>right?left+1:right+1;
    }

    /**
     * 226. 翻转二叉树
     * https://leetcode.cn/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
     * @param root
     * @return
     */
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

    /**
     * 543. 二叉树的直径
     * https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
     * @param root
     * @return
     */
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
