package com.ij34.oj.huawei.two.wa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 学生重新排队
 * https://hydro.ac/d/HWOD2023/p/OD347
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD347 {
    static class GroupDto{
        private int groupId;
        private int count;

        public GroupDto(int groupId, int count) {
            this.groupId = groupId;
            this.count = count;
        }

        @Override
        public String toString() {
            return "{" + groupId +
                    "," + count +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] b = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        sc.close();
        int[] group = new int[b.length+1];
        for (int i=0;i<b.length;i++){
            group[b[i]]=i/3;
        }
        LinkedList<GroupDto> list = new LinkedList<>();
        for (int i=0;i<a.length;i++){
             int groupId = group[a[i]];
             if (list.isEmpty() || list.getLast().groupId!=groupId){
                 list.addLast(new GroupDto(groupId,1));
             }else {
                 list.getLast().count+=1;
             }
        }

        int res=0;
        while (list.isEmpty()==false){
            GroupDto poll =list.removeFirst();
            if (poll.count==2){// 2 1 1 2 2
                res++;
                list=process(list,poll);
            }else if (poll.count==1){// 2 1 2 1 1 2
                GroupDto next = list.getFirst();
                while (next.count==3){
                    list.removeFirst();
                    next = list.getFirst();
                }

                if (poll.groupId==next.groupId && next.count==2){
                    res++;
                    list.removeFirst();

                }else {
                    res+=2;
                    list=process(list,poll);

                }
            }
        }

        System.out.println(res);
    }

    private static LinkedList<GroupDto> process(LinkedList<GroupDto> list, GroupDto move) {
        //2 1 1 1 2 2
        LinkedList<GroupDto> resList = new LinkedList<>();
        while (list.isEmpty()==false){
            GroupDto poll = list.removeFirst();
            if (poll.groupId==move.groupId){
                continue;
            }


            if (resList.isEmpty() || resList.getLast().groupId!= poll.groupId){
                resList.addLast(poll);
            }else {
                resList.getLast().count+= poll.count;
            }
        }

        return resList;

    }
}
