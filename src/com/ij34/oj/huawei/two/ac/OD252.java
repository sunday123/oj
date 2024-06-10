package com.ij34.oj.huawei.two.ac;

import java.util.Scanner;

/**
 * 拼接URL
 * https://hydro.ac/d/HWOD2023/p/OD252
 * @Author: ij34
 * @Date: 2024-06-02
 */

public class OD252 {
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        int index = s.indexOf(",");
        String pre = s.substring(0,index);
        String end =s.substring(index+1);
        pre=pre.replaceAll("/+$","");
        end=end.replaceAll("^/+","");
        System.out.println(pre+"/"+end);
    }
}
