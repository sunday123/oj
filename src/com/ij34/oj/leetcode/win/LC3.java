package com.ij34.oj.leetcode.win;

import java.util.HashSet;
import java.util.Set;

/**
 *  3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 *
 * @Author: ij34
 * @Date: 2024-06-23
 */

public class LC3 {

    public  int lengthOfLongestSubstring(String s) {
        if (s.length()<2){
            return s.length();
        }
        char[] cs=s.toCharArray();
        int l=0,r=0,max=0,len=cs.length;
        Set<Character> set = new HashSet<>();
        while (r<len){
            if (set.contains(cs[r])==false){
                set.add(cs[r]);
                r++;
                continue;
            }else {
                max=Math.max(r-l,max);
                while (set.contains(cs[r])==true){
                    set.remove(cs[l]);
                    l++;
                }
            }

        }
        max=Math.max(max,r-l);


        return max;
    }


}
