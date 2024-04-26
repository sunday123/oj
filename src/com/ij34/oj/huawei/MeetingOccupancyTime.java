package com.ij34.oj.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 会议室占用时间
 * https://blog.csdn.net/2301_76848549/article/details/135987943
 * @Author: ij34
 * @Date: 2024-04-26
 */

public class MeetingOccupancyTime {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[][] roomTimes = new int[n][2];
        for (int i=0;i<n;i++){
            roomTimes[i][0] = sc.nextInt();
            roomTimes[i][1] = sc.nextInt();
        }
        Arrays.stream(merge(roomTimes)).forEach(c->{
            System.out.println(Arrays.toString(c));
        });

    }
    private static int[][] merge(int[][] roomTimes) {
        List<int[]> result = new ArrayList<>();
        Arrays.stream(roomTimes).sorted((o1, o2) -> {
            if (o1[0]==o2[0]){
                return o1[2]-o2[2];
            }
            return o1[0]-o2[0];
        }).forEach(a->{
            if (result.isEmpty()){
                result.add(a);
            }else {
                boolean flag =false;
                for (int[] c :result){
                    if (a[1]<=c[1]){
                        flag=true;
                        break;
                    }

                    if (a[0]<=c[1] ){
                        flag=true;
                        if (a[1]>c[1]){
                            int k=c[0],kk=a[1];
                            result.remove(c);
                            result.add(new int[]{k,kk});
                            break;
                        }
                    }


                }
                if (!flag){
                    result.add(a);
                }
            }
        });
        int[][] r = new int[result.size()][2];
        for (int i=0;i<result.size();i++){
            r[i]=result.get(i);
        }
        return r;

    }
}
