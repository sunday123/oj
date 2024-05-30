package com.ij34.oj.huawei.one.ac;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 生成哈夫曼树
 * @Author: ij34
 * @Date: 2024-05-05
 */

public class BuildHuffmanNode {

    static class HuffmanNode{
        public int weight,height;
        public HuffmanNode left,right;

        public HuffmanNode(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>((Comparator<HuffmanNode>) (a, b) -> {
            if (a.weight!=b.weight){
                return a.weight-b.weight;
            }
            return a.height-b.height;
        });
        for (int i=0;i<n;i++){
            int a= sc.nextInt();
            queue.offer(new HuffmanNode(a,0));
        }
        HuffmanNode root = buildHuffmanTree(queue);
        System.out.println(inOrder(new StringBuilder(),root));
    }

    private static String inOrder(StringBuilder sb,HuffmanNode root) {
        if (root==null){
            return null;
        }
        inOrder(sb,root.left);
        sb.append(root.weight+" ");
        inOrder(sb,root.right);
        return sb.toString().trim();
    }

    private static HuffmanNode buildHuffmanTree(PriorityQueue<HuffmanNode> queue) {
        while (queue.size()>1){
            HuffmanNode a = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode parent  = new HuffmanNode(a.weight + right.weight,Math.max(a.height,right.height)+1);
            parent.left=a;
            parent.right=right;
            queue.offer(parent);
        }
        return queue.poll();
    }

}
