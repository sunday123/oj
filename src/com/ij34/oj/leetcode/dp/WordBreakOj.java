package com.ij34.oj.leetcode.dp;

import java.util.HashMap;
import java.util.List;

/**
 * 139. 单词拆分
 * https://leetcode.cn/problems/word-break
 * @Author: ij34
 * @Date: 2024-05-15
 */

public class WordBreakOj {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        System.out.println(new WordBreakOj().wordBreak(s, wordDict));
    }

    HashMap<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (wordDict.contains(s)) {
            return true;
        }
        for (String startWord : wordDict) {
            if (s.startsWith(startWord) && wordBreak(s.substring(startWord.length()), wordDict)) {
                map.put(startWord, true);
                return true;
            }
        }
        map.put(s,false);
        return false;
    }
}
