package com.ij34.oj.leetcode;

/**
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class KthSmallestOj {

    int count=0;
    int res=0;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallest(root,k);
        return res;

    }

    private void kthSmallest2(TreeNode root,int k) {
        if (root==null){
            return;
        }

        kthSmallest2(root.left,k);
        count++;
        if (count==k){
            res= root.val;
            return;
        }
        kthSmallest(root.right,k);
    }

}
