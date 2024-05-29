package com.ij34.oj.huawei.test;

import java.util.Scanner;

public class InvestmentOptimizer {
    public static void main(String[] args) {
        // 读取输入
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int N = scanner.nextInt();
        int X = scanner.nextInt();

        int[] rates = new int[m];
        int[] risks = new int[m];
        int[] max_investments = new int[m];

        for (int i = 0; i < m; i++) {
            rates[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            risks[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            max_investments[i] = scanner.nextInt();
        }

        // 初始化结果
        int[] best_investments = new int[m];
        int max_return = 0;

        // 枚举所有可能的组合
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                for (int invest_i = 0; invest_i <= max_investments[i]; invest_i++) {
                    for (int invest_j = 0; invest_j <= max_investments[j]; invest_j++) {
                        if (i == j && invest_i + invest_j > max_investments[i]) continue;
                        int total_investment = invest_i + invest_j;
                        int total_risk = risks[i] + (i == j ? 0 : risks[j]);
                        if (total_investment <= N && total_risk <= X) {
                            int total_return = invest_i * rates[i] + invest_j * rates[j];
                            if (total_return > max_return) {
                                max_return = total_return;
                                best_investments = new int[m];
                                best_investments[i] = invest_i;
                                best_investments[j] = invest_j;
                            }
                        }
                    }
                }
            }
        }

        // 输出结果
        for (int invest : best_investments) {
            System.out.print(invest + " ");
        }
    }
}
