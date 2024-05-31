package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Wonderland
 * https://hydro.ac/d/HWOD2023/p/OD414
 *
 * @Author: ij34
 * @Date: 2024-05-31
 */

public class Wonderland {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] costs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> dayList = Arrays.stream(sc.nextLine().split(" ")).map(m -> Integer.valueOf(m)).collect(Collectors.toList());
        System.out.println(minDp(costs, dayList));
    }

    private static int minDp(int[] costs, List<Integer> dayList) {
        int[] dp = new int[dayList.get(dayList.size() - 1) + 1];
        for (int i = 1; i < dp.length; i++) {
            if (dayList.contains(i) == false) {
                dp[i] = dp[i - 1];//在非游玩天数，dp[i]应继承前一天的值，因为当天不需要额外的花费
                continue;
            }

            // 第一个不能Math.min(dp[i], (i -1>0?dp[i - 1]:0) + costs[0]);
            dp[i] = (i - 1 > 0 ? dp[i - 1] : 0) + costs[0];// dp[i - 1] + costs[0];
            dp[i] = Math.min(dp[i], (i -3>0?dp[i - 3]:0) + costs[1]);
            dp[i] = Math.min(dp[i], (i -7>0?dp[i - 7]:0) + costs[2]);
            dp[i] = Math.min(dp[i], (i -30>0?dp[i - 30]:0)+ costs[3]);

        }
        return dp[dp.length - 1];
    }

    private static int minCost = Integer.MAX_VALUE;

    //数据量大会通不过
    private static void dfs(int[] costs, List<Integer> dayList, int start, int maxIndex, int currentCost) {
        while (start <= maxIndex && dayList.contains(start) == false) {
            start++;
        }


        if (currentCost >= minCost) {
            return;
        }

        List<Integer> indexCost = List.of(1, 3, 7, 30);
        if (start > maxIndex) {
            minCost = Math.min(minCost, currentCost);
            return;
        }


        for (int i = 0; i < 4; i++) {
            currentCost += costs[i];
            start += indexCost.get(i);
            dfs(costs, dayList, start, maxIndex, currentCost);
            currentCost -= costs[i];
            start -= indexCost.get(i);

        }
    }
}
