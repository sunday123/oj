package com.ij34.oj.huawei.one.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * 密码输入检测
 * https://hydro.ac/d/HWOD2023/p/OD345
 *
 * @Author: ij34
 * @Date: 2024-06-17
 */

public class OD345 {
    public static void main(String[] args) {
        String str =new Scanner(System.in).nextLine();
        List<Character> list = new ArrayList<>(Arrays.stream(str.split("")).map(m->m.charAt(0)).toList());
        while (list.contains('<')){
            int index = list.indexOf('<');
            list.remove(index);
            if (index>0 && list.get(index-1).equals(' ')==false){
                list.remove(index-1);
            }

        }

        String s =list.stream().map(m->""+m).collect(Collectors.joining());
        System.out.println(s+","+process(list,s));

    }

    private static boolean process(List<Character> list, String s) {
        if (s.length()<8){
            return false;
        }
        if (Pattern.compile("[A-Z]").matcher(s).find()==false){
            return false;
        }

        if (Pattern.compile("[a-z]").matcher(s).find()==false){
            return false;
        }
        if (Pattern.compile("[0-9]").matcher(s).find()==false){
            return false;
        }
        if (s.split("[a-zA-Z0-9]+").length<1){
            return false;
        }
        for (Character c:list){
            if (Character.isSpaceChar(c)){
                return false;
            }

        }
        return true;

    }
}
