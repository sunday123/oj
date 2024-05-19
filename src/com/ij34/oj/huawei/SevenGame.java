package com.ij34.oj.huawei;



/**
 * A、B两个人玩抢7游戏，游戏规则为：A先报一个起始数字 X（10 ≤ 起始数字 ≤ 10000），B报下一个数字 Y （X - Y < 3），A再报一个数字 Z（Y - Z < 3），以此类推，直到其中一个抢到7，抢到7即为胜者；在B赢得比赛的情况下，一共有多少种组合？
 * 例子：输入10，输出1。因为只有一种赢的组合，A起始选择10，B接着选择9，A接着选择8，B接着选择7赢得胜利。
 * @Author: ij34
 * @Date: 2024-05-19
 */


public class SevenGame {

    private static int getResult(int m) {
        // dpA[i] 表示 A 叫 数字i 的方案数
        int[] dpA = new int[m + 2];
        // 由于是A从m开始叫，因此A叫m的方案数为1
        dpA[m] = 1;
        // dpB[i] 表示 B叫 数字i 的方案数
        int[] dpB = new int[m + 2];

        for (int i = m - 1; i >= 6; i--) {
            // B叫数字i的方案数 = A叫数字i+1的方案数 + A叫数字i+2的方案数
            dpB[i] = dpA[i + 1] + dpA[i + 2];
            // A叫数字i的方案数 = B叫数字i+1的方案数 + B叫数字i+2的方案数
            dpA[i] = dpB[i + 1] + dpB[i + 2];
        }
        // 返回B叫7的方案数
        return dpB[7];
    }


    // 递归函数，返回从start开始，当前是A的回合时，B赢的所有组合数;回超时
    public static int countCombinations(int start, boolean isATurn) {
        // 如果到达7，判断是谁的回合
        if (start == 7) {
            return isATurn ? 0 : 1;  // 如果是A的回合，A赢，否则B赢
        }

        // 如果已经超过了7，则不可能赢
        if (start < 7) {
            return 0;
        }

        int count = 0;
        // A或B可以选择start-1或start-2
        count += countCombinations(start - 1, !isATurn);
        count += countCombinations(start - 2, !isATurn);

        return count;
    }


}
