package com.ij34.oj.huawei.two.ac;

import java.util.Scanner;

/**
 * 找数字
 * https://hydro.ac/d/HWOD2023/p/OD391
 * @Author: ij34
 * @Date: 2024-06-07
 */

public class OD391 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        char[] cs = ("0"+Integer.toBinaryString(n)).toCharArray();
        int oneCount = 0;
        int index = 0;
        for (int i=cs.length-1;i>0;i--){
            if (cs[i]=='1' && cs[i-1]=='0'){
                cs[i]='0';
                cs[i-1]='1';
                for (int j=i+1;j<cs.length-oneCount;j++){
                    cs[j]='0';
                }
                while (oneCount>0){
                    cs[cs.length-oneCount] ='1';
                    oneCount--;

                }
                break;
            }
            if (cs[i]=='1'){
                oneCount++;
            }
        }
        System.out.println(Integer.valueOf(new String(cs),2));;


    }
}
