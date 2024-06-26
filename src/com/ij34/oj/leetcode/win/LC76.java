package com.ij34.oj.leetcode.win;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 76. 最小覆盖子串
 * https://leetcode.cn/problems/minimum-window-substring
 *
 * @Author: ij34
 * @Date: 2024-06-26
 */

public class LC76 {
    public String minWindow(String s, String t) {
        int[] b =  new int[54];
        for (char c : t.toCharArray()){
            b[toIndex(c)]++;
        }
        int[] win =  new int[54];
        int l=0,r=0,minLen=Integer.MAX_VALUE;
        String res="";
        while (r<s.length()){
            int index =toIndex(s.charAt(r));
            if (b[index]>0){
                win[index]++;
            }
            while (check(win,b)){
                System.out.println(l+","+r+"|"+s.substring(l,r+1));
                if (r-l<minLen){
                    res=s.substring(l,r+1);
                    minLen=r-l;
                }
                int  i=toIndex(s.charAt(l));
                if (b[i]>0){
                    win[i]--;
                }
                l++;
            }
            r++;
        }

        return res;

    }

    private boolean check(int[] win, int[] b) {

        for (int i=0;i<win.length;i++){
            if (b[i]>win[i]){
                return false;
            }
        }
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(win));
        return true;
    }

    private int toIndex(char c) {
        int index=0;
        if (c>='a' && c<='z'){
            index=c-'a';
        }else {
            index=c-'A'+26;
        }
        return index;
    }
}
