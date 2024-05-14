package com.ij34.oj.leetcode.tree;

import com.ij34.oj.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class FlattenOj {
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        dfs(root);
        TreeNode p = new TreeNode(0),head=p;
        for (int i=0;i<list.size();i++){
            TreeNode right= list.get(i);
            right.left=null;
            p.right=right;
            p=p.right;
        }
       root = head.right;
    }

    private void dfs(TreeNode root) {
        if (root==null){
            return;
        }
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}
