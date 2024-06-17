package com.ij34.oj.huawei.one.ac;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 考勤信息
 * https://hydro.ac/d/HWOD2023/p/OD266
 *
 * @Author: ij34
 * @Date: 2024-06-17
 */

public class OD266 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        StringJoiner sj = new StringJoiner(" ");
        for (int i=0;i<n;i++){
            sj.add(""+process(sc.nextLine().split(" ")));
        }
        System.out.println(sj);
    }

    private static boolean process(String[] s) {
        int absent=0;
        if (s[0].equals("absent")){
            absent++;
        }
        for (int i=1;i<s.length;i++){
            if (List.of("late","leaveearly").contains(s[i-1]) && List.of("late","leaveearly").contains(s[i])){
                return false;
            }
            if (s[i].equals("absent")){
                absent++;
            }
            if (absent>1){
                return false;
            }

        }

        int l=0,r= Math.min(6,s.length-1);
        int count=0;
        for (int i=l;i<=r;i++){
            if ("present".equals(s[i])==false){
                count++;
            }
        }
        if (count>3){
            return false;
        }
        while (r<s.length){

            if (count>3){
                return false;
            }
            if (s[l].equals("present")==false){
                count--;
            }
           l++;
           r++;
           if (r>=s.length){
               break;
           }
            if (s[r].equals("present")==false){
                count++;
            }
        }
        return true;
    }
}
