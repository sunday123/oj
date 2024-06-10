package com.ij34.oj.huawei.two.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 密码解密
 * https://hydro.ac/d/HWOD2023/p/OD379
 *
 * @Author: ij34
 * @Date: 2024-06-01
 */

public class OD379 {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder(new Scanner(System.in).nextLine());
        List<Integer> list = new ArrayList<>();
        int i=0;
        String str = stringBuilder.reverse().toString();
        while (i<str.length()){
            if (str.charAt(i)=='*'){
                list.add(Integer.valueOf(new StringBuilder(str.substring(i+1,i+3)).reverse().toString()));
                i+=3;
            }else {
                list.add(Integer.valueOf(str.substring(i,i+1)));
                i+=1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (i=list.size()-1;i>=0;i--){
            int a = list.get(i);
            if (a>=1 && a<=9){
                char c = (char) ('a' + (a-1));
                sb.append(c);
                continue;
            }
            if (a>=10 && a<=26){
                char c = (char) ('j' + (a-10));
                sb.append(c);
                continue;
            }
        }
        System.out.println(sb.toString());

    }
}
