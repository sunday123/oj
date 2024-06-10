package com.ij34.oj.huawei.two.ac;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 字符串分割(二
 * https://hydro.ac/d/HWOD2023/p/OD154
 *
 * @Author: ij34
 * @Date: 2024-06-02
 */

public class OD154 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.valueOf(sc.nextLine());
        String[] s =sc.nextLine().split("-");
        if (s.length==1){
            System.out.println(s[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<s.length;i++){
            sb.append(s[i]);
        }
        StringJoiner sj = new StringJoiner("-");
        sj.add(s[0]);
        for (int i=0;i<sb.length();i=i+k){
            int up=0,low=0;
            String temp ="";
            for (int j=i;j<Math.min(i+k,sb.length());j++){
                char c =sb.charAt(j);
                temp+=c;
                if (c>='A' &&  c<='Z'){
                    up++;
                }else if (c>='a' && c<='z'){
                    low++;
                }
            }
            if (up>low){
                temp = temp.toUpperCase();
            }else if (low>up){
                temp = temp.toLowerCase();
            }
            sj.add(temp);

        }

        System.out.println(sj.toString());

    }
}
