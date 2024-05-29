package com.ij34.oj.huawei.one.wa;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 生成哈夫曼树
 * @Author: ij34
 * @Date: 2024-05-05
 */
 class HuffmanNode{
    public int val;
    public HuffmanNode left,right;
     public HuffmanNode(int value){
        this.val=value;
    }

}
public class BuildHuffmanNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=0;i<n;i++){
            queue.offer(sc.nextInt());
        }
        HuffmanNode root = buildHuffmanTree(queue);
        System.out.println(inOrder(new StringBuilder(),root));
    }

    private static String inOrder(StringBuilder sb,HuffmanNode root) {
        if (root==null){
            return null;
        }
        inOrder(sb,root.left);
        sb.append(root.val+" ");
        inOrder(sb,root.right);
        return sb.toString().trim();
    }

    private static HuffmanNode buildHuffmanTree(PriorityQueue<Integer> queue) {
        HuffmanNode right = null;
        while (queue.isEmpty()==false){
            int a = queue.poll();
            right=right==null?new HuffmanNode(queue.poll()):right;
            HuffmanNode parent  = new HuffmanNode(a + right.val);
            parent.left=new HuffmanNode(a);
            parent.right=right;
            right=parent;
        }
        return right;
    }

}
