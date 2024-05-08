package com.ij34.oj.huawei;

/**
 * 员工派遣
 * @Author: ij34
 * @Date: 2024-05-08
 */

import java.util.Scanner;
public class EmployeeAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(); // 国家x的代号
        int y = scanner.nextInt(); // 国家y的代号
        long cntx = scanner.nextLong(); // 国家x需要的员工数
        long cnty = scanner.nextLong(); // 国家y需要的员工数
        int k=1;
        while (cntx>0 || cnty>0){
            if (cntx>0 && k%x!=0){
                cntx--;
            }else if (cnty>0 && k%y!=0){
                cnty--;
            }
            k++;
        }
        System.out.println(k-1);
    }

}