package com.ij34.oj.leetcode.array;

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode.cn/problems/median-of-two-sorted-arrays
 *
 * @Author: ij34
 * @Date: 2024-06-26
 */

public class LC4 {

    private  int i,count;
    private int l1=0,r1,l2=0,r2;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = nums1.length+nums2.length;
        count%=2;
        if (count==0){
            count=2;
        }
        i=nums1.length+nums2.length;
        r1=nums1.length-1;
        r2=nums2.length-1;


        while (i>count){//每次删除最大和最小值2个
            delMin(nums1,nums2);
            i--;
            delMax(nums1,nums2);
            i--;

        }

        int res=0;
        for (int i=l1;i<=r1;i++){
            System.out.println("a"+nums1[i]);
            res+=nums1[i];
        }

        for (int i=l2;i<=r2;i++){
            System.out.println("b"+nums2[i]);
            res+=nums2[i];
        }
        return count==1?res:res/2.0;

    }

    private void delMax(int[] nums1, int[] nums2) {

        if (l1<=r1 && l2<=r2){
            if (nums1[r1]<nums2[r2]){
                r2--;
            }else {
                r1--;
            }
            return;

            }

            if (l1>r1){
                r2--;
                return;
            }
            if (l2>r2){
                r1--;
                return;
            }
        //没有r1<l1 && r2<l2的情况，数组充足
    }

    private void delMin(int[] nums1, int[] nums2) {

        if (l1<=r1 && l2<=r2){
            if (nums1[l1]<nums2[l2]){
                l1++;
            }else {
                l2++;
            }
            return;
        }

        if (l1>r1){
            l2++;
            return;
        }
        if (l2>r2){
            l1++;
            return;
        }

    }

}
