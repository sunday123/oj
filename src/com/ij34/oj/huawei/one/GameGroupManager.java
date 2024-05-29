package com.ij34.oj.huawei.one;

import java.util.Arrays;
import java.util.Scanner;

/** 游戏分组
 * https://hydro.ac/d/HWOD2023/p/OD349
 *  1, 2, 3, 4, 5, 6, 7, 8, 9, 15
 *
 *  99 8 7 6 56 77 8 7 4 97             13
 * @Author: ij34
 * @Date: 2024-05-03
 */

public class GameGroupManager {

    public static void main(String[] args) {
        int[] a = Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int dif = diffScore(a, 0, 0, 0, new int[5], new int[5]);
        System.out.println(dif);
    }

    private static int diffScore(int[] a, int index, int i, int j, int[] b, int[] c) {
        if (index == a.length) {
            if (i == 5 && j == 5) {
                return Math.abs(Arrays.stream(b).sum() - Arrays.stream(c).sum());
            } else {
                return Integer.MAX_VALUE;
            }
        }
        Integer bMin = Integer.MAX_VALUE, cMin = Integer.MAX_VALUE;
        if (i < 5) {
            b[i] = a[index];
            bMin = diffScore(a, index + 1, i + 1, j, b, c);
        }
        if (j < 5) {
            c[j] = a[index];
            cMin = diffScore(a, index + 1, i, j + 1, b, c);
        }
        return Math.min(bMin, cMin);
    }

}