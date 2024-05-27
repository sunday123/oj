package com.ij34.oj.huawei;

/**
 * 员工派遣
 * https://hydro.ac/d/HWOD2023/p/OD395
 *
 * @Author: ij34
 * @Date: 2024-05-08
 */

import java.util.Scanner;
public class EmployeeAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(); // 国家x的代号
        int y = scanner.nextInt(); // 国家y的代号
        int cntx = scanner.nextInt(); // 国家x需要的员工数
        int cnty = scanner.nextInt(); // 国家y需要的员工数
        int left=1,right=1000_000_000;
        while (left<=right){
             int mid = (left+right)/2;
             if (isOk(mid,x,y,cntx,cnty)){
                 right=mid-1;
             }else {
                 left=mid+1;
             }
        }
        System.out.println(right+1);
    }

    private static boolean isOk(int total, int x, int y, int cntx, int cnty) {
        int notX = total/x;
        int notY = total/y;
        int notXNotY = total/(x*y/gcm(x,y));
        int availableX = total-notX;
        int availableY = total-notY;
        int common = total-(notX+notY-notXNotY);
        if (availableX<cntx || availableY<cnty){
            return false;
        }
        if ((availableX+availableY-common)>=cntx+cnty){
            return true;
        }
        return false;

    }


    private static int gcm(int x, int y) {
        if (x==0){
            return y;
        }
        return gcm(y%x,x);
    }


}