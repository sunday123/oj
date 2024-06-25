package com.ij34.oj.leetcode.num;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 13. 罗马数字转整数
 * https://leetcode.cn/problems/roman-to-integer/
 *
 * @Author: ij34
 * @Date: 2024-06-23
 */

public class LC13 {

    public static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);


        char[] cs = s.toCharArray();
        int sum=0;
        for (int i=0;i<cs.length;i++){
            if (i+1<cs.length && (map.get(cs[i])*5==map.get(cs[i+1]) || (map.get(cs[i])*10==map.get(cs[i+1])))){
                sum-=map.get(cs[i]);
            }else {
                sum+=map.get(cs[i]);
            }

        }
        return sum;

    }


}
