package com.ij34.oj.leetcode;

import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class BuildTreeOj {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length<1 || inorder.length<1){
            return null;
        }
        int c =preorder[0];
        TreeNode root = new TreeNode(c);
        int index= getMidIndex(inorder,c);
        root.left=buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        root.right=buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return root;
    }

    private int getMidIndex(int[] inorder, int c) {
        for (int i=0;i<inorder.length;i++){
            if (inorder[i]==c){
                return i;
            }
        }
        return 0;
    }
}
