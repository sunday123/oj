package com.ij34.oj.leetcode.tree;
/**
 * 二叉树只剪掉一边，能否分为两个和相等的二叉树
 *
 * @Author: ij34
 * @Date: 2024-05-25
 */
public class TreeCanPartition {
    public static void main(String[] args) {
        // 测试用例
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.right.left=new TreeNode(2);
        root.right.right=new TreeNode(4);

        System.out.println(new TreeCanPartition().canPartition(root));  // 应该输出false，因为不能有效裁剪成两棵和相等的树
    }

    private  boolean canPartition(TreeNode root) {
        int totalSum = getTreeSum(root);
        if (totalSum % 2 != 0) {
            return false;
        }
        // 使用数组来存储是否可以裁剪成功的标志
        checkSubtreeSum(root, totalSum / 2);
        return canPartition;
    }
    private boolean canPartition = false;

    // 计算树的总和
    private int getTreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + getTreeSum(node.left) + getTreeSum(node.right);
    }

    // 检查是否存在子树和等于targetSum，并设置canPartition标志
    private int checkSubtreeSum(TreeNode node, int targetSum) {
        if (node == null) {
            return 0;
        }

        int leftSum = checkSubtreeSum(node.left, targetSum);
        int rightSum = checkSubtreeSum(node.right, targetSum);
        int totalSum = node.val + leftSum + rightSum;

        // 如果子树和等于targetSum，并且不是整个树
        if (totalSum == targetSum && canPartition==false) {
            canPartition = true;
            return totalSum;
        }
        System.out.println(totalSum+"="+node.val+"+"+leftSum+"+"+rightSum+"|"+targetSum+"|||"+canPartition);

        return totalSum;
    }
}