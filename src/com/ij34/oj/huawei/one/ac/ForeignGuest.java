package com.ij34.oj.huawei.one.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 来自异国的客人
 * https://hydro.ac/d/HWOD2023/p/OD431
 * @Author: ij34
 * @Date: 2024-04-20
 */

public class ForeignGuest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k=sc.nextLong();
        int n=sc.nextInt(),m=sc.nextInt();
        List<Long> list = new ArrayList<>();
        while (k>0){
            list.add(k%m);
            k/=m;
        }
        System.out.println(list.stream().filter(f->f==n).count());
    }
}
