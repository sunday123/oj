package com.ij34.oj.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * https://leetcode.cn/problems/path-sum-ii
 *
 * @Author: ij34
 * @Date: 2024-07-10
 */

public class LC113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resList = new ArrayList<>();
        dfs(root,targetSum,resList,new LinkedList<>());
        return resList;
    }

    private void dfs(TreeNode root, int target, List<List<Integer>> resList, LinkedList<Integer> list) {
        if (root==null){
            return;
        }

        if (root.right==null && root.left==null){
            if (root.val==target){
                List<Integer> tempList = new ArrayList<>(list);
                tempList.add(root.val);
                resList.add(tempList);
            }

            return;
        }

        list.addLast(root.val);
        dfs(root.left,target-root.val,resList,list);
        dfs(root.right,target-root.val,resList,list);
        list.removeLast();


    }


}
