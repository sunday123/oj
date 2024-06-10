package com.ij34.oj.huawei.two.ac;

import java.sql.ClientInfoStatus;
import java.util.*;

/**
 * 执行任务赚积分
 * https://hydro.ac/d/HWOD2023/p/OD359
 * @Author: ij34
 * @Date: 2024-06-02
 */

public class OD359 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int t=Integer.valueOf(sc.nextLine());
        List<int[]>list = new ArrayList<>();
        for (int i=0;i<n;i++){
            int[] vs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(vs);
        }
        list.sort((a, b) -> a[0]-b[0]);
        int start=0,res=0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] current : list){

            if (current[0]>start){
                queue.offer(current[1]);
                start++;
                res+=current[1];
                continue;
            }

            if (queue.isEmpty()){
                continue;
            }
            int score = queue.peek();
            if (current[1]>score){
                res-=queue.poll();
                queue.offer(current[1]);
                res+=current[1];
            }
        }
        while (t<queue.size()){
            res-=queue.poll();
        }
        System.out.println(res);
    }
}
