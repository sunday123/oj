package com.ij34.oj.huawei.two.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 最长子字符串的长度（一）
 * https://hydro.ac/d/HWOD2023/p/OD343
 * @Author: ij34
 * @Date: 2024-06-02
 */

public class OD343 {
    public static void main(String[] args) {
        char[] chars = new Scanner(System.in).nextLine().toCharArray();
        List<Character> list = new ArrayList<>();
        for(int c=0;c<2;c++){
            for (int i=0;i<chars.length;i++){
                list.add(chars[i]);
            }
        }
        int count = oCount(list,0,chars.length);
        if (count%2==0){
            System.out.println(chars.length);
            return;
        }
        for (int len=chars.length-1;len>0;len--){
            for (int i=0;i<chars.length;i++){
                count = oCount(list,i,i+len);
                if (count%2==0){
                    System.out.println(len);
                    return;
                }
            }

        }
        System.out.println(0);
    }

    private static int oCount(List<Character> list, int i, int j) {
        int c =0;
        for (int l=i;l<j;l++){
            if (list.get(l)=='o'){
                c++;
            }
        }
        return c;
    }
}
