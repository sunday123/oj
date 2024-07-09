package com.ij34.oj.leetcode.array;

import java.util.Arrays;

/**
 * @Author: ij34
 * @Date: 2024-07-08
 */

public class LCLongestWord1715 {

    public String longestWord(String[] words) {

        Arrays.sort(words, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return b.length() - a.length();
        });
        System.out.println(Arrays.toString(words));
        for (int i=0;i<words.length;i++){
            if (process(words,words[i],i)){
                return words[i];
            }
        }
        return "";

    }

    private boolean process(String[] words, String word,int i) {
        if (word.isEmpty()){
            return true;
        }
        for (int j=i+1;j< words.length;j++){
             if (word.startsWith(words[j]) && process(words,word.substring(words[j].length()),i)){
                return true;
            }
        }
        return false;
    }


}
