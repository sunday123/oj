package com.ij34.oj.huawei.two.wa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 文本统计分析
 * https://hydro.ac/d/HWOD2023/p/OD386
 * @Author: ij34
 * @Date: 2024-06-16
 */

public class OD386 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if (line.isEmpty()){
                break;
            }
            line=line.replaceAll("\".*\"","a")
                    .replaceAll("--.*","a")
                    .replaceAll("\'.*\'","a")
                    .replaceAll("\\s+","")
                    .replaceAll(";+",";")
                    ;
            sb.append(line);
        }
        sb.append(";");
        String str =sb.toString().replaceAll("\\(.*\\)","a").replaceAll(";+",";");
        int count=0;
        for (String s : str.split(";")){
            if (s.trim().isEmpty()==false){
                count++;
            }
        }
        System.out.println(count);

    }
}
