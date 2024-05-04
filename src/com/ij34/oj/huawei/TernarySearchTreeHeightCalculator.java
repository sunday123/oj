package com.ij34.oj.huawei;

import java.util.Scanner;

/**
 * 计算三叉搜索树的高度
 * @Author: ij34
 * @Date: 2024-05-04
 */

public class TernarySearchTreeHeightCalculator {
    private static class Node{
        private int value;
        private Node left,mid,right;

        public Node (int v) {
            value=v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i]= sc.nextInt();
        }
        if (n<3){
            System.out.println(2);
        }
        Node root =null;
        for (int i=0;i<a.length;i++){
            root=buildTree(root,a[i]);
        }
        int h =getH(root);
        System.out.println(h);
    }


    private static int getH(Node root) {
        if (root==null){
            return 0;
        }
        int a = getH(root.left);
        int b = getH(root.mid);
        int c = getH(root.right);

        if (a>=b && a>=c){
            return a+1;
        }else if (b>=a && b>=c){
            return b+1;
        }else {
            return c+1;
        }


    }
    private static Node buildTree( Node r,int val) {
        if (r==null){
            return new Node(val);
        }


        if (val< r.value-500){
            r.left=buildTree(r.left,val);;
        }else if (val> r.value+500){
            r.right=buildTree(r.right,val);
        }else {
            r.mid=buildTree(r.mid,val);;
        }
        return r;
    }


}
