package com.ij34.oj.leetcode.tree;

import com.ij34.oj.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * https://leetcode.cn/problems/binary-tree-right-side-view
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class RightSideViewOj {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        if (root==null){
              return res;
          }
          deque.addLast(root);
          while (deque.isEmpty()==false){
              res.add(deque.getLast().val);
              int len =deque.size();
              for (int i=0;i<len;i++){
                  if (deque.getFirst().left!=null){
                      deque.addLast(deque.getFirst().left);
                  }
                  if (deque.getFirst().right!=null){
                      deque.addLast(deque.getFirst().right);
                  }
                  deque.removeFirst();
              }
          }
          return res;
    }


}
