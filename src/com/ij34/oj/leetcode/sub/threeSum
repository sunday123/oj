package com.ij34.oj.leetcode.sub;

import java.util.*;

/**
 * 15. 三数之和
 * https://leetcode.cn/problems/3sum
 *
 * @Author: ij34
 * @Date: 2024-05-21
 */

public class ThreeSum {
    public static void main(String[] args) {



        new ThreeSum().threeSum(Arrays.stream(new Scanner(System.in).nextLine().split(",")).mapToInt(Integer::parseInt).toArray()).forEach(System.out::println);
    }

    private List<List<Integer>> resList = new ArrayList<>();
    private Set<String> hash = new HashSet<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int start = 0,end=nums.length-1;
        if (nums[start]>0 || nums[end]<0 || end-start<2){
            return resList;
        }
        int i=start;
        while (i<end-1){
            int j =end;
            while (j-i>1){
                int mid = isFind(nums,i+1,j-1,0-nums[i]-nums[j]);
                if (mid>0){
                    List<Integer> list =List.of(nums[i],nums[mid],nums[j]);
                    if (hash.contains(list.toString())==false){
                        resList.add(list);
                        hash.add(list.toString());
                    }                }
                j--;
            }
            i++;
        }
     return resList;
    }

    private int isFind(int[] nums, int start, int end, int k) {
        if (end<start){
            return -1;
        }
        int mid =(start+end)/2;
        if (nums[mid]==k){
            return mid;
        }else if (nums[mid]>k){
            return isFind(nums,start,mid-1,k);
        }else {
            return isFind(nums,mid+1,end,k);
        }
    }
}
