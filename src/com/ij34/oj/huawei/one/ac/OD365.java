package com.ij34.oj.huawei.one.ac;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 传递悄悄话
 * https://hydro.ac/d/HWOD2023/p/OD365
 *
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD365 {
    static class TreeNode{
        private int val;
        private TreeNode left,right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {


        LinkedList<Integer> list= new LinkedList<>(Arrays.stream(new Scanner(System.in).nextLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList()));

        TreeNode root = buildTree(list);
        dfs(root,0);
        System.out.println(res);


    }


    private static void dfs(TreeNode root, int sum) {
        if (root==null){
            return;
        }
        if (root.val==-1){
            return;
        }


        if (root.right==null && root.left==null){
            res=Math.max(res,sum+root.val);
            return;
        }


        dfs(root.left,sum+root.val);
        dfs(root.right,sum+ root.val);
    }

    private static int res=Integer.MIN_VALUE;

    private static TreeNode buildTree(LinkedList<Integer> list) {
        if (list.isEmpty()){
            return null;
        }
        TreeNode root = new TreeNode(list.removeFirst());
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (nodeList.isEmpty()==false && list.isEmpty()==false){
            TreeNode node = nodeList.removeFirst();
            int v = list.removeFirst();
            TreeNode left = new TreeNode(v);
            node.left=left;
            nodeList.addLast(left);

            if (list.isEmpty()==false ){
                int val = list.removeFirst();
                TreeNode right = new TreeNode(val);
                node.right=right;
                nodeList.addLast(right);
            }
        }
        return root;
    }


}
