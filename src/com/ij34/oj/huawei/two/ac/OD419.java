package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 贪心歌手
 * https://hydro.ac/d/HWOD2023/p/OD419
 * @Author: ij34
 * @Date: 2024-06-04
 */

public class OD419 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int t=Integer.valueOf(s[0]),n=Integer.valueOf(s[1]);
        t -=Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sum();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        for (int i=0;i<n;i++){
            queue.offer(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        int tt=0;
        List<Integer> list = new ArrayList<>();
        while (queue.isEmpty()==false && tt<t ){
            tt++;
            int[] poll = queue.poll();
            list.add(poll[0]);
            poll[0]-=poll[1];
            if (poll[0]>0){
                queue.offer(poll);
            }
        }
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());

    }
}
