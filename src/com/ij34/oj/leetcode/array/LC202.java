package com.ij34.oj.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * https://leetcode.cn/problems/happy-number/
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC202 {
    private Set<Integer> set= new HashSet<>();
    public boolean isHappy(int n) {
        if (set.contains(n)){
            return false;
        }
        set.add(n);
        int sum=0;
        while (n>0){
            int a=n%10;
            sum+= a*a;
            n/=10;
        }
        if (sum==1){
            return true;
        }
        return isHappy(sum);
    }

}
