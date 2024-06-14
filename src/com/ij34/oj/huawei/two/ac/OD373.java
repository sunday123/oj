package com.ij34.oj.huawei.two.ac;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 二叉树计算
 * https://hydro.ac/d/HWOD2023/p/OD373
 *
 * @Author: ij34
 * @Date: 2024-06-12
 */

public class OD373 {
    static class TreeNode{
        private int val;
        private TreeNode left,right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> midList = Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf).toList();
        List<Integer> preList = Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf).toList();
        TreeNode root = buildTree(midList,preList);
        TreeNode resNode = process(root);
        print(resNode);
        System.out.println(resList.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
   private static List<Integer> resList =new ArrayList<>();
    private static void print(TreeNode root) {
        if (root==null){
            return;
        }
        print(root.left);
        resList.add(root.val);
        print(root.right);


    }


    private static TreeNode process(TreeNode root) {
        if (root==null){
            return null;
        }

        TreeNode newRoot = new TreeNode(getSum(root.left)+getSum(root.right));
        newRoot.left=process(root.left);
        newRoot.right=process(root.right);
        return newRoot;
    }

    private static int getSum(TreeNode root) {
        if (root==null){
            return 0;
        }


        return root.val+getSum(root.left)+getSum(root.right);
    }

    private static TreeNode buildTree(List<Integer> midList, List<Integer> preList) {
        if (midList==null || preList.isEmpty()){
            return null;
        }
        int pre = preList.get(0);
        int midIndex=-1;
        for (int i=0;i<midList.size();i++){
            if (midList.get(i)==pre){
                if (check(midList.subList(0,i),preList.subList(1,i+1))){
                    midIndex=i;
                    break;
                }
            }
        }
        TreeNode root = new TreeNode(pre);
        root.left=buildTree(midList.subList(0,midIndex),preList.subList(1,midIndex+1));
        root.right=buildTree(midList.subList(midIndex+1,midList.size()),preList.subList(midIndex+1,preList.size()));
        return root;


    }
    private static boolean check(List<Integer> subList, List<Integer> list) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int a: subList){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for (int a: list){
            map.put(a,map.getOrDefault(a,0)-1);
        }

        for (int a : map.values()){
            if (a!=0){
                return false;
            }
        }
        return true;

    }
}
