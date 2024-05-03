package com.ij34.oj.huawei;

import java.util.Arrays;
import java.util.Scanner;

/** 游戏分组
 *  1, 2, 3, 4, 5, 6, 7, 8, 9, 15
 *
 *  99 8 7 6 56 77 8 7 4 97             13
 * @Author: ij34
 * @Date: 2024-05-03
 */

public class GameGroupManager {

    public static void main(String[] args) {
        int[] ratings = Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findMinDifference(ratings, 0, 0, 0, new int[5], new int[5]));
    }
    public static int findMinDifference(int[] ratings, int index, int team1Size, int team2Size, int[] team1, int[] team2) {
        if (index == ratings.length) {
            if (team1Size == 5 && team2Size == 5) {
                int sum1 = Arrays.stream(team1).sum();
                int sum2 = Arrays.stream(team2).sum();
                return Math.abs(sum1 - sum2);
            } else {
                return Integer.MAX_VALUE;
            }
        }

        int diff1 = Integer.MAX_VALUE;
        if (team1Size < 5) {
            team1[team1Size] = ratings[index];
            diff1 = findMinDifference(ratings, index + 1, team1Size + 1, team2Size, team1, team2);
        }

        int diff2 = Integer.MAX_VALUE;
        if (team2Size < 5) {
            team2[team2Size] = ratings[index];
            diff2 = findMinDifference(ratings, index + 1, team1Size, team2Size + 1, team1, team2);
        }

        return Math.min(diff1, diff2);
    }
}
