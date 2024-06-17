package com.ij34.oj.huawei.one.ac;

import java.util.Scanner;

/**
 * 靠谱的车
 * https://hydro.ac/d/HWOD2023/p/OD242
 *
 *
 * @Author: ij34
 * @Date: 2024-06-17
 */

public class OD242 {
    public static void main(String[] args) {
        int N =new Scanner(System.in).nextInt();
        int n=N;
        //1-3 4-9
        int bit=0;//当前有多少位数
        int count=0;
        while (n>0){
            int a=n%10;
            n/=10;
            count+=process(a,bit);
            bit++;
        }
        System.out.println(count);



    }

    private static int process(int a, int bit) {//a是一共长度为1的数字
         a=a<4?a:a-1;//相当于9进制，大于4的需要减去4
        return (int) (a*Math.pow(9,bit));

    }

}
