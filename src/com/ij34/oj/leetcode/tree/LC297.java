package com.ij34.oj.leetcode.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/description/
 *
 * @Author: ij34
 * @Date: 2024-07-03
 */


public class LC297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null){
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (list.size()>0){
                TreeNode node = list.removeFirst();
                if (node==null){
                    sb.append("null,");
                }else {
                    sb.append(node.val+",");
                    list.addLast(node.left);
                    list.addLast(node.right);
                }


        }



        sb.setLength(sb.length()-1);
        sb.append("]");
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data=data.substring(1,data.length()-1);
        if (data.isBlank()){
            return null;
        }

        LinkedList<Integer> list = new LinkedList<>(Arrays.stream(data.split(",")).map(m->{
            if ("null".equals(m)){
                return 1001;
            }
            return Integer.valueOf(m);
        }).collect(Collectors.toList()));
        TreeNode root = new TreeNode(list.removeFirst());
        ArrayDeque<TreeNode> nodeList = new ArrayDeque<>();
        nodeList.add(root);
        while (list.size()>0){
            TreeNode node = nodeList.removeFirst();
            int a =list.removeFirst();
            if (a!=1001){
                node.left=new TreeNode(a);
                nodeList.addLast(node.left);
            }
            a =list.removeFirst();
            if (a!=1001){
                node.right=new TreeNode(a);
                nodeList.addLast(node.right);
            }

        }



        return  root;
    }


    private TreeNode rebuildTree(TreeNode root) {
        if (root==null || root.val==1001){
            return null;
        }
        root.left=rebuildTree(root.left);
        root.right=rebuildTree(root.right);
        return root;
    }



}