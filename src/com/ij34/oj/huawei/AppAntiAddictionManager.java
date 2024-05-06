package com.ij34.oj.huawei;
/**
 * 手机App防沉迷系统
 */

import java.util.*;

class TaskTimeDto{
    private String name;
    private int score;
    private int start;
    private int end;

    public TaskTimeDto(String name, int score, int start, int end) {
        this.name = name;
        this.score = score;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
public class AppAntiAddictionManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        ArrayDeque<TaskTimeDto> deque = new ArrayDeque();
        for (int i=0;i<n;i++){
            TaskTimeDto last = deque.isEmpty()?null:deque.poll();
            String str =sc.nextLine();
            String[] s = str.split(" ");
            int score = Integer.valueOf(s[1]);
            int start = Integer.valueOf(s[2].replace(":",""));
            int end = Integer.valueOf(s[3].replace(":",""));

            if (last==null){
                deque.addLast(new TaskTimeDto(s[0],score,start,end));
                continue;
            }
            if (start>=last.getEnd()){
                deque.addLast(last);
                deque.addLast(new TaskTimeDto(s[0],score,start,end));
                continue;
            }
            if (score>last.getScore()){
                if (start>last.getStart()){
                    last.setEnd(start);
                    deque.addLast(last);
                }
                deque.addLast(new TaskTimeDto(s[0],score,start,end));
            }
        }
        int k = Integer.valueOf(sc.nextLine().replace(":",""));
        String res ="NA";
        while (!deque.isEmpty()){
            TaskTimeDto t =deque.poll();
            if (k>=t.getStart() && k<t.getEnd()){
                res=t.getName();
                break;
            }
        }
        System.out.println(res);
    }
}