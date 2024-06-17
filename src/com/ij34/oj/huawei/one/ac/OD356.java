package com.ij34.oj.huawei.one.ac;

import java.util.Scanner;

/**
 * 分割均衡字符串
 * https://hydro.ac/d/HWOD2023/p/OD356
 *
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD356 {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        int count=0,x=0,y=0;
        for (char c :str.toCharArray()){
            if (c=='X'){
                x++;
            }else {
                y++;
            }
            if (x==y){
                count++;
            }

        }
        System.out.println(count);


    }
}
