package com.ij34.oj.huawei.one.ac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 连续字母长度
 * https://hydro.ac/d/HWOD2023/p/OD251
 *
 * @Author: ij34
 * @Date: 2024-06-17
 */

public class OD251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str=sc.nextLine();
        int k=sc.nextInt();
        if (k<1){
            System.out.println(-1);
            return;
        }
        List<Integer> list = new ArrayList<>();//单个字母最多的次数
        for (int i=0;i<26;i++){
            char c = (char) (i+'A');
            String regex="["+c+"]+";
            Matcher matcher = Pattern.compile(regex).matcher(str);
            int max=0;
            while (matcher.find()){
                max=Math.max(matcher.group().length(),max);
            }
            if (max>0){
                list.add(max);
            }

        }
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(k>list.size()?-1:list.get(k-1));
    }
}
