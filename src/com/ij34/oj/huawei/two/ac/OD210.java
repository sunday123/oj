package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 停车场车辆统计
 * https://hydro.ac/d/HWOD2023/p/OD210
 * @Author: ij34
 * @Date: 2024-06-04
 */

public class OD210 {
    public static void main(String[] args) {
        String cars = new Scanner(System.in).nextLine();
        cars=cars.replaceAll(",","")
                .replaceAll("111","3")
                .replaceAll("11","2");
        System.out.println(Arrays.stream(cars.split("")).filter(f->"0".equals(f)==false).mapToInt(Integer::parseInt).count());

    }
}
