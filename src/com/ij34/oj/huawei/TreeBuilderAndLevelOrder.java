package com.ij34.oj.huawei;

import java.util.ArrayDeque;
import java.util.Scanner;


/**
 * 二叉树的广度优先遍历
 * @Author: ij34
 * @Date: 2024-05-05
 */
class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode(char val) {
        this.val = val;
    }
}

public class TreeBuilderAndLevelOrder {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String postOrder = sc.next();
        String inOrder =sc.next();
        TreeNode root = buildTree2(postOrder,inOrder);
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        StringBuilder sb =new StringBuilder();
        deque.addLast(root);
        while (deque.isEmpty()==false){
            TreeNode node = deque.removeFirst();
            sb.append(node.val);
            if (node.left!=null){
                deque.addLast(node.left);
            }
            if (node.right!=null){
                deque.addLast(node.right);
            }
        }
        System.out.println(sb.toString());

//        preOrder(root);
    }

    private static void preOrder(TreeNode root) {
        if (root==null){
            return;
        }
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);

    }

    /**
     *
     * @param postOrder
     * @param inOrder
     * @return
     */
    private static TreeNode buildTree(String postOrder, String inOrder) {
        if (postOrder.isEmpty() || inOrder.isEmpty()){
            return null;
        }
        char c = postOrder.charAt(postOrder.length()-1);
        TreeNode root = new TreeNode(c);
        int index = inOrder.indexOf(c);
        root.left=buildTree(postOrder.substring(0,index),inOrder.substring(0,index));
        root.right=buildTree(postOrder.substring(index,postOrder.length()-1),inOrder.substring(index+1));
        return root;
    }

    /**
     *
     * @param inOrder
     * @param preOrder
     * @return
     */
    private static TreeNode buildTree2(String inOrder, String preOrder) {
        if (inOrder.isEmpty() || preOrder.isEmpty()){
            return null;
        }
        char c = preOrder.charAt(0);
        TreeNode root = new TreeNode(c);

        int index = inOrder.indexOf(c);
        root.left=buildTree2(inOrder.substring(0,index),preOrder.substring(1,index+1));
        root.right=buildTree2(inOrder.substring(index+1),preOrder.substring(index+1));
        return root;
    }
}
