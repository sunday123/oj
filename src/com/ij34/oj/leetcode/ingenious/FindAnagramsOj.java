package com.ij34.oj.leetcode.ingenious;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class FindAnagramsOj {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(new FindAnagramsOj().findAnagrams(s,p));
    }
    public List<Integer> findAnagrams(String s, String p) {
          int[] pw = new int[26];
          for (char c: p.toCharArray()){
              pw[c-'a']=pw[c-'a']+1;
          }
          int len = p.length();
          List<Integer> resList = new ArrayList<>();
          int left=0,right=0;
          char[] cs = s.toCharArray();
          int[] sw= new int[26];
          while (right<s.length()){
              sw[cs[right]-'a']=sw[cs[right]-'a']+1;
              if (right-left+1==len){
                  if (isEq(sw,pw)){
                      resList.add(left);
                  }
                  sw[cs[left]-'a']--;
                  left++;
              }
              right++;
          }
          return resList;
    }

    private boolean isEq(int[] sw, int[] pw) {
        for (int i=0;i<sw.length;i++){
            if (sw[i]!=pw[i]){
                return false;
            }
        }
        return true;
    }
}
