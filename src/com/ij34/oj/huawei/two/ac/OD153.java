package com.ij34.oj.huawei.two.ac;

import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * 求满足条件的最长子串的长度
 * https://hydro.ac/d/HWOD2023/p/OD153
 * @Author: ij34
 * @Date: 2024-06-02
 */

public class OD153 {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        System.out.println(processStr(str));



    }

    private static int processStr(String s) {
        int res=-1;
        if (s.length()<2){
            return res;
        }
        int start =0,next=1;
        LinkedList<Character> list = new LinkedList<>();
        Character inLetter= Character.MIN_VALUE;
        for (char c : s.toCharArray()){
            if (list.isEmpty()){
                list.addLast(c);
                if (Character.isLetter(c)){
                    inLetter=c;
                }
                continue;
            }
            if (Character.isDigit(c)){
                list.addLast(c);
                continue;
            }

            //字母
            if (inLetter==Character.MIN_VALUE){
                list.addLast(c);
                inLetter=c;
                continue;
            }

            if (list.getFirst().equals(inLetter)){
                list.removeFirst();
                list.addLast(c);
                inLetter=c;
                continue;
            }
            //字母在中间或后面
            if (list.size()>1 && inLetter!=Character.MIN_VALUE){
                res= Math.max(res,list.size());
            }

            while (list.isEmpty()==false && list.removeFirst().equals(inLetter)==false){
            }
             list.addLast(c);
             inLetter=c;
        }

        if (list.size()>1 && inLetter!=Character.MIN_VALUE){
            res= Math.max(res,list.size());
        }

        return res;
    }

}
