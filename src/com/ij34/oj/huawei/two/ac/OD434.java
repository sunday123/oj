package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最长子字符串的长度(二)
 * https://hydro.ac/d/HWOD2023/p/OD434
 *
 * @Author: ij34
 * @Date: 2024-06-10
 */

public class OD434 {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        int maxLen = str.length();
        str=str+str;
        str=str.substring(0,str.length()-1);
        boolean[] preLine = new boolean[3];//lox都是偶数,0开始
        boolean[] current = new boolean[3];//lox都是偶数,固定长移动窗口时候
        Arrays.fill(current,true);
        for (int i=0;i<maxLen;i++){
            process(current,str.charAt(i));
        }
        if (current[0]&&current[1]&&current[2]){
            System.out.println(maxLen);
            return;
        }
        copyOf(current,preLine);
        for (int len=maxLen-1;len>0;len--){
              //0-len
              process(preLine,str.charAt(len));
              copyOf(preLine,current);
            if (current[0]&&current[1]&&current[2]){
                System.out.println(len);
                return;
            }

            for (int i=1;i<maxLen;i++){
                  int j=i+len;//不包含j
                  process(current,str.charAt(i-1));
                process(current,str.charAt(j-1));
                if (current[0]&&current[1]&&current[2]){
                    System.out.println(len);
                    return;
                }
            }

        }

        System.out.println(0);


    }

    private static void copyOf(boolean[] source, boolean[] target) {
        for (int i=0;i<3;i++){
            target[i]=source[i];
        }
    }

    private static void process(boolean[] current, char c) {
        if (c=='l'){
            current[0]=!current[0];
        }else if (c=='o'){
            current[1]=!current[1];
        }else if (c=='x'){
            current[2]=!current[2];
        }
    }
}
