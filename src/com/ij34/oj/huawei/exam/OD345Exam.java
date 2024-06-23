package com.ij34.oj.huawei.exam;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author: ij34
 * @Date: 2024-06-23
 */

public class OD345Exam {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>(Arrays.stream(new Scanner(System.in).nextLine()
                .split("")).map(m->m.charAt(0)).collect(Collectors.toList()));
        while (list.contains('<')){
            int i=list.indexOf('<');
            list.remove(i);
            if (i>0){
                if (!Character.isSpaceChar(list.get(i-1))){
                    list.remove(i-1);
                }
            }
        }

        String str = list.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(str+","+process(str,list));



    }

    private static boolean process(String str, List<Character> list) {
        if (str.length()<8){
            return false;
        }
        for (Character c:list){
            if (Character.isSpaceChar(c)){
                return false;
            }
        }
        if (Pattern.compile("[A-Z]+").matcher(str).find()==false){
            return false;
        }
        if (Pattern.compile("[a-z]+").matcher(str).find()==false){
            return false;
        }
        if (Pattern.compile("[0-9]+").matcher(str).find()==false){
            return false;
        }
        if (str.split("[0-9a-zA-Z]+").length<1){
            return false;
        }
        return true;

    }
}
