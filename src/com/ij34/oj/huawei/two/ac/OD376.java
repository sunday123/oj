package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 5G网络建设
 * https://hydro.ac/d/HWOD2023/p/OD376
 * @Author: ij34
 * @Date: 2024-06-09
 */

public class OD376 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int m = Integer.valueOf(sc.nextLine());
        int[][] a = new int[m][4];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            a[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (a[i][3] == 1) {
                a[i][2] = 0;
            }
            set.add(a[i][0]);
            set.add(a[i][1]);
        }
        if (set.size() < n) {
            System.out.println(-1);
            return;
        }
        Arrays.sort(a, (o1, o2) -> {
            if (o1[2] != o2[2]) {
                return o1[2] - o2[2];
            }
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        DSUnion dsu = new DSUnion(n + 1);
        int sum = 0;
        for (int[] current : a) {
            if (dsu.find(current[0]) != dsu.find(current[1])) {
                dsu.union(current[0], current[1]);
                sum += current[2];
            }
        }
        if (dsu.count != n - 1) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
    }

    static class DSUnion {
        private int[] parent;
        private int count = 0;

        public DSUnion(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            if (parent[x] != x) {
                return find(parent[x]);
            }
            return x;
        }

        private void union(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            if (xx != yy) {
                count++;
                parent[xx] = yy;
            }

        }
    }

}
