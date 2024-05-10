package com.ij34.oj.leetcode;

import java.util.Arrays;

/**
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0){
            return null;
        }else if (nums.length==1){
            return new TreeNode(nums[0]);
        }
        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        if (mid>0){
            root.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
        }
        if (mid<nums.length-1){
            root.right=sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,nums.length));
        }

        return root;
    }
}
