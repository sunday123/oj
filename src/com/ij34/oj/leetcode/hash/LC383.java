package com.ij34.oj.leetcode.hash;

/**
 * 383. 赎金信
 * https://leetcode.cn/problems/ransom-note
 *
 * @Author: ij34
 * @Date: 2024-08-06
 */

public class LC383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] a = new int[26];
        int[] b = new int[26];
        for (char c : ransomNote.toCharArray()){
            a[c-'a']++;
        }
        for (char c : magazine.toCharArray()){
            b[c-'a']++;
        }
        for (int i=0;i<26;i++){
            if (a[i]>b[i]){
                return false;
            }
        }
        return true;
    }
}
